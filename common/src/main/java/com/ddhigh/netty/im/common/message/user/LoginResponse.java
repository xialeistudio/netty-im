package com.ddhigh.netty.im.common.message.user;

import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.ddhigh.netty.im.common.annotation.Packet;
import com.ddhigh.netty.im.common.constant.Command;
import com.ddhigh.netty.im.common.message.AbstractPacket;

/**
 * 登录响应
 */
@Packet(cmd = Command.LOGIN_RESPONSE)
public class LoginResponse extends AbstractPacket {
    @Protobuf(order = 1)
    private int code;

    @Protobuf(order = 2)
    private String message;

    public int getCode() {
        return code;
    }

    public LoginResponse setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public LoginResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
