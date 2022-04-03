package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.util.DBConnection;

/**
 * Servlet implementation class ListProductServlet
 */
@WebServlet("/listProducts")
public class ListProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		DBConnection dbConnection = new DBConnection();
		Connection con = dbConnection.getConnection();
		
		// STEP 3: Create Statement Object
		
		try {
			Statement stmt = con.createStatement();
			
			// STEP 4: Execute query and gets resultset object
			ResultSet rs = stmt.executeQuery("select * from eproduct");
			
			while(rs.next()) {
				out.println(rs.getInt("ID") + " "+ rs.getString("name")+" "+rs.getDate("date_added")+"<br>" );
			}
			
			stmt.close();
			dbConnection.closeConnection();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
