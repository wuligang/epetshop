
package cn.it.epetShop.service.impl;

import java.util.Scanner;

import cn.it.epetShop.dao.PetStoreDao;
import cn.it.epetShop.dao.impl.PetStoreDaoImpl;
import cn.it.epetShop.service.PetStoreFactory;

/**
 * @author 宠物商店工程实现类
 */
public class PetStoreFactoryImpl implements PetStoreFactory {

	/**
	 * 创建宠物商店
	 */
	public void createPetStore() {
		Scanner input = new Scanner(System.in);
		System.out.println("请在下面输入宠物商店属性：");
		System.out.println("请输入宠物商店名字：");
		String storeName = input.nextLine();
		System.out.println("请输入宠物商店的密码（英文加数字）：");
		String storePassword = input.nextLine();
		System.out.println("请输入宠物商店的资金（整数）：");
		String petBalance = input.nextLine();
		String sql = "insert into petstore(`name`,`password`,balance) values(?,?,?)";
		Object[] param = { storeName, storePassword, petBalance };
		PetStoreDao storeDao = new PetStoreDaoImpl();
		int count = storeDao.updateStore(sql, param);
		if (count > 0) {
			System.out.println("成功创建了一个宠物商店，商店名字叫" + storeName);
		}
	}

}
