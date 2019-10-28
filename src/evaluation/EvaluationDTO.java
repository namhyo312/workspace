package evaluation;

public class EvaluationDTO {

	int evaluationID;
	String userID;
	String taskName;
	String leaderName;
	String startDate;
	String endDate;
	int annual;
	String operationRatio;
	String evaluationBehavior;
	String performanceReview;
	String evaluationContent;
	String totalScore;
	
	public int getEvaluationID() {
		return evaluationID;
	}
	public void setEvaluationID(int evaluationID) {
		this.evaluationID = evaluationID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getLeaderName() {
		return leaderName;
	}
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getAnnual() {
		return annual;
	}
	public void setAnnual(int annual) {
		this.annual = annual;
	}
	public String getOperationRatio() {
		return operationRatio;
	}
	public void setOperationRatio(String operationRatio) {
		this.operationRatio = operationRatio;
	}
	public String getEvaluationBehavior() {
		return evaluationBehavior;
	}
	public void setEvaluationBehavior(String evaluationBehavior) {
		this.evaluationBehavior = evaluationBehavior;
	}
	public String getPerformanceReview() {
		return performanceReview;
	}
	public void setPerformanceReview(String performanceReview) {
		this.performanceReview = performanceReview;
	}
	public String getEvaluationContent() {
		return evaluationContent;
	}
	public void setEvaluationContent(String evaluationContent) {
		this.evaluationContent = evaluationContent;
	}
	public String getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(String totalScore) {
		this.totalScore = totalScore;
	}
	public EvaluationDTO() {
		
	}
	public EvaluationDTO(int evaluationID, String userID, String taskName, String leaderName, String startDate,
			String endDate, int annual, String operationRatio, String evaluationBehavior, String performanceReview,
			String totalScore, String evaluationContent) {
		super();
		this.evaluationID = evaluationID;
		this.userID = userID;
		this.taskName = taskName;
		this.leaderName = leaderName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.annual = annual;
		this.operationRatio = operationRatio;
		this.evaluationBehavior = evaluationBehavior;
		this.performanceReview = performanceReview;
		this.totalScore = totalScore;
		this.evaluationContent = evaluationContent;
		
	}
	
	
	
}