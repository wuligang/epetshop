package cn.it.epetShop.dao;

import java.util.List;

import cn.it.epetShop.entity.PetOwner;

public interface PetOwnerDao {

	/**
	 * 查询所有宠物主人信息
	 */
	public abstract List<PetOwner> getAllOwner();

	/**
	 * 更新宠物主人信息
	 */
	public abstract int updateOwner(String sql, String[] param);

	/**
	 * 根据查询条件查询宠物主人信息
	 */
	public abstract PetOwner selectOwner(String sql, String[] param);

}