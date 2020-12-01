package man.kuke.dao;

import man.kuke.model.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author: kuke
 * @date: 2020/12/1 - 17:20
 * @description:
 */
public interface BlogMapper {
    void addBlog(Blog blog);
    List<Blog> getBlogsIF(Map<String, Object> map);

    List<Blog> getBlogsChoose(Map<String, Object> map);
}
