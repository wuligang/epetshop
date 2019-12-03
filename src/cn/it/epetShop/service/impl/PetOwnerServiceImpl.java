
package cn.it.epetShop.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import cn.it.epetShop.dao.AccountDao;
import cn.it.epetShop.dao.PetDao;
import cn.it.epetShop.dao.PetOwnerDao;
import cn.it.epetShop.dao.impl.AccountDaoImpl;
import cn.it.epetShop.dao.impl.PetDaoImpl;
import cn.it.epetShop.dao.impl.PetOwnerDaoImpl;
import cn.it.epetShop.dao.impl.PetStoreDaoImpl;
import cn.it.epetShop.entity.Pet;
import cn.it.epetShop.entity.PetOwner;
import cn.it.epetShop.entity.PetStore;
import cn.it.epetShop.service.PetOwnerService;
import cn.it.epetShop.service.PetStoreService;

/**
 * @author  宠物主人实现类
 */
public class PetOwnerServiceImpl implements PetOwnerService {

	/**
	 * 宠物主人购买库存宠物，根据页面获得到的序号，来实际调用购买库存宠物或者购买新培育的宠物
	 */

	public void buy(Pet pet) {
		String sql = "select * from petowner where id=?";
		String param[] = { String.valueOf(pet.getOwnerId()) };
		PetOwnerDao ownerDao = new PetOwnerDaoImpl();
		PetOwner owner = ownerDao.selectOwner(sql, param);
		PetStoreService petStore = new PetStoreServiceImpl();
		int updatePet = petStore.modifyPet(pet, owner, null);// 更新宠物信息
		if (updatePet > 0) {// 更新宠物主人的信息
			int updateOwner = petStore.modifyOwner(owner, pet, 0);
			if (updateOwner > 0) {// 更新宠物商店的信息
				int updateStore = petStore.modifyStore(pet, 1);
				if (updateStore > 0) {// 更新宠物商店台帐信息
					int insertAccount = petStore.modifyAccount(pet, owner);
					if (insertAccount > 0) {
						System.out.println("台帐正确插入一条信息");
					}
				}
			}
		}
	}

	/**
	 * 宠物主人向宠物商店卖出自己宠物
	 */
	public void sell(Pet pet) {
		PetDaoImpl petDao = new PetDaoImpl();
		PetOwnerDaoImpl ownerDao = new PetOwnerDaoImpl();
		String updatesql = "update pet set owner_id = null where id=?";
		Object[] param = { pet.getId() };
		int updatePet = petDao.executeSQL(updatesql, param);// 更新宠物信息
		if (updatePet > 0) {// 更新宠物主人的信息
			String ownersql = "select * from petowner where id=?";
			String ownerparam[] = { String.valueOf(pet.getOwnerId()) };

			PetOwner owner = ownerDao.selectOwner(ownersql, ownerparam);
			String updateOwnerSql = "update petowner set money=? where id=?";
			Object[] ownerParam = { (owner.getMoney() + 3), owner.getId() };
			int updateOwner = ownerDao.executeSQL(updateOwnerSql, ownerParam);
			if (updateOwner > 0) {// 更新宠物商店的信息
				PetStoreServiceImpl store = new PetStoreServiceImpl();
				PetStore petStore = store.getPetStore(pet.getStoreId());
				String updateStore = "update petstore set balance=? where id=?";
				Object[] storeParam = { (petStore.getBalance() - 3),
						petStore.getId() };
				PetStoreDaoImpl storeDao = new PetStoreDaoImpl();
				int updatestore = storeDao.executeSQL(updateStore, storeParam);
				if (updatestore > 0) {// 更新宠物商店台帐信息
					String insertsql = "insert into account(deal_type,pet_id,seller_id,buyer_id,price,deal_time) values (?, ?, ?, ?, ?, ?)";
					String date = new SimpleDateFormat("yyyy-MM-dd")
							.format(new Date());
					Object[] accountParam = { 2, pet.getId(), owner.getId(),
							pet.getStoreId(), 3, date };
					AccountDao accountDao = new AccountDaoImpl();
					int insertAccount = accountDao.updateAccount(insertsql,
							accountParam);
					if (insertAccount > 0) {
						System.out.println("台帐正确插入一条信息");
					}
				}
			}
		}
	}

	/**
	 * 宠物主人登录
	 */
	public PetOwner login() {
		Scanner input = new Scanner(System.in);
		// 1、输入主人姓名
		System.out.println("请先登录，请您输入主人的名字：");
		String ownerName = input.nextLine().trim();
		System.out.println("请您输入主人的密码：");
		String ownerPassword = input.nextLine().trim();
		PetOwnerDao ownerDao = new PetOwnerDaoImpl();
		String sql = "select * from petowner where name=? and password=?";
		String[] param = { ownerName, ownerPassword };
		PetOwner owner = ownerDao.selectOwner(sql, param);
		if (null != owner) {
			System.out.println("-------恭喜您成功登录-------");
			System.out.println("-------您的基本信息：-------");
			System.out.println("名字：" + owner.getName());
			System.out.println("元宝数：" + owner.getMoney());
		}
		return owner;
	}

	/**
	 * 
	 * 根据宠物主人标识符（id）获得到该宠物主人所有宠物信息
	 */
	public List<Pet> getMyPet(int ownerId) {
		List<Pet> petList = new ArrayList<Pet>();
		String sql = "select * from pet where owner_id=?";
		String[] param = { String.valueOf(ownerId) };
		PetDao petDao = new PetDaoImpl();
		petList = petDao.selectPet(sql, param);
		return petList;
	}

}
