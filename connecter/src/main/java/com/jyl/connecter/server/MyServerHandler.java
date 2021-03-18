package com.jyl.connecter.server;

import com.jyl.connecter.service.UserService;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class MyServerHandler extends SimpleChannelInboundHandler<MyMessageProtocol> {

    @Autowired
    private UserService userService;


    private int count;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyMessageProtocol msg) throws Exception {
        System.out.println("====服务端接收到消息如下====");
        System.out.println("长度=" + msg.getLen());
        System.out.println("内容=" + new String(msg.getContent(), CharsetUtil.UTF_8));
        System.out.println("服务端接收到消息包数量=" + (++this.count));

        userService.userOnline();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
