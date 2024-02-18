package com.example.tmp;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@MapperScan("com.example.*.mapper")
@Slf4j

public class TmpApplication extends SpringBootServletInitializer {


      public static void main(String[] args) throws UnknownHostException {
            ConfigurableApplicationContext application = SpringApplication.run(TmpApplication.class, args);
            Environment env = application.getEnvironment();
            String ip = InetAddress.getLocalHost().getHostAddress();
            String port = env.getProperty("server.port");
            String path = env.getProperty("server.servlet.context-path");
            String xxlPort = env.getProperty("xxl.job.admin.addresses");
            String xxlPath = "xxl-job-admin";
            String apolloPort = "8070";
            String eurakePort = env.getProperty("apollo.meta");
            if (StringUtils.isEmpty(path)) {
                  path = "";

            }
            log.info("\n----------------------------------------------------------\n\t" +
                    "Application  is running! Access URLs:\n\t" +
                    "Local访问网址: \t\thttp://localhost:" + port + path + "\n\t" +
                    "External访问网址: \thttp://" + ip + ":" + port + path + "\n\t" +
                    "Apollo配置中心: \t\thttp://localhost:" + apolloPort + "\n\t" +
                    "Eureka服务中心: \t\t" + eurakePort +   "\n\t" +
                    "xxl-job任务调度中心: \t" + xxlPort + "\n\t" +
                    "xxl-job服务端口: \t9999\n\t" +
                    "Thread Start: \t\tSuccess\n\t" +
                    "Welcome back bwHuang\n\t" +
                    "----------------------------------------------------------");
      }

      @Override
      protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
            return application.sources(TmpApplication.class);

      }
      @GetMapping("/hello")
      public String Hello(){
            return "Hello World!";
      }
}
