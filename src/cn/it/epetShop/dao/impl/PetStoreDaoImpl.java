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
import cn.it.epetShop.dao.PetStoreDao;
import cn.it.epetShop.entity.PetStore;

/**
 *�����̵����ݿ������
 */
public class PetStoreDaoImpl extends BaseDao implements PetStoreDao {
	private Connection conn = null; // �������ݿ�����

	private PreparedStatement pstmt = null; // ����ִ��SQL���

	private ResultSet rs = null; // �û������ѯ�����

	public List<PetStore> getAllStore() {
		List<PetStore> storeList = new ArrayList<PetStore>();
		try {
		String preparedSql = "select * from petstore ";
		conn = getConn(); // �õ����ݿ�����
		pstmt = conn.prepareStatement(preparedSql); // �õ�PreparedStatement����
		rs = pstmt.executeQuery(); // ִ��SQL���
			while (rs.next()) {
				PetStore petStore = new PetStore();
				petStore.setId(rs.getInt(1));
				petStore.setName(rs.getString(2));
				petStore.setPassword(rs.getString(3));
				petStore.setBalance(rs.getDouble(4));
				storeList.add(petStore);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return storeList;
	}

	public PetStore getPetStore(String sql, String[] param) {

		PetStore petStore = null;
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
				petStore = new PetStore();
				petStore.setId(rs.getInt(1));
				petStore.setName(rs.getString(2));
				petStore.setPassword(rs.getString(3));
				petStore.setBalance(rs.getDouble(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return petStore;
	}

	public int updateStore(String sql, Object[] param) {
		int count = super.executeSQL(sql, param);
		return count;
	}

}
