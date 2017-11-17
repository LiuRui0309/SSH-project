package com.lanou3g.crm.post.service.impl;

import com.lanou3g.crm.post.dao.PostDao;
import com.lanou3g.crm.post.domain.Post;
import com.lanou3g.crm.post.service.PostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
@Service("postService")
public class PostServiceImpl implements PostService {
    @Resource
    private PostDao postDao;

    //添加和更新
    @Override
    public boolean saveOrUpdate(Post post) {
        postDao.saveOrUpdate(post);
        return true;
    }

    //查询全部
    @Override
    public List<Post> findAll() {
        return postDao.findAll();
    }

    //通过id查询职位
    @Override
    public Post findById(Post post) {
       return postDao.findById(post);
    }

    /**
     * 根据部门Id查询全部
     * @param depId
     * @return
     */
    @Override
    public List<Post> getPostByDepId(String depId) {
        return postDao.getPostByDepId(depId);
    }

    @Override
    public boolean save(Post post) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean update(Post post) {
        return false;
    }



}
