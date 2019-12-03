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
import cn.it.epetShop.dao.PetDao;
import cn.it.epetShop.entity.Pet;

/**
 * �������ݿ������
 */
public class PetDaoImpl extends BaseDao implements PetDao {
	private Connection conn = null; // �������ݿ�����

	private PreparedStatement pstmt = null; // ����ִ��SQL���

	private ResultSet rs = null; // �û������ѯ�����

	
	public List<Pet> getAllPet() {
		List<Pet> petList = new ArrayList<Pet>();
		try {
			String preparedSql = "select id,name,typeName,health,love,birthday,owner_id,store_id from pet ";
			conn = getConn(); // �õ����ݿ�����
			pstmt = conn.prepareStatement(preparedSql); // �õ�PreparedStatement����
			rs = pstmt.executeQuery(); // ִ��SQL���

			while (rs.next()) {

				Pet pet = new Pet();
				pet.setId(rs.getInt(1));
				pet.setName(rs.getString(2));
				pet.setTypeName(rs.getString(3));
				pet.setHealth(rs.getInt(4));
				pet.setLove(rs.getInt(5));
				pet.setBirthday(rs.getDate(6));
				pet.setOwnerId(rs.getInt(7));
				pet.setStoreId(rs.getInt(8));
				petList.add(pet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return petList;
	}

	
	public List<Pet> selectPet(String sql, String[] param) {
		List<Pet> petList = new ArrayList<Pet>();
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
				Pet pet = new Pet();
				pet.setId(rs.getInt(1));
				pet.setName(rs.getString(2));
				pet.setTypeName(rs.getString(3));
				pet.setHealth(rs.getInt(4));
				pet.setLove(rs.getInt(5));
				pet.setBirthday(rs.getDate(6));
				pet.setOwnerId(rs.getInt(7));
				pet.setStoreId(rs.getInt(8));
				petList.add(pet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return petList;
	}

	
	public int updatePet(String sql, Object[] param) {
		int count = super.executeSQL(sql, param);
		return count;
	}

}
