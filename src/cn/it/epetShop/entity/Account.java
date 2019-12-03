/**
 * 
 */
package cn.it.epetShop.entity;

import java.util.Date;

/**
 * @author �������� �����̵�̨����
 * 
 */
public class Account {
	/**
	 * �ʵ���ʶ��
	 */
	private long id;

	/**
	 * �������ͣ�1--�����̵������������� 2--����������������̵� 3---��������֮�佻��
	 */
	private int dealType;

	/**
	 * �����ʶ��
	 */
	private long petId;

	/**
	 * ���ұ�ʶ��
	 */
	private long sellerId;

	/**
	 * ��ұ�ʶ��
	 */
	private long buyerId;

	/**
	 * ���׼۸�
	 */
	private double price;

	/**
	 * ����ʱ��
	 */
	private Date dealTime;

	/**
	 * @return the buyerId
	 */
	public long getBuyerId() {
		return buyerId;
	}

	/**
	 * @param buyerId
	 *            the buyerId to set
	 */
	public void setBuyerId(long buyerId) {
		this.buyerId = buyerId;
	}

	/**
	 * @return the dealTime
	 */
	public Date getDealTime() {
		return dealTime;
	}

	/**
	 * @param dealTime
	 *            the dealTime to set
	 */
	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}

	/**
	 * @return the dealType
	 */
	public int getDealType() {
		return dealType;
	}

	/**
	 * @param dealType
	 *            the dealType to set
	 */
	public void setDealType(int dealType) {
		this.dealType = dealType;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the petId
	 */
	public long getPetId() {
		return petId;
	}

	/**
	 * @param petId
	 *            the petId to set
	 */
	public void setPetId(long petId) {
		this.petId = petId;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the sellerId
	 */
	public long getSellerId() {
		return sellerId;
	}

	/**
	 * @param sellerId
	 *            the sellerId to set
	 */
	public void setSellerId(long sellerId) {
		this.sellerId = sellerId;
	}

}
