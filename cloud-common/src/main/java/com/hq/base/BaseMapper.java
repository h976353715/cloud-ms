package com.hq.base;

/**
 * @author Administrator
 * @Package com.hq.base
 * @Description: BaseMapper
 * @date 2018/4/17 11:08
 */
public interface BaseMapper<T> {

    int deleteByPrimaryKey(String id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
