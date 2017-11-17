package com.lanou3g.crm.staff.dao;

import com.lanou3g.crm.base.BaseDao;
import com.lanou3g.crm.staff.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public interface StaffDao extends BaseDao<Staff> {

    Staff findById(Staff staff);

    List<Staff> queryStaff(Staff staff);

    Staff staffById(String staffId);

    List<Staff> findStaffsByStaffName(String staffName);

    List<Staff> findStaffsByPostId(String postId);

    List<Staff> findStaffsByDepId(String depId);


    //分页用到的接口

    /**
     * 获得总的数据数目 -- 带条件的
     *
     * @return
     */
    int getTotalRecord();

    /**
     * 获取到的数据 -- 带分页的参数
     *
     * @param startIndex 开始索引
     * @param pageSize   每页显示的记录
     * @return
     */
    List<Staff> findAllStaffs(int startIndex, int pageSize);


    List<Staff> findStaffByLoginNameAndLoginPwd(Staff staff);
}
