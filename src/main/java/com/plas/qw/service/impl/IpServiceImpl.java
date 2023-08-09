package com.plas.qw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.plas.qw.mapper.IpMapper;
import com.plas.qw.pojo.Ip;
import com.plas.qw.service.IIpService;
import com.plas.qw.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;

/**
 * @Auther:Plasmon222
 * @Date: 2023/7/20/10:07
 * @Description:
 */
@Service
public class IpServiceImpl implements IIpService {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    public IpMapper ipMapper;
    public List<Ip> queryList() {
        System.out.println("--------selectAll method test-------");
        return ipMapper.selectList(null);
    }
    public Ip queryIpById(String id) {
        return ipMapper.selectById(id);
    }
    public List<Ip> selectByMap(Ip ip){
        HashMap<String,Object> map = new HashMap<>();
        //自定义查询
        if(StringUtil.isNotEmpty(ip.getUuid())){
            map.put("uuid", ip.getUuid());
        }
        List<Ip> ipsses = ipMapper.selectByMap(map);
        logger.info("这是日志...条件查询:"+ ipsses.toString());
        ipsses.forEach(System.out::println);
        return ipsses;
    }
    public Page pageCourseQuery(Page pageCourse, Ip ip) {
        //创建查询queryWrapper对象
        QueryWrapper queryWrapper=new QueryWrapper<>();
        //根据创建时间排序
        queryWrapper.orderByDesc("createTime");
        //判断此时的条件对象Vo是否等于空，若等于空，
        //直接进行selectPage查询
        if(ip==null){
            Page page = ipMapper.selectPage(pageCourse, queryWrapper);
            return page;
        }
        //若Vo对象不为空，分别获取其中的字段，
        //并对其进行判断是否为空，这一步类似动态SQL的拼装
        String uuid = ip.getUuid();
//        String name = ip.getName();

        if(!StringUtils.isEmpty(uuid)){
            queryWrapper.eq("uuid",uuid);
        }
//        if(!StringUtils.isEmpty(name)){
//            queryWrapper.like("name",name);
//        }
        //最后调用selectPage方法，传入Page对象及queryWrapper对象
        Page page = ipMapper.selectPage(pageCourse, queryWrapper);
        return page;
    }

    public int addIps(Ip ip){

        ip.setLocal(String.valueOf(ip.getLocal()));
        ip.setIsp(String.valueOf(ip.getIsp()));
        int insert = ipMapper.insert(ip);
        return insert;
    }
    public int deleteIps(String id){
        return ipMapper.deleteById(id);
    }

}
