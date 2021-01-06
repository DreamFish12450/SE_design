package ws.parkingLotService.servlet;

import main.com.wswenyue.db.dao.impl.UserDaoImpl;
import main.com.wswenyue.db.domain.UserW;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "inforegisteServlet")
public class inforegisteServlet extends HttpServlet {
        public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

            request.setCharacterEncoding("utf-8");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String name = request.getParameter("name");
            String age = request.getParameter("age");
            Integer age1 = Integer.parseInt(age);
            String sex = request.getParameter("radio1");
            String ID_number = request.getParameter("ID_number");
            String phone_number = request.getParameter("phone_number");

            // System.out.println(ID_number+" "+phone_number);
            String sex1;
            System.out.println("进入：123");
            // UserW u2=new UserW("1","2","3",4,"男","30","133",null,null,null);
            //  System.out.println("进入：1234568");
            if (sex.equals("true")) sex1 = "男";
            else sex1 = "女";
            UserW u1 = new UserW();
            //    System.out.println("进入：123456");

            u1.setID_number(ID_number);
            System.out.println("进入：123456");
            u1.setName(name);
            u1.setPhone_number(phone_number);
            u1.setUsername(username);
            u1.setSex(sex1);
            u1.setPassword(password);
            u1.setAge(age1);
            UserDaoImpl ud = new UserDaoImpl();
            System.out.println("进入：123458");
            try {
                UserW u2 = ud.findUserByName(username);
//                System.out.println();
                if(u2==null) {
                    ud.add(u1);
                    System.out.println("添加成功：123");
                    request.getRequestDispatcher("/home.jsp").forward(request, response);
                       }
                else
                {   System.out.println("添加失败：123");
                    request.setAttribute("error","该用户名已注册，请重新填写");
                    request.getRequestDispatcher("/home.jsp").forward(request, response);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
}
