package cn.it.epetShop.entity;

/**
 * 宠物主人实体类
 * 
 */
public class PetOwner {
	/**
	 * 宠物主人标识符
	 */
	private int id;

	/**
	 * 宠物主人名称
	 */
	private String name;

	/**
	 * 宠物主人密码
	 */
	private String password;

	/**
	 * 宠物主人元宝数
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
