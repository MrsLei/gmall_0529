package com.atguigu.gmall.manger.vo;


import lombok.Data;

import java.util.List;


@Data
public class BaseAttrInfoAndValueVO {

    private Integer id;
    private String attrName;
    private List<BaseAttrValueVo> attrValues;
}
