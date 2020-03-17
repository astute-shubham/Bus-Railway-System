

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import code.DatabaseConnection;


@WebServlet("/Smodify")
public class Smodify extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try { 
			 Connection con = DatabaseConnection.initializeDatabase();
			 String busno=request.getParameter("BusNo");
			 String stop=request.getParameter("stop");
			 String fat=request.getParameter("FAT");
  			System.out.println(fat+"    "+stop+"    "+busno);

			 
			 
			 
			 PreparedStatement st = con.prepareStatement("insert into z"+busno+" values(?,?,?);");
			 
			 st.setString(1,stop);
			 st.setString(2,fat);
			 st.setString(3,fat);
			 
			 st.executeUpdate();
			 
			 con.close();
			 st.close();
	}
		catch (Exception e) { 
            e.printStackTrace(); 
        } 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
