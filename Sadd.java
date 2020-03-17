

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

import java.io.PrintWriter; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.Statement;

import code.DatabaseConnection;

@WebServlet("/Sadd")
public class Sadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try { 
			String busno=request.getParameter("busNo");
			String conid=request.getParameter("con");
			
           
            Connection con = DatabaseConnection.initializeDatabase(); 
            PreparedStatement st = con.prepareStatement("insert into busadmin values(?, ?, ?)"); 
            st.setString(1, "z"+busno); 
            st.setString(2, conid);
            st.setString(3, null);
            
            
            String busstop="create table z" + busno+ " (stop varchar(100),Arrival_time time,Expected_Arrival time);";
            
            Statement st1= con.createStatement();
            
            
            st.executeUpdate();
            st1.executeUpdate(busstop);
            
            st.close();
            st1.close();
            con.close(); 
            
            
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//}

}
