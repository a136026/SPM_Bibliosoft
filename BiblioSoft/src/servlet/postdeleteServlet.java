package servlet;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import updateTo.ToBook;
import updateTo.ToPost;
import utils.DBhelper;
import entity.Book;
import entity.Librarian;
import entity.Post;
/**
 * Servlet implementation class RegisterServlet
 */
public class postdeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public postdeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
 
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");	
		request.setCharacterEncoding("utf-8"); 
		int k=0;
		
	
		
        String postID=request.getParameter("postID");
        
       ToPost.delete(postID);
       /* ToBook.update1(book);*/
        
        //ToBook.deleteByBarCode(barCode);
        k=k+1;
        if(k>0)
        {
        	response.sendRedirect("postList?tishi=yes");
        	
        }
        else
        {   
        	response.sendRedirect("postList?error=no");
        	
        }
    

	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		HttpServletRequest rq = (HttpServletRequest) request;
		HttpServletResponse rs = (HttpServletResponse) response;
		doPost(rq, rs);
	}
 
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
 
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}
 
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}
 
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
 
}

