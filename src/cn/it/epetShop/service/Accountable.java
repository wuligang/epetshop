/**
 * 
 */
package cn.it.epetShop.service;

import java.util.List;

import cn.it.epetShop.entity.Account;
import cn.it.epetShop.entity.Pet;
import cn.it.epetShop.entity.PetOwner;

/**
 * @author �������� �����̵�̨�˽ӿ�
 */
public interface Accountable {
	/**
	 * ��ѯ�����̵�̨����Ϣ
	 */
	public List<Account> account(long storeId);

	/**
	 * �޸ĳ����̵�̨����Ϣ
	 */
	public int modifyAccount(Pet pet, PetOwner owner);

}
