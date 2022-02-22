package ent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.OracleConnectUtil;

public class EntDao {
	
	private static EntDao entDao = new EntDao();
	
	public EntDao() {	}
	
	public static EntDao getEntDao() {
		return entDao;
	}
	
	// ===========================================================
	// insert
	public void insert(Ent vo) {
		Connection conn = OracleConnectUtil.connect();
		System.out.println("main 메소드 확인용 : " + conn);
		
		String sql = "INSERT INTO TEAMA.ENT (ENT_CODE, ENT_NAME, TEL, CEO, ADDRESS, F_DATE)\r\n" + 
						"VALUES(?, ?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getEnt_code());
			pstmt.setString(2, vo.getEnt_name());
			pstmt.setString(3, vo.getTel());
			pstmt.setString(4, vo.getCeo());
			pstmt.setString(5, vo.getAddress());
			pstmt.setDate(6, vo.getF_date());
			
			pstmt.execute("기업정보가 등록되었습니다.");
			pstmt.close();
			System.out.println("");
		} catch (SQLException e) {
			System.out.println("SQL 실행 오류 : " + e.getMessage());
		}
		OracleConnectUtil.close(conn);
	}
	
	// ===========================================================
	// select
	// 모든 기업 조회
	public static List<Ent> selectAll() {
		Connection conn = OracleConnectUtil.connect();
		String sql = "SELECT * FROM ENT";
		PreparedStatement pstmt;
		ResultSet rs;
		List<Ent> ents = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ents.add(new Ent(rs.getInt(1), 
								rs.getString(2), 
								rs.getString(3), 
								rs.getString(4), 
								rs.getString(5), 
								rs.getDate(6)));
			}
			
		} catch (SQLException e) {
			System.out.println("SQL 실행 오류 : " + e.getMessage());
		}
		return ents;
	}
	
	// 기업 이름별 조회
	public static List<Ent> selectTeamName(String ent_name) {
		Connection conn = OracleConnectUtil.connect();
		String sql = "select * from alb where ent_name = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Ent> ents = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ent_name);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ents.add(new Ent(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getDate(6)));
			}
			
		} catch (SQLException e) {
			System.out.println("SQL 실행 오류 : " + e.getMessage());
		}
		return ents;
	}
	
	public static String selectTeamCode(String ent_name) {
		Connection conn = OracleConnectUtil.connect();
		String sql = "select ent_name from alb where ent_name = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String ents = "";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ent_name);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ents = rs.getString(1);
			}
			
		} catch (SQLException e) {
			System.out.println("SQL 실행 오류 : " + e.getMessage());
		}
		return ents;
	}
	// ===========================================================
	// update
	public void update(Ent vo) { 
		Connection conn = OracleConnectUtil.connect();
		PreparedStatement pstmt;
		String sql = "UPDATE TEAMA.ENT SET ADDRESS=?" + 
						"WHERE ENT_NAME=?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getAddress());
			pstmt.setString(1, vo.getEnt_name());

			pstmt.execute();
			pstmt.close();
			System.out.println("회사주소가 변경되었습니다.");

		} catch (SQLException e) {
			System.out.println("SQL 실행오류 : " + e.getMessage());
		}

		OracleConnectUtil.close(conn);
	}
	
	// ===========================================================
	// delete
	public void delete(String ent_code) {
		Connection conn = OracleConnectUtil.connect();
		PreparedStatement pstmt;
		String sql = "DELETE FROM TEAMA.ENT WHERE ENT_CODE=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ent_code);

			pstmt.execute();
			pstmt.close();
			System.out.println("기업 삭제가 완료되었습니다.");

		} catch (SQLException e) {
			System.out.println("SQL 실행오류 : " + e.getMessage());
		}

		OracleConnectUtil.close(conn);
	}
}
