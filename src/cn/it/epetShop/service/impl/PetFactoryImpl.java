
package cn.it.epetShop.service.impl;

import cn.it.epetShop.entity.Pet;
import cn.it.epetShop.service.PetFactory;

/**
 * 宠物工厂实现类
 */
public class PetFactoryImpl implements PetFactory {
	/**
	 * 宠物工程培育新品种宠物
	 */
	public Pet breadNewPet(String[] petParam) {
		Pet pet = new Pet();
		pet.setName(petParam[0]);
		pet.setTypeName(petParam[1]);
		pet.setHealth(Integer.parseInt(petParam[2]));
		pet.setLove(Integer.parseInt(petParam[3]));
		pet.setStoreId(Integer.parseInt(petParam[4]));
		return pet;
	}
}
