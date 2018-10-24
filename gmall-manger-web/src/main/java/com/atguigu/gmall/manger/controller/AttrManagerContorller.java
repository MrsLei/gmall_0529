package com.atguigu.gmall.manger.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.manager.BaseAttrInfo;
import com.atguigu.gmall.manager.BaseAttrInfoService;
import com.atguigu.gmall.manager.BaseAttrValue;
import com.atguigu.gmall.manger.vo.BaseAttrInfoAndValueVO;
import com.atguigu.gmall.manger.vo.BaseAttrValueVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequestMapping("/attr")
@Controller
public class AttrManagerContorller {

    @Reference
    BaseAttrInfoService baseAttrInfoService;

    /**
     *
     * @param baseAttrInfoAndValueVO
     * @return
     * @RequestBody 将请求体中的数据封装成指定BaseAttrInfoAndValueVO的对象
     * 1、如果请求体中是json字符串，直接可以将json转为对象
     * BaseAttrInfoAndValueVO vo = json.parse(jsonStr)
     * 2、 k=v&k=v&k=v  URL编码的
     * 3、页面如果直接提交一个原生的json
     * 这是一个综合的方法
     */
    @ResponseBody
    @RequestMapping("/updates")
    public String saveOrUpdateOrDeleteAttrInfoAndValue(
            @RequestBody  BaseAttrInfoAndValueVO baseAttrInfoAndValueVO) throws InvocationTargetException, IllegalAccessException {

        log.info("页面提交来的数据ss：{}",baseAttrInfoAndValueVO);

        //1、修改还是添加
        if(baseAttrInfoAndValueVO.getId()!=null){
            //修改,检查新提交的属性名不能是空串.....
            //1、修改基本属性名
            //2、修改这个属性对应的所有的值
            BaseAttrInfo baseAttrInfo = new BaseAttrInfo();
            //将vo中的所有属性复制到bean中
            BeanUtils.copyProperties(baseAttrInfoAndValueVO,baseAttrInfo);

            List<BaseAttrValue> values = new ArrayList<>();
            //遍历
            for (BaseAttrValueVo baseAttrValueVo : baseAttrInfoAndValueVO.getAttrValues()) {
                //将这个vo里面的数据封装到BaseAttrValue这个对象
                BaseAttrValue baseAttrValue = new BaseAttrValue();
                BeanUtils.copyProperties(baseAttrValueVo,baseAttrValue);
                values.add(baseAttrValue);
            };
            //将复制好的list设置在attrInfo中
            baseAttrInfo.setAttrValues(values);
            log.info("复制属性完成：{}",baseAttrInfo);
            baseAttrInfoService.saveOrUpdateBaseInfo(baseAttrInfo);
        }else{

        }
        return "ok";
    }

    /**
     * 获取某个平台属性下的所有属性值
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/value/{id}")
    public List<BaseAttrValue> getBaseAttrValueByAttrId(@PathVariable("id") Integer id){

        return baseAttrInfoService.getBaseAttrValueByAttrId(id);
    }

    @RequestMapping("/listPage.html")
    public String toAttrListPage(){

        return "attr/attrListPage";
    }
}
