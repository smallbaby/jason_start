package com.jason.jason_start.netty.demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * ServerBootStrap 引导类 启动的辅助类
 * EventLoopGroup 线程池 用来分配channel i/o 和事件
 * boss 处理客服端连接
 * worker 处理客户端的数据读写工作
 * ServerHandler 业务逻辑
 * Author: Jason
 * Date 2020/5/30
 */
public class Server {
    private final int port;

    public Server(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws InterruptedException {
        new Server(8888).start();
    }

    public void start() throws InterruptedException {
        ServerHandler serverHandler = new ServerHandler();
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(boss, worker)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(serverHandler);
                        }
                    });
            ChannelFuture future = b.bind().sync();
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            boss.shutdownGracefully().sync();
            worker.shutdownGracefully().sync();
        }
    }
}
