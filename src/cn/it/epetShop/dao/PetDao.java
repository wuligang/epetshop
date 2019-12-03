package cn.it.epetShop.dao;

import java.util.List;

import cn.it.epetShop.entity.Pet;

public interface PetDao {

	/**
	 * 查询所有宠物信息
	 */
	public abstract List<Pet> getAllPet();

	/**
	 * 根据已知宠物的信息查询宠物信息
	 */
	public abstract List<Pet> selectPet(String sql, String[] param);

	/**
	 * 更新宠物信息
	 */
	public abstract int updatePet(String sql, Object[] param);

}