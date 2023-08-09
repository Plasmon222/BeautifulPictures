package com.plas.qw.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther:Plasmon222
 * @Date: 2023/7/21/9:46
 * @Description:
 */
@Configuration
@MapperScan("com.plas.qw.mapper")
public class EduConfig {
    //分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
