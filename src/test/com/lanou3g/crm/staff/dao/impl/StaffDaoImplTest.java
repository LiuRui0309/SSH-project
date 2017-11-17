package com.lanou3g.crm.staff.dao.impl;

import com.lanou3g.crm.department.domain.Department;
import com.lanou3g.crm.post.domain.Post;
import com.lanou3g.crm.staff.dao.StaffDao;
import com.lanou3g.crm.staff.domain.Staff;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class StaffDaoImplTest {
    @Resource
    private StaffDao staffDao;

    @Test
    public void save() {
        Post post = new Post();
        Department department = new Department();
        post.setPostName("总监");
        department.setDepName("教研部");
        Staff staff = new Staff();
        staff.setStaffName("老孟");
        staff.setLoginName("lm");
        staff.setLoginPwd("1");
        staff.setPost(post);
        post.setDepartment(department);
        staffDao.save(staff);
    }

    @Test
    public void findAll() {
        List<Staff> staffList = staffDao.findAll();
        System.out.println(staffList);
    }

    @Test
    public void staffByIdTest(){

        System.out.println(staffDao.staffById("2c90901b5fa4b01c015fa4b026980000"));
    }

    @Test
    public void findStaffsByStaffNameTest(){
        staffDao.findStaffsByStaffName("韩国进口件");
    }
    @Test
    public void findStaffsByPostIdTest(){
        staffDao.findStaffsByPostId("2c90901b5fa5b76f015fa5b773fb0001");
    }

    @Test
    public void findStaffsByDepIdTest(){

        staffDao.findStaffsByDepId("2c9090fc5fb96df4015fb979915e0000");
    }

    @Test
    public void getTotalRecordTest(){
        System.out.println(staffDao.getTotalRecord());
    }
    @Test
    public void findAllStaffsTest(){
        System.out.println(staffDao.findAllStaffs(1,2));
    }
    @Test
    public void findStaffByLoginNameAndLoginPwdTest(){

        Staff staff = new Staff();
        staff.setLoginPwd("123");
        staff.setLoginName("zw");
        System.out.println(staffDao.findStaffByLoginNameAndLoginPwd(staff));
    }
}