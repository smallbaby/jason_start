package com.jason.jason_start.netty.deep;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Author: Jason
 * Date 2020/6/6
 */
public class WorkerHandler extends SimpleChannelUpstreamHandler {
    private CompletionService<String> completionService = new ExecutorCompletionService(Executors.newCachedThreadPool());

    public WorkerHandler() {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Future<String> f = completionService.take();
                        String msg = f.get();
                        System.out.println("f.get. success...");
                    }catch (Exception e) {
                        System.out.println("take future.." + e);
                    }
                }
            }
        }.start();
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        System.out.println("messageReceived:" + e.getMessage());
        String msg = (String) e.getMessage();
        System.out.println("helloworold: " + msg);

    }

    @Override
    public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        super.channelDisconnected(ctx, e);
        System.out.println("disconnnected.....worker disconnect to master.");
    }
}
