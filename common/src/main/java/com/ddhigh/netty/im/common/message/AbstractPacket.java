package com.ddhigh.netty.im.common.message;

import com.ddhigh.netty.im.common.annotation.Packet;

/**
 * 数据包
 *
 * @author xialeistudio
 */
public class AbstractPacket {
    public static final short TAG = 0xCD;

    public short cmd() {
        Packet packet = getClass().getAnnotation(Packet.class);
        if (packet == null) {
            return 0;
        }
        return packet.cmd().value();
    }
}
