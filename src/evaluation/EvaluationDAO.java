package evaluation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DatabaseUtil;

public class EvaluationDAO {

	public int write(EvaluationDTO evaluationDTO) {
		String SQL = "INSERT evaluation (evaluationID,userID,taskName,leaderName,startDate,endDate,annual,operationRatio,evaluationBehavior, performanceReview, totalScore,evaluationContent) VALUES (null, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		try {
			 conn=DatabaseUtil.getConnection();
			 pstmt=conn.prepareStatement(SQL);
			
			pstmt.setString(1, evaluationDTO.getUserID());
			pstmt.setString(2, evaluationDTO.getTaskName() );
			pstmt.setString(3, evaluationDTO.getLeaderName());
			pstmt.setString(4, evaluationDTO.getStartDate());
			pstmt.setString(5, evaluationDTO.getEndDate());
			pstmt.setInt(6, evaluationDTO.getAnnual());
			pstmt.setString(7, evaluationDTO.getOperationRatio());
			pstmt.setString(8, evaluationDTO.getEvaluationBehavior());
			pstmt.setString(9, evaluationDTO.getPerformanceReview());
			pstmt.setString(10, evaluationDTO.getTotalScore());
			pstmt.setString(11, evaluationDTO.getEvaluationContent());
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
