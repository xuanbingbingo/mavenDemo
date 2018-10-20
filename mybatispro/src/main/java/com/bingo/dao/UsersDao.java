package com.bingo.dao;

import com.bingo.entity.Users;
import com.bingo.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UsersDao {
    private SqlSession sqlSession;
    private List<Users> list;
    private Users user;
    private SqlSession getSqlSession(){
        sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        return sqlSession;0
    }
    public List<Users> findAll(){
        try{
            list = getSqlSession().selectList("findUsers");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return list;
    }

    /**
     * 根据id查询某位学生信息
     * @param id
     * @return
     */
//    public Users findById(Integer id){
//        try{
//            user = getSqlSession().selectOne("findById",id);
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            sqlSession.close();
//        }
//        return user;
//    }

    public Users findById(Integer id){
        try{
            user = getSqlSession().selectOne("findUsers",new Users(id));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return user;
    }

    /**
     * 增加一个用户到数据库中的方法
     * addUser
     */
    public Users addUser(Users user){
        try{
            //返回值：insert执行过程中影响的行数
            getSqlSession().insert("addUser",user);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return user;
    }

    /**
     * 修改一个用户到数据库中的方法
     * updateUsers
     */
    public Users updateUsers(Users user){
        try{
            getSqlSession().update("updateUser",user);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return user;
    }

    /**
     * 删除一个用户到数据库中的方法
     * delUser
     */
    public void delUsers(Integer id){
        try{
            getSqlSession().delete("delUser", id);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
}
