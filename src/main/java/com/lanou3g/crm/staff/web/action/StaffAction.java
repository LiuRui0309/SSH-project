package com.lanou3g.crm.staff.web.action;

import com.lanou3g.crm.base.BaseAction;
import com.lanou3g.crm.staff.domain.Staff;
import com.lanou3g.crm.staff.service.StaffService;
import com.lanou3g.crm.staff.service.impl.StaffServiceImpl;
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
    private Staff staff = getModel();

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
            return SUCCESS;
        }
        addFieldError("msg","用户存在,更换用户名");
        return INPUT;
    }

    public Staff getStaff() {
        return staff;
    }
}
