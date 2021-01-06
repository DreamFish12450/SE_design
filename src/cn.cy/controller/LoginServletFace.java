package cn.cy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import cn.cy.domain.Image;
import cn.cy.domain.Result;
import cn.cy.service.FaceSearch;
import cn.cy.service.imp.FaceSearchImp;

/**
 * Servlet implementation class LoginServletFace
 */
@WebServlet("/user/login")
public class LoginServletFace extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FaceSearch faceSearch = new FaceSearchImp();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "*");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type, x-requested-with, X-Custom-Header, HaiYi-Access-Token");
		
        String imgStr=request.getParameter("imgStr");
        String imgType=request.getParameter("imgType");
        Image image = new Image();
        image.setImgStr(imgStr);
        image.setImgType(imgType);
        Result result = faceSearch.faceLogin(image);
        JSONObject json = new JSONObject(result.toString());
        System.out.println(json.get("start"));
        if(result.isStart()) {
        	System.out.println("璇嗗埆鎴愬姛");
        	//杩欓噷鏈夊鐢熺殑瀛﹀彿,鍙互鍦ㄨ繖閲屽疄鐜版煡璇㈠鐢熺殑淇℃伅  璺宠浆椤甸潰绛夋搷浣�
        	//result.getUserId();
        }else {
        	System.out.println("澶辫触"+result.getErrorMsg());
        	//杩欓噷澶勭悊浜鸿劯澶辫触鐨勯�昏緫
        }
        
        response.getWriter().print(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
