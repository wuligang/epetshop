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

import cn.it.epetShop.dao.BaseDao;
import cn.it.epetShop.dao.PetOwnerDao;
import cn.it.epetShop.entity.PetOwner;

/**
 *�����������ݿ������
 */

public class PetOwnerDaoImpl extends BaseDao implements PetOwnerDao {
	private Connection conn = null; // �������ݿ�����

	private PreparedStatement pstmt = null; // ����ִ��SQL���

	private ResultSet rs = null; // �û������ѯ�����

	public List<PetOwner> getAllOwner() {
		List<PetOwner> ownerList = new ArrayList<PetOwner>();
		try {
		String preparedSql = "select * from petowner ";
		conn = getConn(); // �õ����ݿ�����
		pstmt = conn.prepareStatement(preparedSql); // �õ�PreparedStatement����
		rs = pstmt.executeQuery(); // ִ��SQL���
			while (rs.next()) {
				PetOwner petOwner = new PetOwner();
				petOwner.setId(rs.getInt(1));
				petOwner.setName(rs.getString(2));
				petOwner.setPassword(rs.getString(3));
				petOwner.setMoney(rs.getDouble(4));
				ownerList.add(petOwner);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return ownerList;
	}

	public int updateOwner(String sql, String[] param) {
		int count = super.executeSQL(sql, param);
		return count;
	}

	public PetOwner selectOwner(String sql, String[] param) {
		PetOwner owner = null;
		try {
		conn = getConn(); // �õ����ݿ�����
		pstmt = conn.prepareStatement(sql); // �õ�PreparedStatement����
		if (param != null) {
			for (int i = 0; i < param.length; i++) {
				pstmt.setString(i + 1, param[i]); // ΪԤ����sql���ò���
			}
		}
		rs = pstmt.executeQuery(); // ִ��SQL���
			while (rs.next()) {
				owner = new PetOwner();
				owner.setId(rs.getInt(1));
				owner.setName(rs.getString(2));
				owner.setPassword(rs.getString(3));
				owner.setMoney(rs.getDouble(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return owner;
	}

}
