package com.mooc.mybatis.dao;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.mooc.mybatis.bean.User;
import org.apache.ibatis.annotations.Param;

import com.mooc.mybatis.bean.Person;

public interface PersonMapper {

     public  void  deletePerson(Integer id);

     /*public Person getPersonByNameAndGender(String username,String gender);*/

    /*public Person getPersonByNameAndGender(Person person);*/

    /*public Person getPersonByNameAndGender(Map<String,Object> param);*/

     /*public Person getPersonByNameAndGender(@Param("name1") String username,@Param("gender1") String gender)*/;

     /*public Person getPersonByNameAndGender(@Param("name1") String username,String gender)*/;

    /* public Person getPersonByCollection(Collection list);*/

    public Person getPersonByCollection(@Param("test") int[] ids);

    public List<Person> getPersonsByIds(int[] ids);

    public int addPersons(@Param("persons") List<Person> persons);//返回受影响的行数

    public int addPerson(Person person);

    public List<Person> getAllPersons();


}
