package com.lanou3g.crm.staff.service;

import com.lanou3g.crm.base.BaseDao;
import com.lanou3g.crm.staff.domain.Staff;

/**
 * Created by dllo on 17/11/9.
 */
public interface StaffService extends BaseDao<Staff> {

    void login(Staff staff);
}
