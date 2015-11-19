package com.demo.dao.daos;

import org.springframework.stereotype.Repository;
import com.demo.dao.interfaces.IAccountDao;
import com.demo.model.models.Account;
import com.infrastructure.project.base.dao.daos.EnableEntityDao;

@Repository("AccountDao")
public class AccountDao extends EnableEntityDao<Integer, Account> implements IAccountDao {


}
