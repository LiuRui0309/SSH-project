package com.lanou3g.crm.post.dao.impl;

import com.lanou3g.crm.post.dao.PostDao;
import com.lanou3g.crm.post.domain.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/11/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class PostDaoImplTest {

    @Resource
    private PostDao postDao;

    @Test
    public void findAllTest() {
        System.out.println(postDao.findAll());
    }

    @Test
    public void saveOrUpdateTest() {
        Post post = new Post();
        post.setPostName("懂事长");
        post.setPostId("2c9090fc5fb48497015fb4849b490000");
        postDao.saveOrUpdate(post);
    }
}