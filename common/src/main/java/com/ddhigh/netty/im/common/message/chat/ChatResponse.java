package com.ddhigh.netty.im.common.message.chat;

import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.ddhigh.netty.im.common.annotation.Packet;
import com.ddhigh.netty.im.common.constant.Command;
import com.ddhigh.netty.im.common.message.AbstractPacket;

@Packet(cmd = Command.CHAT_RESPONSE)
public class ChatResponse extends AbstractPacket {
    @Protobuf(order = 1)
    private int code;

    @Protobuf(order = 2)
    private String message;

    public int getCode() {
        return code;
    }

    public ChatResponse setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ChatResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return "ChatResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
