package cn.it.epetShop.entity;

/**
 * ��������ʵ����
 * 
 */
public class PetOwner {
	/**
	 * �������˱�ʶ��
	 */
	private int id;

	/**
	 * ������������
	 */
	private String name;

	/**
	 * ������������
	 */
	private String password;

	/**
	 * ��������Ԫ����
	 */
	private double money;

	/**
	 * @return the money
	 */
	public double getMoney() {
		return money;
	}

	/**
	 * @param money
	 *            the money to set
	 */
	public void setMoney(double money) {
		this.money = money;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
