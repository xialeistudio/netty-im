package com.ddhigh.netty.im.common.message.user;


import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.ddhigh.netty.im.common.annotation.Packet;
import com.ddhigh.netty.im.common.constant.Command;
import com.ddhigh.netty.im.common.message.AbstractPacket;

/**
 * 登录请求报文
 *
 * @author xialeistudio
 */
@Packet(cmd = Command.LOGIN_REQUEST)
public class LoginRequest extends AbstractPacket {
    @Protobuf(order = 1)
    private String username;
    @Protobuf(order = 2)
    private String password;

    public String getUsername() {
        return username;
    }

    public LoginRequest setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginRequest setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "Request{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
