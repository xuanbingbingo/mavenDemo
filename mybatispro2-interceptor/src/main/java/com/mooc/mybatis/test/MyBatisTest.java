package com.mooc.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.mooc.mybatis.bean.Dept;
import com.mooc.mybatis.bean.Person;
import com.mooc.mybatis.dao.PersonMapper;

 
public class MyBatisTest {
	public static SqlSessionFactory sqlSessionFactory = null;

	public static SqlSessionFactory getSqlSessionFactory() {
		if (sqlSessionFactory == null) {
			String resource = "mybatis-config.xml";
			try {
				Reader reader = Resources.getResourceAsReader(resource);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sqlSessionFactory;
	}

	/*public void testCollection()
	{
		SqlSession sqlSession = this.getSqlSessionFactory().openSession();

		PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);

		Person person=personMapper.getPersonByCollection(new int[]{1,2,3,4,5});

		System.out.println(person);

	}*/


	public  void getAllPersons()
	{
		SqlSession sqlSession = this.getSqlSessionFactory().openSession();

		PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);

		Page<Object> page=PageHelper.startPage(1,10);

		List<Person> persons=personMapper.getAllPersons();

		PageInfo pageInfo=new PageInfo(persons,9);
		for (Person person:persons)
		{
			System.out.println(person.getId());
		}

		System.out.println(page.getPageNum());//current page
		System.out.println(page.getTotal());//total
		System.out.println(page.getPageSize());//page size

		System.out.println(pageInfo.isIsFirstPage());

		System.out.println(pageInfo.getPages());// total pages

		int[] nums=pageInfo.getNavigatepageNums();

		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}


	}

	public static void main(String[] args) {

		new MyBatisTest().getAllPersons();


	}









	

 
  
	
}
