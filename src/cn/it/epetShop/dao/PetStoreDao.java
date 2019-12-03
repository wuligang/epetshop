package cn.it.epetShop.dao;

import java.util.List;

import cn.it.epetShop.entity.PetStore;

public interface PetStoreDao {

	/**
	 * 查询出所有宠物商店
	 */
	public abstract List<PetStore> getAllStore();

	/**
	 * 根据查询条件查询出宠物商店
	 */
	public abstract PetStore getPetStore(String sql, String[] param);

	/**
	 * 更新宠物商店信息
	 */
	public abstract int updateStore(String sql, Object[] param);

}