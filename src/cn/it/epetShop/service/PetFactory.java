/**
 * 
 */
package cn.it.epetShop.service;

import cn.it.epetShop.entity.Pet;

/**
 *  ���﹤���ӿ�
 */
public interface PetFactory {
	/**
	 * ������Ʒ�ֳ���
	 */
	public Pet breadNewPet(String[] petParam);
}
