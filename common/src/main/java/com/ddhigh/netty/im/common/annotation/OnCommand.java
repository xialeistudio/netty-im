package com.ddhigh.netty.im.common.annotation;

import com.ddhigh.netty.im.common.constant.Command;

import java.lang.annotation.*;

/**
 * 处理指定的指令
 *
 * @author xialeistudio
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OnCommand {
    Command cmd();
}
