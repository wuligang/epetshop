/**
 * 
 */
package cn.it.epetShop.service;

import java.util.List;

import cn.it.epetShop.entity.Pet;
import cn.it.epetShop.entity.PetOwner;
import cn.it.epetShop.entity.PetStore;

/**
 * @author �������� �����̵�ӿ�
 */
public interface PetStoreService extends Accountable, Breadable, Buyable, Sellable {
	/**
	 * ��ѯ�����п�����
	 */
	public List<Pet> getPetsInstock(long storeId);

	/**
	 * ��ѯ�������������ĳ���
	 */
	public List<Pet> getPetsBread();

	/**
	 * ��ѯ�������������ĳ���
	 */
	public double charge(Pet pet);

	/**
	 * ���ݳ���������Ϣ�޸ĳ�����Ϣ
	 */
	public int modifyPet(Pet pet, PetOwner petOwner,
                         PetStore store);

	/**
	 * �޸ĳ���������Ϣ
	 */
	public int modifyOwner(PetOwner owner, Pet pet, int type);

	/**
	 * ���ݳ����̵��ʶ����ѯ�����̵�
	 */
	public PetStore getPetStore(long id);

	/**
	 * �޸ĳ����̵���Ϣ
	 */
	public int modifyStore(Pet pet, int type);

	/**
	 * �����̵��¼
	 */
	public PetStore login();

	/**
	 * ��ѯ�����г����������ڳ��۵ĳ���
	 */
	public List<Pet> getPetSelling();
}
