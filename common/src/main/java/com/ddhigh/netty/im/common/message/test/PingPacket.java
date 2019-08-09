package com.ddhigh.netty.im.common.message.test;

import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.ddhigh.netty.im.common.annotation.Packet;
import com.ddhigh.netty.im.common.constant.Command;
import com.ddhigh.netty.im.common.message.AbstractPacket;

/**
 * PING
 *
 * @author xialeistudio
 */
@Packet(cmd = Command.PING)
public class PingPacket extends AbstractPacket {
    @Protobuf(order = 1)
    private String data;

    public String getData() {
        return data;
    }

    public PingPacket setData(String data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "PingPacket{" +
                "data='" + data + '\'' +
                '}';
    }
}
