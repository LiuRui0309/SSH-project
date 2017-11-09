package com.lanou3g.crm.staff.action;

import com.lanou3g.crm.base.BaseAction;
import com.lanou3g.crm.staff.domain.Staff;
import com.lanou3g.crm.staff.service.StaffService;
import com.lanou3g.crm.staff.service.impl.StaffServiceImpl;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/11/9.
 */
@Controller("staffAction")
@Scope("prototype")
public class StaffAction extends BaseAction<Staff, StaffServiceImpl> {

    @Resource
    private StaffService staffService;

    public String login() {
        Staff staff = getModel();
        staffService.login(staff);
        return SUCCESS;
    }

}
