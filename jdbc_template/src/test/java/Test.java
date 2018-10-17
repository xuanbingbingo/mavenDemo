import com.bingo.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test {
    private JdbcTemplate jdbcTemplate;
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
    }
    //1.使用jdbcTemplate执行ddl语句
    @org.junit.Test
    public void testTemplate(){
        String sql = "create table user1(id INT ,name VARCHAR (20))";
        jdbcTemplate.execute(sql);
    }

    //2.使用jdbcTemplate的update方法进行增加操作
    @org.junit.Test
    public void testUpdate(){
        String sql = "insert into student(name,sex) value(?,?)";
        jdbcTemplate.update(sql,new Object[]{"张飞","男"});
    }

    //3.使用jdbcTemplate的update方法进行修改操作
    @org.junit.Test
    public void testUpdate1(){
        String sql = "update student set sex=? where id = ?";
        jdbcTemplate.update(sql,new Object[]{"女",1});
    }

    //4.使用jdbcTemplate的update方法进行删除操作
    @org.junit.Test
    public void testUpdate2(){
        String sql = "delete from student where id=?";
        jdbcTemplate.update(sql,new Object[]{1});
    }

    //5.使用jdbcTemplate的batchUpdate方法进行批量增加修改一些列操作
    @org.junit.Test
    public void testBatchUpdate(){
        String[] sqls = {
                "insert into student(name,sex) value('李斌','男')",
                "insert into student(name,sex) value('大雷','男')",
                "insert into student(name,sex) value('皓玉','女')",
                "update student set sex='保密' where id=1"
        };
        jdbcTemplate.batchUpdate(sqls);
    }

    //6.使用jdbcTemplate的batchUpdate方法进行同种结构sql语句的批量操作（如批量增加多条数据）
    @org.junit.Test
    public void testBatchUpdate1(){
        String sql = "insert into selection(student,course) value(?,?)";
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{2,1001});
        list.add(new Object[]{2,1002});
        list.add(new Object[]{2,1003});
        list.add(new Object[]{3,1001});
        jdbcTemplate.batchUpdate(sql,list);
    }

    //7.使用jdbcTemplate的queryForObject方法进行简单查询操作(获取一条数据)
    @org.junit.Test
    public void testQueryForObject(){

        //查询简单数据
        String sql = "select count(*) from student";
        Integer count = jdbcTemplate.queryForObject(sql,Integer.class);
        System.out.println("学生数量有"+count+"个");

        //使用RowMapper接口查询一个复杂对象（封装为实体对象）
        String sql1 = "select * from student where id=?";
        Student student = (Student) jdbcTemplate.queryForObject(sql1, new StudentRowMap(), 2);
        System.out.println("获取到学生信息并封装为实体："+student);
    }

    //8.使用jdbcTemplate的queryForList方法进行简单查询操作(获取一组数据)
    @org.junit.Test
    public void testQueryForList(){

        //只有一个字段（name）的一组数据的查询
        String sql = "select name from student where sex=?";
        List<String> names = jdbcTemplate.queryForList(sql,String.class,"男");
        System.out.println("学生性别为男的学生名称有"+names);

        //包含多个字段的一组数据的查询
        String sql1 = "select * from student";
        List<Map<String,Object>> stuList = jdbcTemplate.queryForList(sql1);
        System.out.println("全部学生的全部字段信息："+stuList);
    }

    //9.使用jdbcTemplate的queryForMap方法进行复杂查询操作(获取一条数据)
    @org.junit.Test
    public void testQueryForMap(){
        String sql = "select * from student where id=?";
        Map<String,Object> stu = jdbcTemplate.queryForMap(sql,2);
        System.out.println(stu);
    }

    //10.使用query方法使用RowMapper接口查询一组复杂对象（封装为实体对象）
    @org.junit.Test
    public void testQuery(){
        String sql1 = "select * from student";
        List<Student> studentList = jdbcTemplate.query(sql1, new StudentRowMap());
        System.out.println("获取到学生信息并封装为实体："+studentList);
    }

    //声明一个私有内部类实现RowMapper(定义Student实体类和jdbc resultMap结果集的映射关系)
    private class StudentRowMap implements RowMapper{
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            student.setBorn(resultSet.getDate("born"));
            student.setSex(resultSet.getString("sex"));
            return student;
        }
    }
}
