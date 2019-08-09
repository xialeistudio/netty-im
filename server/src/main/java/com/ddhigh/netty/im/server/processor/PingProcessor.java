package com.ddhigh.netty.im.server.processor;

import com.ddhigh.netty.im.common.constant.Command;
import com.ddhigh.netty.im.common.message.test.PingPacket;
import com.ddhigh.netty.im.common.message.test.PongPacket;
import com.ddhigh.netty.im.common.annotation.OnCommand;
import io.netty.channel.ChannelHandlerContext;

/**
 * PING包的处理
 *
 * @author xialeistudio
 */
class PingProcessor {
    /**
     * 处理PING请求
     *
     * @param ctx
     * @param packet
     * @return
     */
    @OnCommand(cmd = Command.PING)
    public PongPacket ping(ChannelHandlerContext ctx, PingPacket packet) {
        return new PongPacket().setData("PONG");
    }
}
