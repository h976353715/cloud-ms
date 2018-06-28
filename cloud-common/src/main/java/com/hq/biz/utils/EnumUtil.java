package com.hq.biz.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangqi
 * @Package com.zm.business.util
 * @Description: 枚举工具类
 * @date 2018/6/14 14:35
 */
public class EnumUtil {

    private static Logger logger = LoggerFactory.getLogger(EnumUtil.class);

    /**
     * 获取枚举的值 返回list
     * 该方法需要在枚举类中实现 preferences() 方法
     *
     * @param typeName 枚举类的前缀 如:获取SubjectEnum枚举值需传入Subject
     * @return {"name":"","value":""}
     */
    public static List covertToList(String typeName) {
        try {

            //这里的typeName就是枚举对象的名称,是需要写全路径的
            Class<?> onwClass = Class.forName("com.zm.business.enums." + typeName + "Enum");
            //这里是获得枚举的遍历方法  即:枚举对象.values();一样
            Method method = onwClass.getMethod("preferences");
            //这里获取所有的枚举对象 method.invoke(null)也可写成method.invoke(null,null)
            List invokeReturns = (List) method.invoke(null);
            return invokeReturns;
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    /**
     * 获取枚举的值 返回map
     * 该方法需要在枚举类中实现 String getCode() ,String getDesc() 方法
     *
     * @param typeName 枚举类的前缀 如:获取SubjectEnum枚举值需传入Subject
     * @return {"code":"value"}
     */
    public static Map covertToMap(String typeName) {
        try {
            LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
            Class<?> onwClass = Class.forName("com.zm.business.enums." + typeName + "Enum");
            Method getCode = onwClass.getMethod("getCode");
            Method getDesc = onwClass.getMethod("getDesc");
            Method name = onwClass.getMethod("name");

            //得到enum的所有实例
            Object[] objs = onwClass.getEnumConstants();
            for (Object obj : objs) {
                map.put(String.valueOf(getCode.invoke(obj)), String.valueOf(getDesc.invoke(obj)));
            }
            return map;
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    /**
     * 获取枚举的值 返回map 可忽略该枚举类的某些值
     * 该方法需要在枚举类中实现 String getCode() ,String getDesc() 方法
     *
     * @param typeName 枚举类的前缀 如:获取SubjectEnum枚举值需传入Subject
     * @param typeName ignores 忽略枚举值的名称，区分大小写
     * @return {"code":"value"}
     */
    public static Map covertToMap(String typeName, String... ignores) {
        try {
            if (ignores == null) {
            }
            LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
            Class<?> onwClass = Class.forName("com.zm.business.enums." + typeName + "Enum");
            Method getCode = onwClass.getMethod("getCode");
            Method getDesc = onwClass.getMethod("getDesc");
            Method name = onwClass.getMethod("name");
            List<String> ignoresList = Arrays.asList(ignores);

            //得到enum的所有实例
            Object[] objs = onwClass.getEnumConstants();
            for (Object obj : objs) {
                if (!ignoresList.contains((String) name.invoke(obj))) {
                    map.put(String.valueOf(getCode.invoke(obj)), String.valueOf(getDesc.invoke(obj)));
                }
            }
            return map;
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            logger.error(e.getMessage());
        }
        return null;
    }


    /**
     * 获取枚举的值 返回map 可选择枚举类的某些值
     * 该方法需要在枚举类中实现 String getCode() ,String getDesc() 方法
     *
     * @param typeName 枚举类的前缀 如:获取SubjectEnum枚举值需传入Subject
     * @param typeName optionals 选择枚举值的名称，区分大小写
     * @return {"code":"value"}
     */
    public static Map covertToMapOptionals(String typeName, String... optionals) {
        try {
            if (optionals == null) {
            }
            LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
            Class<?> onwClass = Class.forName("com.zm.business.enums." + typeName + "Enum");
            Method getCode = onwClass.getMethod("getCode");
            Method getDesc = onwClass.getMethod("getDesc");
            Method name = onwClass.getMethod("name");
            List<String> ignoresList = Arrays.asList(optionals);

            //得到enum的所有实例
            Object[] objs = onwClass.getEnumConstants();
            for (Object obj : objs) {
                if (ignoresList.contains((String) name.invoke(obj))) {
                    map.put(String.valueOf(getCode.invoke(obj)), String.valueOf(getDesc.invoke(obj)));
                }
            }
            return map;
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            logger.error(e.getMessage());
        }
        return null;
    }


}
