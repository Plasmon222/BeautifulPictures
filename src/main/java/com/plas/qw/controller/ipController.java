package com.plas.qw.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.plas.qw.pojo.Ip;
import com.plas.qw.service.IIpService;
import com.plas.qw.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther:Plasmon222
 * @Date: 2023/7/28/15:38
 * @Description:
 */

@RequestMapping("ip")
@RestController
public class ipController {
    @Autowired
    private IIpService ipService;

    @GetMapping("queryIpList")
    public ServerResponse queryIpList() {
        List<Ip> ips = ipService.queryList();
        return ServerResponse.createBySuccess("查询全部IP", ips, ips.size());
    }

    @GetMapping("queryIpById")
    public ServerResponse queryIpById(String id) {
        Ip ip = ipService.queryIpById(id);
        return ServerResponse.createBySuccess("根据单个id查用户", ip, 1);
    }

    @GetMapping("selectIpByMap")
    public ServerResponse selectIpByMap(Ip ip) {
        List<Ip> ips = ipService.selectByMap(ip);
        return ServerResponse.createBySuccess("条件查询成功", ips, ips.size());
    }

    @GetMapping("getIpCourseList/{current}/{limit}")
    public ServerResponse getIpCourseList(
            @PathVariable Long current,    //当前页
            @PathVariable Long limit,    //要查询记录数
            Ip ip    //查询条件封装的对象
    ) {
        //创建一个Page对象，传入当前页和要查询记录数
        Page pageCourse = new Page<>(current, limit);
        //调用服务层的查询方法，传入Page对象和查询条件对象
        ipService.pageCourseQuery(pageCourse, ip);
        //查询结束之后，Page对象就存在数据了，此时可以
        //通过该Page对象获取对应的行记录和总记录数
        List rows = pageCourse.getRecords();
        long total = pageCourse.getTotal();
        Map map = new HashMap();
        map.put("rows", rows);
        map.put("total", total);
        //统一返回结果
        return ServerResponse.createBySuccess("200", rows, total);
    }

    @ResponseBody
    @GetMapping("/addIp")
    public ServerResponse addIp(Ip ip) {
        System.out.println("===============");
        System.out.println(ip);
        int i = ipService.addIps(ip);
        return ServerResponse.createBySuccess("添加ip成功",null);
    }

    @GetMapping("/deleteIpById")
    public ServerResponse deleteUserById(String id) {
        int i = ipService.deleteIps(id);
        return ServerResponse.createBySuccess("删除用户成功", i);
    }

}
