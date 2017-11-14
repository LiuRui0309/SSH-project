package com.lanou3g.crm.department.web.action;

import com.lanou3g.crm.department.domain.Department;
import com.lanou3g.crm.department.service.DepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/11/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class DepartmentActionTest {
    @Resource
    private DepartmentService departmentService;

    @Test
    public void test() {
        Department department = new Department();
        department.setDepName("市场");
        departmentService.save(department);
    }

    @Test
    public void addOrEdit(){
        Department department = new Department();
        department.setDepName("市场部");
        department.setDepId("2c90901b5faa6b84015faa6b87940000");
        departmentService.saveOrUpdate(department);
    }
    @Test
    public void addOrEditPreTest(){
        Department department = new Department();
//        department.setDepName("市场部");
        department.setDepId("2c9090fc5fb2e232015fb2e2357b0000");
        Department department1 = departmentService.findById(department);
        System.out.println(department1);
    }
}