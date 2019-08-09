package com.ddhigh.netty.im.common.codec;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.ddhigh.netty.im.common.message.AbstractPacket;
import com.ddhigh.netty.im.common.message.PacketClassFactory;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * 数据包编码解码器
 * 协议
 * |--2字节固定标识--|2字节指令|4字节数据长度|变长
 *
 * @author xialeistudio
 */
public class PacketCodec extends ByteToMessageCodec<AbstractPacket> {
    private static final int HEADER_LENGTH = 8;
    private static final Logger logger = LoggerFactory.getLogger(PacketCodec.class);

    @Override
    protected void encode(ChannelHandlerContext ctx, AbstractPacket msg, ByteBuf out) throws Exception {
        try {
            out.writeShort(AbstractPacket.TAG);
            out.writeShort(msg.cmd());

            byte[] data = this.encodeWitProtobuf(msg);
            if (data != null) {
                out.writeInt(data.length);
                out.writeBytes(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private byte[] encodeWitProtobuf(AbstractPacket msg) throws IOException {
        Class<AbstractPacket> clazz = (Class<AbstractPacket>) msg.getClass();
        Codec<AbstractPacket> codec = ProtobufProxy.create(clazz);
        return codec.encode(msg);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < HEADER_LENGTH) {
            return;
        }
        try {
            // 跳过TAG
            in.skipBytes(2);
            short cmd = in.readShort();
            int length = in.readInt();
            byte[] body = new byte[length];
            in.readBytes(body);

            AbstractPacket packet = this.decodeWithProtobuf(body, cmd);
            if (packet != null) {
                out.add(packet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private AbstractPacket decodeWithProtobuf(byte[] body, short cmd) throws IOException {
        Class<?> clazz = PacketClassFactory.getClass(cmd);
        if (clazz == null) {
            logger.warn("unknown cmd {}", cmd);
            return null;
        }
        Codec codec = ProtobufProxy.create(clazz);
        return (AbstractPacket) codec.decode(body);
    }
}
