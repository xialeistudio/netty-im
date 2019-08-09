package com.ddhigh.netty.im.common.annotation;

import com.ddhigh.netty.im.common.constant.Command;

import java.lang.annotation.*;

/**
 * 数据包注解
 *
 * @author xialeistudio
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Packet {
    Command cmd();
}
