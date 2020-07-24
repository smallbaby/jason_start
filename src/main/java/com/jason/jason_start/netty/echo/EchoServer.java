package com.jason.jason_start.netty.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * Author: Jason
 * Date 2020/6/7
 */
public class EchoServer {
    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws InterruptedException {
        new EchoServer(8080).start();
//        if (args.length != 1) {
//            System.err.println("" +
//                    "Usage:" + EchoServer.class.getSimpleName() + " <port> ");
//            int port = Integer.parseInt(args[0]);
//            new EchoServer(port).start();
//        }
    }
    public void start() throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(group).channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new EchoServerHandler());
                        }
                    });
            ChannelFuture f = b.bind().sync(); // 绑定服务器，sync阻塞，等待绑定完成
            f.channel().closeFuture().sync(); // 获取chanel的chloseFuture，阻塞，直到完成
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully().sync(); //关闭，释放资源
        }
    }
}
