package com.linjun.java.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Handles a server-side channel.
 */
public class PrintServerHandler extends ChannelInboundHandlerAdapter { // (1)
    private Logger logger = LoggerFactory.getLogger(PrintServerHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
        logger.info("Read from channel ...");

        ByteBuf in = (ByteBuf) msg;
        try {
            while (in.isReadable()) { // (1)
                System.out.print((char) in.readByte());
                System.out.flush();
                //System.out.println(in.toString(io.netty.util.CharsetUtil.US_ASCII));
            }
        } finally {
            ReferenceCountUtil.release(msg); // (2)
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}
