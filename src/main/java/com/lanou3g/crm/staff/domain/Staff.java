package com.lanou3g.crm.staff.domain;

import com.lanou3g.crm.post.domain.Post;

/**
 * Created by dllo on 17/11/9.
 */
public class Staff {
    private String staffId;
    private String loginName;
    private String loginPwd;
    private String StaffName;
    private String gender;
    private String onDutyDate;
    
    private Post post;

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getStaffName() {
        return StaffName;
    }

    public void setStaffName(String staffName) {
        StaffName = staffName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOnDutyDate() {
        return onDutyDate;
    }

    public void setOnDutyDate(String onDutyDate) {
        this.onDutyDate = onDutyDate;
    }
}
