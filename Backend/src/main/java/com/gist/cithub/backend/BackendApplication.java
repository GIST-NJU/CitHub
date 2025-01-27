package com.gist.cithub.backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.gist.cithub.backend.Repo.dao","com.gist.cithub.backend.Tools.dao","com.gist.cithub.backend.Benchmark.dao","com.gist.cithub.backend.User.dao"})
public class BackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

}
