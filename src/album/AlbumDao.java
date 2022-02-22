package album;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.OracleConnectUtil;


public class AlbumDao {

	private static AlbumDao albumDao = new AlbumDao();

	public AlbumDao() {	}
	
	public static AlbumDao getAlbumDao() {
		return albumDao;
	}
	
	// ==============================================================
	// insert 쿼리
	public void insert(Album vo) {
		Connection conn = OracleConnectUtil.connect();
		System.out.println("main 메소드 확인용 : " + conn);

		String sql = "INSERT INTO TEAMA.ALB(ALB_CODE, TEAM_NAME, ALB_NAME, SONG_CNT, T_SONG, S_DATE)" +
						"VALUES(?, ?, ?, ?, ?, ?)";

		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getAlb_code());
			pstmt.setString(2, vo.getTeam_name());
			pstmt.setString(3, vo.getAlb_name());
			pstmt.setInt(4, vo.getSong_cnt());
			pstmt.setString(5, vo.getT_song());
			pstmt.setDate(5, vo.getS_date());

			pstmt.execute();
			System.out.println("앨범정보가 등록되었습니다.");
			pstmt.close();

		} catch (SQLException e) {
			System.out.println("SQL 실행 오류 : " + e.getMessage());
		}

		OracleConnectUtil.close(conn);
	}
	
	// ==============================================================
	// select 쿼리
	// 모든 앨범 조회
	public static List<Album> selectAll() {
		Connection conn = OracleConnectUtil.connect();
		String sql = "select * from alb";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Album> albums = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				albums.add(new Album(rs.getString(1), 
								rs.getString(2), 
								rs.getString(3), 
								rs.getInt(4), 
								rs.getString(5), 
								rs.getDate(6)));
			}
			
		} catch (SQLException e) {
			System.out.println("SQL 실행 오류 : " + e.getMessage());
		}
		return albums;
	}
	
	// 팀별 앨범조회
	public static List<Album> selectTeamAlbum(String team_name) {
		Connection conn = OracleConnectUtil.connect();
		String sql = "select * from alb where team_name = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Album> albums = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, team_name);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				albums.add(new Album(rs.getString(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4), 
						rs.getString(5), 
						rs.getDate(6)));
			}
			
		} catch (SQLException e) {
			System.out.println("SQL 실행 오류 : " + e.getMessage());
		}
		return albums;
	}
	
	public static Album selectAlbum(String team_name, String alb_code) {
		Connection conn = OracleConnectUtil.connect();
		String sql = "select * from alb where team_name = ? and alb_code = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Album album = new Album();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, team_name);
			pstmt.setString(2, alb_code);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				album.setAlb_code(rs.getString(1));
				album.setTeam_name(rs.getString(2));
				album.setAlb_name(rs.getString(3));
				album.setSong_cnt(rs.getInt(4));
				album.setT_song(rs.getString(5));
				album.setS_date(rs.getDate(6));
			}
			
		} catch (SQLException e) {
			System.out.println("SQL 실행 오류 : " + e.getMessage());
		}
		return album;
	}
	
	// ==============================================================
	// update 쿼리
	public void update(Album vo) { 
		Connection conn = OracleConnectUtil.connect();
		PreparedStatement pstmt;
		String sql = "UPDATE TEAMA.ALB SET ALB_NAME=?" + 
						"WHERE ALB_CODE=?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getAlb_name());
			pstmt.setString(1, vo.getAlb_code());

			pstmt.execute();
			pstmt.close();
			System.out.println("앨범 이름이 변경되었습니다.");

		} catch (SQLException e) {
			System.out.println("SQL 실행오류 : " + e.getMessage());
		}

		OracleConnectUtil.close(conn);
	}
	// ==============================================================
	// delete 쿼리
	public void delete(String alb_code) {
		Connection conn = OracleConnectUtil.connect();
		PreparedStatement pstmt;
		String sql = "DELETE FROM TEAMA.ALB WHERE ALB_CODE=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, alb_code);

			pstmt.execute();
			pstmt.close();
			System.out.println("앨범 삭제가 완료되었습니다.");

		} catch (SQLException e) {
			System.out.println("SQL 실행오류 : " + e.getMessage());
		}

		OracleConnectUtil.close(conn);
	}
	
}
