package ws.parkingLotService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/parkingSpaceColorDao")
public class parkingSpaceColorDao extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        //利用DAO获取到车位状态字段 返回值为1 或 0；
		//根据dao返回值设置html页面中相应的矩形的颜色
		Staff s=new Staff();   /*获取存在request中员工的基本信息，并建立员工对象*/
		s.setJobNum(request.getParameter("jobNum"));
		s.setName(request.getParameter("names"));
		s.setSex(request.getParameter("sex"));
		String age=request.getParameter("age");
		if(age!=null&&age.length()>0)
			s.setAge(Integer.parseInt(age));
		s.setId(request.getParameter("idNum"));
		s.setDepart(request.getParameter("depart"));
		Users u=(Users)request.getSession().getAttribute("user");  /*获取当前会话中的User使用者，判断其是否有查询的权限*/
		List<Staff> list=null;
		if(s.getJobNum()!=null&&s.getJobNum().length()>0){   /*通过工号来查询员工信息*/
			Staff ss=new FindStaffDao().findStaffByJobNum(s.getJobNum(), u);
			if(ss==null){
				request.setAttribute("msg", "未找到结果！");
				request.getRequestDispatcher("showMessage.jsp").forward(request, response);
			}else{
				list=new ArrayList<Staff>();
				list.add(ss);
				request.setAttribute("list", list);
				request.getRequestDispatcher("showStaff.jsp").forward(request, response);
			}
		}else if(s.getId()!=null&&s.getId().length()>0){  /*通过身份证号查询员工信息*/
			Staff ss=new FindStaffDao().findStaffByIdNum(s.getId(), u);
			if(ss==null){
				request.setAttribute("msg", "未找到结果！");
				request.getRequestDispatcher("showMessage.jsp").forward(request, response);
			}else{
				list=new ArrayList<Staff>();
				list.add(ss);
				request.setAttribute("list", list);
				request.getRequestDispatcher("showStaff.jsp").forward(request, response);
			}
		}else{                                          /*找出所有数据库中员工信息*/
			list=new FindStaffDao().findStaffs(s, u);
			if(list.size()<=0){
				request.setAttribute("msg", "未找到结果！");
				request.getRequestDispatcher("showMessage.jsp").forward(request, response);
			}else{
				request.setAttribute("list", list);
				request.getRequestDispatcher("showStaff.jsp").forward(request, response);
			}
		}
	}

}
