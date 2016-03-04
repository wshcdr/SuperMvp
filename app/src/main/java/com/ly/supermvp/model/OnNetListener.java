package com.ly.supermvp.model;

/**
 * <Pre>
 * 网络加载接口
 * </Pre>
 *
 * @author 刘阳
 * @version 1.0
 *          <p/>
 *          Create by 2016/3/4 11:28
 */
public interface OnNetListener<T> {
    /**
     * 网络请求开始
     */
    void start();

    /**
     * 网络请求结束
     */
    void finish();

    /**
     * 网络请求成功
     * @param data 返回的数据实体类信息 泛型定义
     */
    void onSuccess(T data);

    /**
     * 请求失败
     * @param t 异常
     */
    void onFailure(Throwable t);
}
