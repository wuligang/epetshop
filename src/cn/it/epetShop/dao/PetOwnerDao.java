package cn.it.epetShop.dao;

import java.util.List;

import cn.it.epetShop.entity.PetOwner;

public interface PetOwnerDao {

	/**
	 * ��ѯ���г���������Ϣ
	 */
	public abstract List<PetOwner> getAllOwner();

	/**
	 * ���³���������Ϣ
	 */
	public abstract int updateOwner(String sql, String[] param);

	/**
	 * ���ݲ�ѯ������ѯ����������Ϣ
	 */
	public abstract PetOwner selectOwner(String sql, String[] param);

}