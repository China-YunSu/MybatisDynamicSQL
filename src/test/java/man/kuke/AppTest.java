package man.kuke;

import static org.junit.Assert.assertTrue;

import man.kuke.dao.BlogMapper;
import man.kuke.model.Blog;
import man.kuke.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {


    @Test
    public void shouldAnswerWithTrue() {
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        Blog blog = new Blog();

        blog.setId(110);
        blog.setTitle( "Mybatis如此简单");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews (9999);
        mapper.addBlog(blog);
        blog.setId(111);
        blog.setTitle("ava如此简单");
        mapper.addBlog(blog);
        blog.setId(1000);
        blog.setTitle( "Spring如此简单");
        mapper.addBlog(blog);
        blog.setId(1001);
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);

        session.close();
    }

    @Test
    public void testIf() {
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("title", "Mybatis如此简单");
        List<Blog> blogs = mapper.getBlogsIF(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        session.close();
    }

    @Test
    public void testChoose() {
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        HashMap<String, Object> map = new HashMap<>();
//        map.put("title", "Mybatis如此简单");
        List<Blog> blogs = mapper.getBlogsChoose(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        session.close();
    }
}
