

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import code.DatabaseConnection;


@WebServlet("/Sdelete")
public class Sdelete extends HttpServlet {
	

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try { 
			String busno=request.getParameter("busNo");
			
           
            Connection con = DatabaseConnection.initializeDatabase(); 
            String drop="drop table z"+busno+";";
            String delete="delete from busadmin where bus_no = 'z"+busno+"' ;";
            Statement st= con.createStatement();
            //Statement st1= con.createStatement();
            
            st.executeUpdate(drop);
            st.executeUpdate(delete);
            
            st.close();
            //st1.close();
            con.close(); 
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
