package com.jyl.connecter;

import com.jyl.connecter.server.NettyServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetSocketAddress;

@Slf4j
@SpringBootApplication
public class ConnecterApplication implements CommandLineRunner {
    @Autowired
    private NettyServer nettyServer;

    public static void main(String[] args) {
        SpringApplication.run(ConnecterApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        InetSocketAddress address = new InetSocketAddress("127.0.0.1",18080);
        log.info("netty服务器启动地址：{}","127.0.0.1:8091");
        nettyServer.start(address);
    }
}
