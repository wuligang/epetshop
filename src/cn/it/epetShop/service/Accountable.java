/**
 * 
 */
package cn.it.epetShop.service;

import java.util.List;

import cn.it.epetShop.entity.Account;
import cn.it.epetShop.entity.Pet;
import cn.it.epetShop.entity.PetOwner;

/**
 * @author 北大青鸟 宠物商店台账接口
 */
public interface Accountable {
	/**
	 * 查询宠物商店台帐信息
	 */
	public List<Account> account(long storeId);

	/**
	 * 修改宠物商店台帐信息
	 */
	public int modifyAccount(Pet pet, PetOwner owner);

}
