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
 *宠物主人数据库操作类
 */

public class PetOwnerDaoImpl extends BaseDao implements PetOwnerDao {
	private Connection conn = null; // 保存数据库连接

	private PreparedStatement pstmt = null; // 用于执行SQL语句

	private ResultSet rs = null; // 用户保存查询结果集

	public List<PetOwner> getAllOwner() {
		List<PetOwner> ownerList = new ArrayList<PetOwner>();
		try {
		String preparedSql = "select * from petowner ";
		conn = getConn(); // 得到数据库连接
		pstmt = conn.prepareStatement(preparedSql); // 得到PreparedStatement对象
		rs = pstmt.executeQuery(); // 执行SQL语句
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
		conn = getConn(); // 得到数据库连接
		pstmt = conn.prepareStatement(sql); // 得到PreparedStatement对象
		if (param != null) {
			for (int i = 0; i < param.length; i++) {
				pstmt.setString(i + 1, param[i]); // 为预编译sql设置参数
			}
		}
		rs = pstmt.executeQuery(); // 执行SQL语句
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
