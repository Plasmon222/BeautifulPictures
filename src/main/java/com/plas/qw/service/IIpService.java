package com.plas.qw.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.plas.qw.pojo.Ip;

import java.util.List;

/**
 * @Auther:Plasmon222
 * @Date: 2023/7/28/16:22
 * @Description:
 */
public interface IIpService {
    public List<Ip> queryList();//查询全部用户
    public Ip queryIpById(String id);//根据id查询
    public List<Ip> selectByMap(Ip ip);//条件查询
    public Page pageCourseQuery(Page pageCourse, Ip ip);//定义pageCourseQuery方法，指定参数Page对象及查询条件对象
    public int addIps(Ip ip);//添加用户
    public int deleteIps(String id);//根据id删用户
}
