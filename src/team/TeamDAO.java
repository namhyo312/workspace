package team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import team.TeamDTO;
import util.DatabaseUtil;

public class TeamDAO {
	private Connection conn=null;
	private PreparedStatement pstmt = null;
	private ResultSet rs=null;
	
	public int write(TeamDTO teamDTO) {
		String SQL = "INSERT into team VALUES (null, ?, ?, ?, ? ,false);";
		
		
		try {
			 conn=DatabaseUtil.getConnection();
			 pstmt=conn.prepareStatement(SQL);
			
			pstmt.setString(1, teamDTO.getTeamName());
			pstmt.setString(2, teamDTO.getUserName());
			pstmt.setString(3, teamDTO.getUserEmail());
			pstmt.setString(4, teamDTO.getUserEmailHash());
			return pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return -1;
	}
	
	
	public String getUserEmail(String userName) {
		String SQL = "SELECT userEmail FROM team WHERE userName = ?";
		try {
			 conn=DatabaseUtil.getConnection();
			 pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				return rs.getString(1); // 이메일 주소 반환
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; // 데이터베이스 오류
	}

	

	public boolean getUserEmailChecked(String userName) {
		String SQL = "SELECT userEmailChecked FROM team WHERE userName = ?";
		try {
			 conn=DatabaseUtil.getConnection();
			 pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				return rs.getBoolean(1); // 이메일 등록 여부 반환
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 데이터베이스 오류
	}

	public boolean setUserEmailChecked(String userName) {
		String SQL = "UPDATE TEAM SET userEmailChecked = true WHERE userName = ?";
		try {
			 conn=DatabaseUtil.getConnection();
			 pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userName);
			pstmt.executeUpdate();
			return true; // 이메일 등록 설정 성공
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 이메일 등록 설정 실패
	}
	
	
	public ArrayList<TeamDTO> getList(){ 
		String SQL = "SELECT * FROM team order by teamID desc";
		ArrayList<TeamDTO> list = new ArrayList<TeamDTO>();
		try {
			conn=DatabaseUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				TeamDTO team = new TeamDTO();
				team.setTeamID(rs.getInt(1));
				team.setTeamName(rs.getString(2));
				team.setUserName(rs.getString(3));
				team.setEmployee(rs.getString(4));
				team.setUserEmail(rs.getString(5));
				list.add(team);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list; 
	}
	
	
}
