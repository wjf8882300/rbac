package com.tongu.rbac.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import com.tongu.rbac.model.entity.LoginLogEntity;


/**   
 * 数据访问接口
 *  
 * @author  Tool
 * @version $Revision:1.0.0, $Date: 2016-05-16 14:14:57 $ 
 */
public interface LoginLogRepository extends Repository<LoginLogEntity, String>, JpaRepository<LoginLogEntity,String>{

}
