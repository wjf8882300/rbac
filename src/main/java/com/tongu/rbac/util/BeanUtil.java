package com.tongu.rbac.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtils;

import com.tongu.rbac.exception.RbacException;

public class BeanUtil {
	public static <T> T toBean(Map<String, Object> map, Class<T> type){
		T obj;
		try {
			obj = type.newInstance();
			ConvertUtils.register(new DateConverter(), java.util.Date.class);
			BeanUtilsBean.getInstance().populate(obj, map);
		} catch (InstantiationException e) {
			throw new RbacException(e.getMessage());
		} catch (IllegalAccessException e) {
			throw new RbacException(e.getMessage());
		} catch (InvocationTargetException e) {
			throw new RbacException(e.getMessage());
		}
		return obj;
	}
	
	public static void copyProperties(Object obj1, Object obj2){
		try {
			ConvertUtils.register(new DateConverter(), java.util.Date.class);
			BeanUtilsBean.getInstance().copyProperties(obj1, obj2);
		} catch (IllegalAccessException e) {
			throw new RbacException(e.getMessage());
		} catch (InvocationTargetException e) {
			throw new RbacException(e.getMessage());
		}
	}
}
