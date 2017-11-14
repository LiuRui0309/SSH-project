package com.lanou3g.crm.department.web.action;

import com.lanou3g.crm.base.BaseAction;
import com.lanou3g.crm.department.domain.Department;
import com.lanou3g.crm.department.service.DepartmentService;
import com.lanou3g.crm.department.service.impl.DepartmentServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department, DepartmentService> {
    @Resource
    private DepartmentService departmentService;

    private Department department = getModel();

    private List<Department> departments;

    //查询所有
    public String findAllDepts() {
        departments = departmentService.findAll();
        applicationPut("department", departments);
        return "success";
    }

    //按id查询
    public String findById() {
        departmentService.findById(getModel());
        return SUCCESS;
    }

    //添加或更新
    public String addOrEdit() {
        boolean saveOrUpdate = departmentService.saveOrUpdate(getModel());
        if (saveOrUpdate) {
            return SUCCESS;
        }
        addFieldError("msg","部门名不能为空");
        return INPUT;
    }

    //添加或更新之前判断
    public String addOrEditPre() {
        if (department.getDepId() == null || department.getDepId().trim().equals("")) {
            return SUCCESS;
        } else {
            Department department1 = departmentService.findById(department);
            applicationPut("depId", department1.getDepId());
            applicationPut("depName", department1.getDepName());
            return SUCCESS;
        }
    }

    public List<Department> getDepartments() {
        return departments;
    }

}
