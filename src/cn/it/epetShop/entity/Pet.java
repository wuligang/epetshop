/**
 * 
 */
package cn.it.epetShop.entity;

import java.util.Date;

/**
 * ����ʵ����
 * 
 */
public class Pet {
	/*
	 * �����ʶ��
	 */
	private long id;

	/**
	 * ��������
	 */
	private String name;

	/**
	 * �������
	 */
	private String typeName;

	/**
	 * ���｡��ָ��
	 */
	private int health;

	/**
	 * ���ﰮ��
	 */
	private int love;

	/**
	 * ��������
	 */
	private Date birthday;

	/**
	 * ���������������˱�ʶ��
	 */
	private int ownerId;

	/**
	 * �������������̵��ʶ��
	 */
	private long storeId;

	/**
	 * @return the ownerId
	 */
	public int getOwnerId() {
		return ownerId;
	}

	/**
	 * @param ownerId
	 *            the ownerId to set
	 */
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	/**
	 * @return the birthdate
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @return the storeId
	 */
	public long getStoreId() {
		return storeId;
	}

	/**
	 * @param storeId
	 *            the storeId to set
	 */
	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}

	/**
	 * @param birthdate
	 *            the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @param health
	 *            the health to set
	 */
	public void setHealth(int health) {
		this.health = health;
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
	 * @return the love
	 */
	public int getLove() {
		return love;
	}

	/**
	 * @param love
	 *            the love to set
	 */
	public void setLove(int love) {
		this.love = love;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the typeName
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * @param typeName
	 *            the typeName to set
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
