package singer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.OracleConnectUtil;

public class SingerDao {

	private static SingerDao singerDao = new SingerDao();
	private SingerDao() {   }
	public static SingerDao getSingerDao() {
		return singerDao;
	}
	
	//selectAll
	public List<Singer> selectAll() {
		Connection conn = OracleConnectUtil.connect();
		String sql = "SELECT * FROM SINGER";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Singer> singer = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				singer.add(new Singer(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
			}
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("SQL 실행 오류:" + e.getMessage());
		}
		OracleConnectUtil.close(conn);
		return singer;
	}
	
	//selectOne
	public static Singer selectOne(String num) {
		Connection conn = OracleConnectUtil.connect();
		String sql = "SELECT * FROM SINGER WHERE num=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Singer vo = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new Singer();
				vo.setNum(rs.getString(1));
				vo.setName(rs.getString(2));
				vo.setBirth(rs.getDate(3));
				vo.setNat(rs.getString(4));
				vo.setTeam_name(rs.getString(5));
				vo.setPart(rs.getString(6));
				vo.setSns(rs.getString(7));
			}
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("SQL 실행 오류:" + e.getMessage());
		}
		OracleConnectUtil.close(conn);
		return vo;
	}
	
	//INSERT
	public void insert(Singer vo) {
		Connection conn = OracleConnectUtil.connect();
		String sql = "INSERT INTO Singer" + "(NUM, NAME, BIRTH, NAT, TEAM_NAME, PART, SNS)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getNum());
			pstmt.setString(2, vo.getName());
			pstmt.setDate(3, vo.getBirth());
			pstmt.setString(4, vo.getNat());
			pstmt.setString(5, vo.getTeam_name());
			pstmt.setString(6, vo.getPart());
			pstmt.setString(7, vo.getSns());
			pstmt.execute();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("sql 실행 오류" + e.getMessage());
		}
		OracleConnectUtil.close(conn);
	}
	//UPDATE
	public void update(Singer vo) { 
		Connection conn = OracleConnectUtil.connect();
		PreparedStatement pstmt = null;
		String sql = "UPDATE Singer SET SNS=? WHERE NUM = ?";
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getSns()); 
			pstmt.setString(2, vo.getNum()); 
			pstmt.execute();
			pstmt.close();

		} catch (SQLException e) {
			System.out.println("sql 실행오류 :" + e.getMessage());
		}
	}
	//DELETE
	public void delete(String NUM) { 
		Connection conn = OracleConnectUtil.connect();
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM Singer WHERE NUM=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, NUM);
			pstmt.execute();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("sql 실행오류 :" + e.getMessage());
		}
		OracleConnectUtil.close(conn);
	}

}
