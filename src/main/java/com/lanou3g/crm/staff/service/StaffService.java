package com.lanou3g.crm.staff.service;

import com.lanou3g.crm.base.BaseDao;
import com.lanou3g.crm.page.domain.PageBean;
import com.lanou3g.crm.staff.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public interface StaffService extends BaseDao<Staff> {

    Staff login(Staff staff);

    Staff staffById(String staffId);

    List<Staff> findStaffsByStaffName(String staffName);

    List<Staff> findStaffsByPostId(String postId);

    List<Staff> findStaffsByDepId(String depId);


    /**
     * 查询所有
     * @param staff
     * @param pageNum  当前页
     * @param pageSize 每页显示的条目数
     * @return
     */
    PageBean<Staff> findAllStaffs(Staff staff, int pageNum, int pageSize);



    Staff findStaffByLoginNameAndLoginPwd(Staff staff);
}
