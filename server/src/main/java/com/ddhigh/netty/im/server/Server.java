package com.ddhigh.netty.im.server;

import com.ddhigh.netty.im.common.codec.PacketCodec;
import com.ddhigh.netty.im.server.handler.ServerHandler;
import com.ddhigh.netty.im.server.processor.ProcessorProxy;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 服务器
 *
 * @author xialeistudio
 */
public class Server {
    private static final Logger logger = LoggerFactory.getLogger(Server.class);

    public static void main(String[] args) throws InterruptedException {
        new Server().start();
    }

    public void start() throws InterruptedException {
        // 启动处理器扫描
        ProcessorProxy.setupProcessors();
        // 引导服务器
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap sb = new ServerBootstrap();
        sb.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .localAddress("127.0.0.1", 10000)
                .option(ChannelOption.SO_BACKLOG, 128)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new PacketCodec(), new ServerHandler());
                    }
                });
        try {

            ChannelFuture f = sb.bind().sync();
            logger.info("listen on {}", f.channel().localAddress());
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }
}
