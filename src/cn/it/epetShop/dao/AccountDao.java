package cn.it.epetShop.dao;

import java.util.List;

import cn.it.epetShop.entity.Account;

public interface AccountDao {

	/**
	 * 更新台帐信息
	 */
	public abstract int updateAccount(String sql, Object[] param);

	/**
	 * 根据查询条件查询出宠物商店帐单
	 */
	public abstract List<Account> getPetStoreAccount(String sql, String[] param);

}