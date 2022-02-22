package ggroup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.OracleConnectUtil;

public class G_GroupDao {

	private static G_GroupDao GDao = new G_GroupDao();
	private G_GroupDao() {   }
	public static G_GroupDao getG_GroupDao() {
		return GDao;
	}
	
	//selectAll
	public List<G_Group> selectAll() {
		Connection conn = OracleConnectUtil.connect();
		String sql = "SELECT * FROM G_GROUP";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<G_Group> group = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				group.add(new G_Group(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7)));
			}
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("SQL 실행 오류:" + e.getMessage());
		}
		OracleConnectUtil.close(conn);
		return group;
	}
	
	//selectOne
	public static G_Group selectOne(String team_name) {
		Connection conn = OracleConnectUtil.connect();
		String sql = "SELECT * FROM G_GROUP WHERE TEAM_NAME=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		G_Group vo = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, team_name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new G_Group();
				vo.setEnt_code(rs.getInt(1));
				vo.setTeam_name(rs.getString(2));
				vo.setMember_cnt(rs.getInt(3));
				vo.setD_song(rs.getString(4));
				vo.setD_date(rs.getDate(5));
				vo.setF_name(rs.getString(6));
				vo.setLeader(rs.getString(7));
			}
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("SQL 실행 오류:" + e.getMessage());
		}
		OracleConnectUtil.close(conn);
		return vo;
	}
	
	//INSERT
	public void insert(G_Group vo) {
		Connection conn = OracleConnectUtil.connect();
		String sql = "INSERT INTO G_GROUP" + "(ENT_CODE, TEAM_NAME, MEMBER_CNT, D_SONG, D_DATE, F_NAME, LEADER)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getEnt_code());
			pstmt.setString(2, vo.getTeam_name());
			pstmt.setInt(3, vo.getMember_cnt());
			pstmt.setString(4, vo.getD_song());
			pstmt.setDate(5, vo.getD_date());
			pstmt.setString(6, vo.getF_name());
			pstmt.setString(7, vo.getLeader());
			pstmt.execute();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("sql 실행 오류" + e.getMessage());
		}
		OracleConnectUtil.close(conn);
	}
	//UPDATE
	public void update(G_Group vo) { 
		Connection conn = OracleConnectUtil.connect();
		PreparedStatement pstmt = null;
		String sql = "UPDATE G_GROUP SET MEMBER_CNT=? WHERE TEAM_NAME = ?";
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, vo.getMember_cnt()); // 방법2
			pstmt.setString(2, vo.getTeam_name()); // 방법2
			pstmt.execute();
			pstmt.close();

		} catch (SQLException e) {
			System.out.println("sql 실행오류 :" + e.getMessage());
		}
	}
	//DELETE
	public void delete(String Team_name) { 
		Connection conn = OracleConnectUtil.connect();
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM G_GROUP WHERE TEAM_NAME=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Team_name);
			pstmt.execute();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("sql 실행오류 :" + e.getMessage());
		}
		OracleConnectUtil.close(conn);
	}
	
	
	
	
	
	
	
	
	
	
}
