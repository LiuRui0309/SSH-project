package com.lanou3g.crm.staff.web.action;

import com.lanou3g.crm.post.service.PostService;
import com.lanou3g.crm.staff.domain.Staff;
import com.lanou3g.crm.staff.service.StaffService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/11/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class StaffActionTest {
    @Resource
    private StaffService staffService;
    @Resource
    private PostService postService;
    @Test
    public void test(){
        List<Staff> staffList = staffService.findAll();
        System.out.println(staffList);
    }


    @Test
    public void getPostByDepIdTest(){
        postService.getPostByDepId("2c90901b5fa4b01c015fa4b026af0002");
    }

}