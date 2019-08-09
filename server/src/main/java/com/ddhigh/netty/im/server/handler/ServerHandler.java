package com.ddhigh.netty.im.server.handler;

import com.ddhigh.netty.im.common.message.AbstractPacket;
import com.ddhigh.netty.im.server.processor.ProcessorProxy;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xialeistudio
 */
public class ServerHandler extends SimpleChannelInboundHandler<AbstractPacket> {
    private static final Logger logger = LoggerFactory.getLogger(ServerHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, AbstractPacket msg) throws Exception {
        logger.info("{}: {}", ctx.channel().remoteAddress(), msg);
        ProcessorProxy.handleCommand(msg.cmd(), ctx, msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
