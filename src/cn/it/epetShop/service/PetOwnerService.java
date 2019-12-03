/**
 * 
 */
package cn.it.epetShop.service;

import java.util.List;

import cn.it.epetShop.entity.Pet;
import cn.it.epetShop.entity.PetOwner;

/**
 * @author 北大青鸟 宠物主人接口
 * 
 */
public interface PetOwnerService extends Sellable, Buyable {

	/**
	 * 宠物主人登录
	 */
	public PetOwner login();

	/**
	 * 根据宠物主人标识符（id）获得到该宠物主人所有宠物信息
	 */
	public List<Pet> getMyPet(int ownerId);
}
