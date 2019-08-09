package com.ddhigh.netty.im.common.message.chat;

import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.ddhigh.netty.im.common.annotation.Packet;
import com.ddhigh.netty.im.common.constant.Command;
import com.ddhigh.netty.im.common.message.AbstractPacket;

@Packet(cmd = Command.CHAT_REQUEST)
public class ChatRequest extends AbstractPacket {
    @Protobuf(order = 1)
    private String message;

    public String getMessage() {
        return message;
    }

    public ChatRequest setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return "ChatRequest{" +
                "message='" + message + '\'' +
                '}';
    }
}
