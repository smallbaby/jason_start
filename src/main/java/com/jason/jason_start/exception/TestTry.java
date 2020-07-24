package com.jason.jason_start.exception;

import java.io.*;

/**
 * 测试try-with-resources
 * Author: Jason
 * Date 2020/7/18
 */
public class TestTry {
    public static void main(String[] args) throws IOException {
        copy("", "");
    }

    private static void copy(String src, String dst) throws IOException {
        int BUFFER_SIZE = 1024;
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst);
        ) {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) > -1) {
                out.write(buf, 0, n);
            }
        }
    }
}
