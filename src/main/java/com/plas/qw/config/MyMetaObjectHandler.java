package com.plas.qw.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Auther:Plasmon222
 * @Date: 2023/7/20/19:42
 * @Description:
 */
@Component //一定要将处理器添加到 Ioc容器中
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override //1、重写插入时候的填充策略
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ...");
        //setFieldValByName(String fieldName, Object fieldVal, MetaObject metaObject)
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("create_time", new Date(), metaObject);
        this.setFieldValByName("update_time", new Date(), metaObject);
        this.setFieldValByName("sex","1", metaObject);
    }

    @Override //2、重写修改时候的填充策略
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ...");
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("update_time", new Date(), metaObject);
    }

}
