/**
 * 
 */
package cn.it.epetShop.service;

import cn.it.epetShop.entity.Pet;

/**
 * @author 北大青鸟 买宠物接口
 */
public interface Buyable {
	/**
	 * 宠物主人购买库存宠物
	 */
	public void buy(Pet pet);
}
