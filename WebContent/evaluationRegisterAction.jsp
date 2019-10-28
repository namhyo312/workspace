<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="evaluation.EvaluationDTO"%>
<%@ page import="evaluation.EvaluationDAO"%>
<%@ page import="java.io.PrintWriter"%>
<%

	request.setCharacterEncoding("UTF-8");
	/* String userID = null;
	if(session.getAttribute("userID") != null) {
		userID = (String) session.getAttribute("userID");
	}

	if(userID == null) {

		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('로그인을 해주세요.');");
		script.println("location.href = 'userLogin.jsp'");
		script.println("</script>");
		script.close();
	} */

	request.setCharacterEncoding("UTF-8");
	String userID="aa";
	String taskName = null;
	String leaderName = null;
	String startDate = null;
	String endDate = null;
	int annual = 0;
    String evaluationBehavior = null;
    String performanceReview = null;
	String evaluationContent = null;
	String totalScore=null;
	String operationRatio="가동률";
    int total=0;
	if(request.getParameter("taskName") != null) {
		taskName = (String) request.getParameter("taskName");
	}

	if(request.getParameter("leaderName") != null) {
		leaderName = (String) request.getParameter("leaderName");
	}

 if(request.getParameter("annual") != null) {
		try {
			annual = Integer.parseInt(request.getParameter("annual"));
		} catch (Exception e) {
			System.out.println("연차 데이터 오류");
		}
	}
 
 
 if(request.getParameter("startDate") != null) {
		startDate = (String) request.getParameter("startDate");
	}
 if(request.getParameter("endDate") != null) {
		endDate = (String) request.getParameter("endDate");
	}
	if(request.getParameter("evaluationBehavior") != null) {
		evaluationBehavior = (String) request.getParameter("evaluationBehavior");
	}

	if(request.getParameter("performanceReview") != null) {
		performanceReview = (String) request.getParameter("performanceReview");
	}

	if(request.getParameter("evaluationContent") != null) {
		evaluationContent = (String) request.getParameter("evaluationContent");
	}

	if(request.getParameter("totalScore") == null) {
		total = (Integer.parseInt(performanceReview)+Integer.parseInt(evaluationBehavior)/2);
	    if(total>8){
	    	totalScore="A";
	    }else if(total>6){
	    	totalScore="B";
	    }else if(total>4){
	    	totalScore="C";
	    }else if(total>2){
	    	totalScore="D";
	    }else{
	    	totalScore="E";
	    }
	    
	}

	if (taskName == null || leaderName == null || startDate == null || endDate == null || evaluationBehavior == null || performanceReview == null || evaluationContent.equals("")) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('입력이 안 된 사항이 있습니다.');");
		script.println("history.back();");
		script.println("</script>");
		script.close();

	} else {
		EvaluationDAO evaluationDAO = new EvaluationDAO();
		System.out.println("total "+totalScore);
		System.out.print(" 아이디"+userID+" 업무"+taskName+" 리더"+leaderName+" 시작"+startDate+" 종료"+endDate+" 연차"+annual+" 가동률"+operationRatio+" 행동평가"+evaluationBehavior+" 업무평가"+performanceReview+" 토탈"+totalScore+" 콘텐츠"+evaluationContent);
		int result = evaluationDAO.write(new EvaluationDTO(0, userID, taskName, leaderName, startDate, endDate, annual , operationRatio, evaluationBehavior, performanceReview, totalScore, evaluationContent));
		if (result == -1) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('평가 등록에 실패했습니다.');");
			script.println("history.back();");
			script.println("</script>");
			script.close();
	
		} else {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href = './index.jsp';");
			script.println("</script>");
			script.close();
		}
	}
%>

