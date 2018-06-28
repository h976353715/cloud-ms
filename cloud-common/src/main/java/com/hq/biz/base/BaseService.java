package com.hq.biz.base;

/**
 * @author Administrator
 * @Package cocom.hq.biz.base
 * @Description: BaseService
 * @date 2018/4/17 17:49
 */
public interface BaseService<T> {

    int deleteByPrimaryKey(String id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
