package com.plas.qw.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Auther:Plasmon222
 * @Date: 2023/7/28/16:11
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ip {
    @TableId(type = IdType.ASSIGN_ID)
    private String uuid;//主键
    private String ip;
    private String local;
    private  String lng;
    private String lat;
    private String isp;
    private String text;
    private String status;

    @TableField(fill = FieldFill.INSERT) //添加时自动填充
    private Date create_time;
    @TableField(fill = FieldFill.INSERT_UPDATE) //添加或修改时自动填充
    private Date update_time;

}
