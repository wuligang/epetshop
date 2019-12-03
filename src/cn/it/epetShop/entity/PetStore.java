/**
 * 
 */
package cn.it.epetShop.entity;

/**
 * 宠物商店实体类
 * 
 */
public class PetStore {
	/**
	 * 宠物商店id
	 */
	private long id;

	/**
	 * 宠物商店名称
	 */
	private String name;

	/**
	 * 宠物商店密码
	 */
	private String password;

	/**
	 * 宠物商店资金
	 */
	private double balance;

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

	/**
	 * @return the balance 得到宠物商店结余
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance
	 *            the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

}
