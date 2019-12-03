/**
 * 
 */
package cn.it.epetShop.service;

import java.util.List;

import cn.it.epetShop.entity.Pet;
import cn.it.epetShop.entity.PetOwner;

/**
 * @author �������� �������˽ӿ�
 * 
 */
public interface PetOwnerService extends Sellable, Buyable {

	/**
	 * �������˵�¼
	 */
	public PetOwner login();

	/**
	 * ���ݳ������˱�ʶ����id����õ��ó����������г�����Ϣ
	 */
	public List<Pet> getMyPet(int ownerId);
}
