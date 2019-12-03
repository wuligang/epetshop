/**
 * 
 */
package cn.it.epetShop.service;

import cn.it.epetShop.entity.Pet;

/**
 *  宠物工厂接口
 */
public interface PetFactory {
	/**
	 * 培育新品种宠物
	 */
	public Pet breadNewPet(String[] petParam);
}
