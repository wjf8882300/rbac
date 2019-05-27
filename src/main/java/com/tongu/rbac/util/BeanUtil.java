package com.tongu.rbac.util;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

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
	
	public static void copyProperties(Object src, Object dest){
		try {
			ConvertUtils.register(new DateConverter(), java.util.Date.class);
			BeanUtilsBean.getInstance().copyProperties(dest, src);
			
		} catch (IllegalAccessException e) {
			throw new RbacException(e.getMessage());
		} catch (InvocationTargetException e) {
			throw new RbacException(e.getMessage());
		}
	}
	
	public static String[] getNullPropertyNames (Object source) {
	    final BeanWrapper src = new BeanWrapperImpl(source);
	    java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

	    Set<String> emptyNames = new HashSet<String>();
	    for(java.beans.PropertyDescriptor pd : pds) {
	        Object srcValue = src.getPropertyValue(pd.getName());
	        if (srcValue == null) emptyNames.add(pd.getName());
	    }
	    String[] result = new String[emptyNames.size()];
	    return emptyNames.toArray(result);
	}
	
	public static void copyPropertiesIgnoreNull(Object src, Object target) {
	    BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
	}
}
