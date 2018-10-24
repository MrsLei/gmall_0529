package com.atguigu.gmall.manager;

import com.atguigu.gmall.SuperBean;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.stereotype.Controller;

import java.io.Serializable;

@Data
public class BaseCatalog3  extends SuperBean {

    private String name;

    private Integer catalog2Id;
}
