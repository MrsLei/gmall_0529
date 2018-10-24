package com.atguigu.gmall.manager;

import com.atguigu.gmall.manager.mapper.BaseCatalog1Mapper;
import com.atguigu.gmall.manager.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallManagerServiceApplicationTests {

	@Autowired
	UserMapper userMapper;
	@Autowired
	BaseCatalog1Mapper mapper;

	@Autowired
	CatalogService catalogService;

	@Test
	public void testCatalogService(){

		List<BaseCatalog1> allBaseCatalog1 = catalogService.getAllBaseCatalog1();
		log.info("一级分类:{}",allBaseCatalog1);

		List<BaseCatalog2> baseCatalog2ByC1id = catalogService.getBaseCatalog2ByC1id(allBaseCatalog1.get(0).getId());
		log.info("{}的二级分类信息:{}",allBaseCatalog1.get(0),baseCatalog2ByC1id);


		List<BaseCatalog3> baseCatalog3ByC2id = catalogService.getBaseCatalog3ByC2id(baseCatalog2ByC1id.get(0).getId());
		log.info("{}的三级分类信息：{}",baseCatalog2ByC1id.get(0),baseCatalog3ByC2id);

	}

	@Test
	public void testBaseCatalog2Mapper(){
		BaseCatalog1 baseCatalog1 = new BaseCatalog1();
		baseCatalog1.setName("haha");

		mapper.insert(baseCatalog1);
		log.info("成功,id是{},name是{}",baseCatalog1.getId(),baseCatalog1.getName());
	}
	@Test
	public void testLogicDelete(){
		userMapper.deleteById(2L);
		System.out.println("删除完成...");
	}


	@Test
	public void contextLoads() {

		for (User user : userMapper.selectList(null)) {
			System.out.println(user);
		}
		;

		System.out.println("---------------");
		User user  = new User();
		user.setName("Jack");
		user.setAge(20);
		User userByhaha = userMapper.getUserByhaha(user);
		System.out.println(userByhaha);
	}

}
