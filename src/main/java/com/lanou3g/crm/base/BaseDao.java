package com.lanou3g.crm.base;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public interface BaseDao<T> {
    //添加
    boolean save(T t);
    //删除
    boolean delete(T t);
    // 更新
    boolean update(T t);
    //保存更新
    boolean saveOrUpdate(T t);
    //通过id查询
    T findById(Serializable id);
    //查询所有
    List<T> findAll();
    /**
     * 带有条件查询
     * @param condition 条件
     * @param params   参数
     * @return
     */
    List<T> findAll(String condition,Object...params);
}
