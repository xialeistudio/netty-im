package com.ddhigh.netty.im.client.processor;

import com.ddhigh.netty.im.common.annotation.OnCommand;
import com.ddhigh.netty.im.common.constant.Command;
import com.ddhigh.netty.im.common.message.AbstractPacket;
import com.ddhigh.netty.im.common.message.test.PongPacket;
import com.ddhigh.netty.im.common.message.user.LoginRequest;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 处理PING
 *
 * @author xialeistudio
 */
class PongProcessor {
    private static final Logger logger = LoggerFactory.getLogger(PongProcessor.class);

    @OnCommand(cmd = Command.PONG)
    public AbstractPacket onPong(ChannelHandlerContext ctx, PongPacket packet) {
        logger.info("server response {}. prepare login", packet.getData());
        return new LoginRequest().setUsername("xialei").setPassword("111111");
    }
}
