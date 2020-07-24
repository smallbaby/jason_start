package com.jason.jason_start.netty;

import com.fasterxml.jackson.core.util.BufferRecycler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 * Author: Jason
 * Date 2020/5/30
 */
public class GeneralServletMain {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = "";
        while ((line = reader.readLine()) != null) {
            System.out.println("received:" + line);
        }
    }
}
