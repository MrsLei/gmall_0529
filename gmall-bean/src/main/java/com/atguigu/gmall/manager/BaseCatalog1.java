package com.atguigu.gmall.manager;


import com.atguigu.gmall.SuperBean;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class BaseCatalog1 extends SuperBean {

    private String name;
}
