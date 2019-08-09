package com.ddhigh.netty.im.client.handler;

import com.ddhigh.netty.im.client.processor.ProcessorProxy;
import com.ddhigh.netty.im.common.message.AbstractPacket;
import com.ddhigh.netty.im.common.message.test.PingPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 客户端处理
 *
 * @author xialeistudio
 */
public class ClientHandler extends SimpleChannelInboundHandler<AbstractPacket> {
    private static final Logger logger = LoggerFactory.getLogger(ClientHandler.class);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        AbstractPacket msg = new PingPacket();
        ctx.writeAndFlush(msg);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, AbstractPacket msg) throws Exception {
        ProcessorProxy.handleCommand(msg.cmd(), ctx, msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
