package com.lanou3g.crm.post.web.action;

import com.lanou3g.crm.post.service.PostService;
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
public class PostActionTest {
    @Resource
    private PostService postService;
    @Test
    public void findAllTest(){
        System.out.println(postService.findAll());
    }

}