package com.ddhigh.netty.im.common.message;

import com.ddhigh.netty.im.common.constant.Command;
import com.ddhigh.netty.im.common.message.chat.ChatRequest;
import com.ddhigh.netty.im.common.message.chat.ChatResponse;
import com.ddhigh.netty.im.common.message.test.PingPacket;
import com.ddhigh.netty.im.common.message.test.PongPacket;
import com.ddhigh.netty.im.common.message.user.LoginRequest;
import com.ddhigh.netty.im.common.message.user.LoginResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据消息类型返回消息Class
 *
 * @author xialeistudio
 */
public class PacketClassFactory {
    private static Map<Short, Class> map = new HashMap<>();

    static {
        map.put(Command.PING.value(), PingPacket.class);
        map.put(Command.PONG.value(), PongPacket.class);
        map.put(Command.LOGIN_REQUEST.value(), LoginRequest.class);
        map.put(Command.LOGIN_RESPONSE.value(), LoginResponse.class);
        map.put(Command.CHAT_REQUEST.value(), ChatRequest.class);
        map.put(Command.CHAT_RESPONSE.value(), ChatResponse.class);
    }

    public static Class getClass(short command) {
        return map.get(command);
    }
}
