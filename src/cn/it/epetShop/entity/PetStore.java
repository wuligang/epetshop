/**
 * 
 */
package cn.it.epetShop.entity;

/**
 * �����̵�ʵ����
 * 
 */
public class PetStore {
	/**
	 * �����̵�id
	 */
	private long id;

	/**
	 * �����̵�����
	 */
	private String name;

	/**
	 * �����̵�����
	 */
	private String password;

	/**
	 * �����̵��ʽ�
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
	 * @return the balance �õ������̵����
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
