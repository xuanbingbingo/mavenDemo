package com.mooc.mybatis.test;

import com.mooc.mybatis.bean.Person;
import com.mooc.mybatis.dao.PersonMapper;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

/**
 * Created by imooc
 */
public class ParameterTest {

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

    /**
     * 根据ID删除所对应的Person数据
     */
    public void deletePerson() {
        SqlSession sqlSession = this.getSqlSessionFactory().openSession();

        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);

        personMapper.deletePerson(2);

        sqlSession.commit();


    }

    public void testPersonByNameAndGender(){

        SqlSession sqlSession = this.getSqlSessionFactory().openSession();

        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);

        /* Map<String,Object> param=new HashMap<String, Object>();

        param.put("name","wangwu");
        param.put("gender","f");*/

        /*Person person=personMapper.getPersonByNameAndGender("wangwu","f");*/


       /* System.out.println(person);*/

    }

    public void testCollection()
    {
        SqlSession sqlSession = this.getSqlSessionFactory().openSession();

        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);

        Person person=personMapper.getPersonByCollection(new int[]{1,2,3,4,5});

        System.out.println(person);

    }

    public void testForeach()
    {
        SqlSession sqlSession = this.getSqlSessionFactory().openSession();
        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        List<Person> personList=personMapper.getPersonsByIds(new int[]{1,2,3,4,5});
        System.out.println(personList);
    }


    public void processMybatisBatch()
    {
        SqlSession sqlSession = this.getSqlSessionFactory().openSession();
        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);

        List<Person> persons=new ArrayList<Person>();

        for (int i = 0; i <5 ; i++)
        {
            Person person=new Person("jerry"+i,"email@"+i,"f");
            persons.add(person);
        }

        personMapper.addPersons(persons);

        sqlSession.commit();

    }

    public void testBatchForExecutor()
    {
//        让当前的session具有批处理的能力
        SqlSession sqlSession = this.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);

        for (int i = 0; i <10000 ; i++)
        {
            personMapper.addPerson(new Person("tom","tom@imooc.com","F"));
        }

        sqlSession.commit();

        sqlSession.close();


    }


    public static void main(String[] args) {

       new ParameterTest().testCollection();

    }


}
