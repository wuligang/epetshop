package cn.it.epetShop.dao;

import java.util.List;

import cn.it.epetShop.entity.Pet;

public interface PetDao {

	/**
	 * ��ѯ���г�����Ϣ
	 */
	public abstract List<Pet> getAllPet();

	/**
	 * ������֪�������Ϣ��ѯ������Ϣ
	 */
	public abstract List<Pet> selectPet(String sql, String[] param);

	/**
	 * ���³�����Ϣ
	 */
	public abstract int updatePet(String sql, Object[] param);

}