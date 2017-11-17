package com.lanou3g.crm.post.dao.impl;

import com.lanou3g.crm.department.domain.Department;
import com.lanou3g.crm.post.dao.PostDao;
import com.lanou3g.crm.post.domain.Post;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public class PostDaoImpl extends HibernateDaoSupport implements PostDao {
    @Override
    public boolean save(Post post) {
        return false;
    }

    //查询全部
    @Override
    public List<Post> findAll() {
        return (List<Post>) getHibernateTemplate().find("from Post T_POST");

    }

    //添加或更新
    @Override
    public boolean saveOrUpdate(Post post) {
        getHibernateTemplate().saveOrUpdate(post);
        return true;
    }

    //通过id查询
    @Override
    public Post findById(Post post) {
        return getHibernateTemplate().get(Post.class, post.getPostId());
    }


    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean update(Post post) {
        return false;
    }


    //根据部门Id查询职位的集合
    @Override
    public List<Post> getPostByDepId(String depId) {
        String sql = "from Post T_POST where department.depId =?";
        List<Post> posts = (List<Post>) getHibernateTemplate().find(sql, depId);
        return posts;
    }
}
