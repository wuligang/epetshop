/**
 * 
 */
package cn.it.epetShop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.it.epetShop.dao.AccountDao;
import cn.it.epetShop.dao.BaseDao;
import cn.it.epetShop.entity.Account;

/**
 * �����̵�̨����Ϣ���ݿ������
 */
public class AccountDaoImpl extends BaseDao implements AccountDao {
	private Connection conn = null; // �������ݿ�����

	private PreparedStatement pstmt = null; // ����ִ��SQL���

	private ResultSet rs = null; // �û������ѯ�����

	
	public int updateAccount(String sql, Object[] param) {
		int count = super.executeSQL(sql, param);
		return count;
	}

	
	public List<Account> getPetStoreAccount(String sql, String[] param) {
		List<Account> accountList = new ArrayList<Account>();
		try {
			conn = getConn(); // �õ����ݿ�����
			pstmt = conn.prepareStatement(sql); // �õ�PreparedStatement����
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setString(i + 1, param[i]); // ΪԤ����sql���ò���
				}
			}
			rs = pstmt.executeQuery(); // ִ��SQL���
			Account account = null;
			while (rs.next()) {
				account = new Account();
				account.setId(rs.getInt(1));
				account.setDealType(rs.getInt(2));
				account.setPetId(rs.getInt(3));
				account.setSellerId(rs.getInt(4));
				account.setBuyerId(rs.getInt(5));
				account.setPrice(rs.getDouble(6));
				account.setDealTime(rs.getDate(7));
				accountList.add(account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return accountList;
	}
}
