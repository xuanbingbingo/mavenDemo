import com.bingo.entity.Users;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestDemo {

    @Test
    public void testDemo1() throws IOException {

        //初始化mybatis环境
        String resource = "mybatis.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        //打开和数据库的会话
        SqlSession session = factory.openSession();
        List<Users> uList = session.selectList("usersList");

        for (Users user: uList
             ) {
            System.out.println(user);
        }
        //关闭会话
        session.close();
    }

}
