package com.ddhigh.netty.im.client.processor;

import com.ddhigh.netty.im.common.annotation.OnCommand;
import com.ddhigh.netty.im.common.constant.Command;
import com.ddhigh.netty.im.common.message.AbstractPacket;
import com.ddhigh.netty.im.common.message.user.LoginResponse;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用户处理
 *
 * @author xialeistudio
 */
class UserProcessor {
    private static final Logger logger = LoggerFactory.getLogger(UserProcessor.class);

    @OnCommand(cmd = Command.LOGIN_RESPONSE)
    public AbstractPacket onLoginResponse(ChannelHandlerContext ctx, LoginResponse response) {
        logger.info("login response {}", response);
        return null;
    }
}
