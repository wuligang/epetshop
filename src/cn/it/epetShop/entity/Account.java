/**
 * 
 */
package cn.it.epetShop.entity;

import java.util.Date;

/**
 * @author 北大青鸟 宠物商店台帐类
 * 
 */
public class Account {
	/**
	 * 帐单标识符
	 */
	private long id;

	/**
	 * 交易类型，1--代表商店卖给宠物主人 2--代表宠物主人卖给商店 3---宠物主人之间交易
	 */
	private int dealType;

	/**
	 * 宠物标识符
	 */
	private long petId;

	/**
	 * 卖家标识符
	 */
	private long sellerId;

	/**
	 * 买家标识符
	 */
	private long buyerId;

	/**
	 * 交易价格
	 */
	private double price;

	/**
	 * 交易时间
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
