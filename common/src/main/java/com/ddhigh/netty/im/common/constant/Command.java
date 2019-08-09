package com.ddhigh.netty.im.common.constant;

/**
 * 指令定义
 *
 * @author xialeistudio
 */
public enum Command {
    /**
     * 检测连通性
     */
    PING(0x01),
    /**
     * 连通性OK
     */
    PONG(0x02),

    /**
     * 登录请求
     */
    LOGIN_REQUEST(0x03),
    /**
     * 登录响应
     */
    LOGIN_RESPONSE(0x04),

    /**
     * 聊天请求
     */
    CHAT_REQUEST(0x05),

    /**
     * 聊天响应
     */
    CHAT_RESPONSE(0x06);
    /**
     * 枚举值
     */
    private short value;

    Command(int value) {
        this.value = (short) value;
    }

    public short value() {
        return this.value;
    }
}
