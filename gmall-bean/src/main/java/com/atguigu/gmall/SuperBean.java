package com.atguigu.gmall;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import java.io.Serializable;

@Data
public class SuperBean implements Serializable{

    @TableId(type = IdType.AUTO)//自增主键
    private Integer id;
}
