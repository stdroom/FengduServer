package com.demo.dao.daos;

import org.springframework.stereotype.Repository;
import com.demo.dao.interfaces.IRoleDao;
import com.demo.model.models.Role;
import com.infrastructure.project.base.dao.daos.EnableEntityDao;

@Repository("RoleDao")
public class RoleDao extends EnableEntityDao<Integer, Role> implements IRoleDao {


}
