package com.atguigu.gmall.manger.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.manager.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 */
@RequestMapping("/basecatalog")
@RestController
public class BaseCatalogRestController {

    @Reference
    CatalogService catalogService;

    @Reference
    BaseAttrInfoService baseAttrInfoService;

    /**
     *查询三级分类下的id
     * @param id  三级分类id
     * @return
     */
    @RequestMapping("/attrs.json")
    public List<BaseAttrInfo> getBaseAttrInfos(Integer id){

        return baseAttrInfoService.getBaseAttrInfoByCatalog3Id(id);
    }
    /**
     * 查询一级分类
     * @return
     */
    @RequestMapping("/1/list.json")
    public List<BaseCatalog1> listBaseCatalog1(){
        return  catalogService.getAllBaseCatalog1();
    }

    /**
     *
     * @param id   一级分类id
     * @return
     */
    @RequestMapping("/2/list.json")
    public List<BaseCatalog2> listBaseCatalog2(Integer id){

        return  catalogService.getBaseCatalog2ByC1id(id);
    }

    /**
     *@param id   二级分类id
     * @return
     */
    @RequestMapping("/3/list.json")
    public List<BaseCatalog3> listBaseCatalog3(Integer id){

        return  catalogService.getBaseCatalog3ByC2id(id);
    }
}
