package com.ddhigh.netty.im.server.processor;

import com.ddhigh.netty.im.common.constant.Command;
import com.ddhigh.netty.im.common.message.user.LoginRequest;
import com.ddhigh.netty.im.common.message.user.LoginResponse;
import com.ddhigh.netty.im.common.annotation.OnCommand;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.AttributeKey;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户处理
 *
 * @author xialeistudio
 */
class UserProcessor {
    private static final Map<String, String> ACCOUNTS = new HashMap<String, String>() {{
        put("xialei", "111111");
    }};

    private static final AttributeKey<String> USER_ID = AttributeKey.valueOf("userId");

    @OnCommand(cmd = Command.LOGIN_REQUEST)
    public LoginResponse login(ChannelHandlerContext ctx, LoginRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();
        if (!ACCOUNTS.containsKey(username) || !ACCOUNTS.get(username).equals(password)) {
            return new LoginResponse().setCode(1).setMessage("账号或密码错误");
        }
        ctx.channel().attr(USER_ID).set(username);
        return new LoginResponse().setCode(0).setMessage("ok");
    }
}
