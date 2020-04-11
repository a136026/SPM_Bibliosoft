package servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import entity.Librarian;
import updateTo.ToLibrarian;
import entity.Admin;
import updateTo.ToAdmin;

public class Admin1 extends HttpServlet{

	
	private ToLibrarian tolbr = new ToLibrarian();
	private ToAdmin toad = new ToAdmin();
	private Admin ad;
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		System.out.println(request.getParameter("modifiedaccount"));
		System.out.println("----" + request.getParameter("modifiedpassword"));
		
		//�޸Ĺ�����Ա����
		try{
			Long account = Long.parseLong(request.getParameter("modifiedaccount"));
			if(account != null){
				String password = request.getParameter("modifiedpassword");
				if(password.length()>20){
					JOptionPane.showMessageDialog(null,"Your input is too long!");
				} else {
					Librarian lbr = new Librarian(account, password, 1);
					tolbr.update(lbr);
				}
			}
		} catch (NumberFormatException e){
			
		}
		
		//ɾ��������Ա�˺�
		try{
			String account = request.getParameter("deleteaccount");
			if(account != null){
				tolbr.delete(account);
			}
		} catch (NumberFormatException e){
			
		}
		
		//�޸�Ѻ������
		try{
			String c = request.getParameter("cash");
			if(c != null){
				double cash = Double.parseDouble(c);
				toad.updateFine(cash);
			}
		} catch (NumberFormatException e) {
			
		}

		//����һ��������Ա
		try {
			long account = Long.parseLong(request.getParameter("account"));
			String password = request.getParameter("password");
			String repeatPassword = request.getParameter("repeatpassword");
			Librarian lbr = new Librarian(account, password, 0);
			tolbr.add(lbr);
		} catch (NumberFormatException e) {
			
		}

		//չʾ������Ա�б�
		List<Librarian> lbrs = tolbr.list();
		request.setAttribute("librarians", lbrs);
		
		//��ʾ�������
		try{
			String searchAccount = request.getParameter("searchLibrarian");
			if(searchAccount != null){
				lbrs.clear();
				Librarian temp = tolbr.get(searchAccount);
				if(temp != null){
					lbrs.add(temp);
				}
			}
		} catch (NumberFormatException e) {
			
		}
		
		ad = toad.list().get(0);
		
		//��ʾ��ǰ��������Ŀ
		request.setAttribute("borrowedMaxinum", ad.getBorrowedMaxinum());
		
		//��ʾ������������ÿ�췣����Ǯ
		request.setAttribute("fine", ad.getFine());
		
		//��ʾ����������
		request.setAttribute("fineTime", ad.getFineTime());
		
		//��ʾѺ������
		request.setAttribute("cash", ad.getCash());
		
		//��ʾ��ǰԤԼʱ��
		request.setAttribute("reservedtime", ad.getResercedTime());
		
		//��ʾ���ԤԼ��Ŀ
		request.setAttribute("reservedmaxinum", ad.getReservedMaxinum());
		
		request.getRequestDispatcher("Admin1.jsp").forward(request, response);
	}

}
