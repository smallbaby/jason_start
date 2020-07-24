package com.jason.jason_start.netty.deep;

import org.jboss.netty.channel.*;

import org.jboss.netty.channel.Channel;

import java.net.InetSocketAddress;

/**
 * Author: Jason
 * Date 2020/6/1
 */
public class MasterHandler extends SimpleChannelUpstreamHandler {
    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        Channel channel = ctx.getChannel();
        InetSocketAddress addr = (InetSocketAddress) channel.getRemoteAddress();
        String IP = addr.getAddress().getHostAddress();
        System.out.println(("worker connected , " + IP + ":" + addr.getPort()));
        super.channelConnected(ctx, e);
    }

    @Override
    public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        InetSocketAddress addr = (InetSocketAddress) ctx.getChannel().getRemoteAddress();
        String IP = addr.getAddress().getHostAddress();
        System.out.println(("worker disconnect :" + IP));
        super.channelConnected(ctx, e);
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        final Channel channel = ctx.getChannel();
        Object sm = e.getMessage();
        System.out.println(sm);
        super.messageReceived(ctx, e);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {

        System.out.println(("异常连接,源地址来自:" + ctx.getChannel().getRemoteAddress() + " 目标地址:" + ctx.getChannel().getLocalAddress() + " error " + e.getCause()));

        ctx.sendUpstream(e);
    }
}
