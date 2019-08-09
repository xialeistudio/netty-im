package com.ddhigh.netty.im.server.processor;

import com.ddhigh.netty.im.common.annotation.OnCommand;
import com.ddhigh.netty.im.common.message.AbstractPacket;
import io.netty.channel.ChannelHandlerContext;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 包处理器代理
 *
 * @author xialeistudio
 */
public class ProcessorProxy {
    private static final Map<Short, Method> processors = new HashMap<>();

    /**
     * 扫描处理器
     */
    public static void setupProcessors() {
        String packageName = ProcessorProxy.class.getPackage().getName();
        Reflections reflections = new Reflections(packageName, new MethodAnnotationsScanner());

        Set<Method> methods = reflections.getMethodsAnnotatedWith(OnCommand.class);
        for (Method method : methods) {
            OnCommand onCommand = method.getAnnotation(OnCommand.class);
            processors.put(onCommand.cmd().value(), method);
        }
    }

    public static void handleCommand(short command, ChannelHandlerContext ctx, AbstractPacket msg) {
        Method method = processors.get(command);
        if (method == null) {
            return;
        }
        try {
            Class clazz = method.getDeclaringClass();
            Object object = clazz.newInstance();
            Object response = method.invoke(object, ctx, msg);
            if (response != null) {
                ctx.writeAndFlush(response);
            }
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
