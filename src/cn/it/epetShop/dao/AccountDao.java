package cn.it.epetShop.dao;

import java.util.List;

import cn.it.epetShop.entity.Account;

public interface AccountDao {

	/**
	 * ����̨����Ϣ
	 */
	public abstract int updateAccount(String sql, Object[] param);

	/**
	 * ���ݲ�ѯ������ѯ�������̵��ʵ�
	 */
	public abstract List<Account> getPetStoreAccount(String sql, String[] param);

}