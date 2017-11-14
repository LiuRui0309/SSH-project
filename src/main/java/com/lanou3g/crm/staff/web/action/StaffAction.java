package com.lanou3g.crm.staff.web.action;

import com.lanou3g.crm.base.BaseAction;
import com.lanou3g.crm.department.domain.Department;
import com.lanou3g.crm.department.service.DepartmentService;
import com.lanou3g.crm.staff.domain.Staff;
import com.lanou3g.crm.staff.service.StaffService;
import com.lanou3g.crm.staff.service.impl.StaffServiceImpl;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
@Controller("staffAction")
@Scope("prototype")
public class StaffAction extends BaseAction<Staff, StaffServiceImpl> {

    @Resource
    private StaffService staffService;
    @Resource
    private DepartmentService departmentService;

    private Staff staff= getModel();
    private List<Staff> staffs;
    private List<Department> departments;


    public String login() {
       Staff staff1 = staffService.login(staff);
        if (staff1 !=null) {
            sessionPut("login",staff.getLoginName());
            return SUCCESS;
        }
        addFieldError("msg","用户不存在");
        return INPUT;
    }

    public String addStaff() {
        boolean saveStaff = staffService.save(staff);
        if (saveStaff){
            List<Staff> staffList = staffService.findAll();
            applicationPut("staffList",staffList);
            return SUCCESS;
        }
        addFieldError("msg","用户存在,更换用户名");
        return INPUT;
    }

    public Staff getStaff() {
        return staff;
    }

    public String home() {
        return "home";
    }

    /**
     * 查询全部员工
     * @return
     */
    @SkipValidation
    public String findAllStaffs() {
        staffs = staffService.findAll();
        departments = departmentService.findAll();
        return SUCCESS;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public List<Department> getDepartments() {
        return departments;
    }
}
