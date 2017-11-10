package com.lanou3g.crm.base;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Required;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


/**
 * Created by dllo on 17/11/9.
 */
/*
泛型页可以称之为类的参数,
参数的类型是某个类而不是对象
T:type
E:Element/Entity
K:key
V:value
 */
public class BaseAction<T,S> extends ActionSupport implements ModelDriven<T>{

    protected T model;
    protected S service;
    private static String LOGIN_KEY = "key_uuid";
    public BaseAction() {
        //获取当前类的class
        Class<? extends BaseAction> clazz = getClass();
        //再获取父类的泛型参数
        ParameterizedType type = (ParameterizedType) clazz.getGenericSuperclass();
        //获取所有泛型的集合,(因为可能会有多个泛型)
        Type[] typeArguments = type.getActualTypeArguments();
        //因为当前类只有一个泛型参数,
        //所以取第0个,就获取到了泛型的class
        Class modelClass = (Class) typeArguments[0];
        //根据反射创建出泛型的对象
        try {
            model = (T) modelClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T getModel() {
        return model;
    }

    //向session中存放数据
    public void sessionPut(String key,Object value){
        ActionContext.getContext().getSession().put(key,value);
    }
    //向application中存放数据
    public void applicationPut(String key,Object value){
        ActionContext.getContext().put(key,value);
    }
    //向request中存放数据
    public void requestPut(String key,Object value){
    }
    //向context中存放数据

    public HttpServletRequest getRequest(){
        return ServletActionContext.getRequest();
    }
    public HttpServletResponse getResponse(){
        return ServletActionContext.getResponse();
    }

    public void setService(S service) {
        this.service = service;
    }
}
