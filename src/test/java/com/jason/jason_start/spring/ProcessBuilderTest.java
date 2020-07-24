package com.jason.jason_start.spring;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Author: Jason
 * Date 2020/7/9
 */
public class ProcessBuilderTest {
    @Test
    public void testProcessId() throws IOException {
        String[] xx = partitionCommandLine("cgexec -g cpu:scheduler/job1 sh a.sh");
        for (String x: xx) {
            System.out.println(x);
        }
        ProcessBuilder builder = new ProcessBuilder(xx);
        builder.directory(new File("/Users/zhangkai/tmp"));
        builder.environment().putAll(new HashMap<>());

        Process process = builder.start();
        final InputStream inputStream = process.getInputStream();
        final InputStream errorStream = process.getErrorStream();
        String threadName = "helloworold";
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (Exception e) {
                }
            }
        }, threadName).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(errorStream));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (Exception e) {
                }
            }
        }, threadName).start();

        int exitCode = -999;
        try {
            exitCode = process.waitFor();
        } catch (InterruptedException e) {
        } finally {
            process = null;
        }

        // test2();
    }

    private void test2() {
        List<String> command = new ArrayList<>();
        command.add("ping");
        command.add("www.baidu.com");
        try {
            ProcessBuilder builder = new ProcessBuilder(command);
            builder.redirectErrorStream(true);
            Process process = builder.start();
            InputStream in = process.getInputStream();
            byte[] re = new byte[1024];
            while (in.read(re) != -1) {
                System.out.println("==>" + new String(re));
            }
            in.close();
            if (process.isAlive()) {
                process.waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String[] partitionCommandLine(String command) {

        ArrayList<String> commands = new ArrayList<String>();

        String os = System.getProperties().getProperty("os.name");
        if (os != null && (os.startsWith("win") || os.startsWith("Win"))) {
            commands.add("CMD.EXE");
            commands.add("/C");
            commands.add(command);
        } else {
            int index = 0;

            StringBuffer buffer = new StringBuffer(command.length());

            boolean isApos = false;
            boolean isQuote = false;
            while (index < command.length()) {
                char c = command.charAt(index);

                switch (c) {
                    case ' ':
                        if (!isQuote && !isApos) {
                            String arg = buffer.toString();
                            buffer = new StringBuffer(command.length() - index);
                            if (arg.length() > 0) {
                                commands.add(arg);
                            }
                        } else {
                            buffer.append(c);
                        }
                        break;
                    case '\'':
                        if (!isQuote) {
                            isApos = !isApos;
                        } else {
                            buffer.append(c);
                        }
                        break;
                    case '"':
                        if (!isApos) {
                            isQuote = !isQuote;
                        } else {
                            buffer.append(c);
                        }
                        break;
                    default:
                        buffer.append(c);
                }

                index++;
            }

            if (buffer.length() > 0) {
                String arg = buffer.toString();
                commands.add(arg);
            }
        }
        return commands.toArray(new String[commands.size()]);
    }
}
