package servlet;
import java.io.IOException;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import entity.*;
import updateTo.*;

import java.util.*;
import java.lang.String;

public class Login  extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		

		List<Reader>readers=ToReader.list(0, ToReader.getTotal());
		for(int i = 0;i < readers.size();i++){
			Reader temp = readers.get(i);
			List<BorrowedRecord> records = ToBorrowedRecord.getListByAccount(temp.getAccount());
			double sum;
			double temsum;
			sum = 0;
			for(int j = 0;j < records.size();j++){
				Date endDate = records.get(j).getBorrowedDate();
				Date nowDate = new Date(System.currentTimeMillis());
				temsum=(nowDate.getTime()-endDate.getTime())/(24*60*60*1000);	
				temsum = temsum - 30;
				if(temsum < 0)
					sum = sum + 0;
				else
					sum = sum + temsum*ToAdmin.list().get(0).getFine();
			}
	
			temp.setFine(sum);
			ToReader.update(temp);
		}
		String authority=String.valueOf(request.getSession().getAttribute("AUTHORITY"));
		System.out.println("type is :"+authority);
		String account="";
		String pd="";
		String url="";
		try{
			account = request.getParameter("useraccount");
			pd = request.getParameter("userpassword");

		}catch(NumberFormatException e){
			
		}
		
		
		/*
		 * 
		 */

		if(authority.equals("Admin")){
			Admin admin=ToAdmin.getByAccount(account);

			if(admin.getAccount()!=0&&admin.getPassword().equals(pd))
			{
				request.getSession().setAttribute("PERSON", admin);
				url="admin1";
			}
			else{
				System.out.println("�������");
				url="Login.jsp?mima=no";
			}
			
		}
		else if(authority.equals("Librarian"))
		{
			System.out.println("===============1");
			Librarian librarian=ToLibrarian.get2(account);
			System.out.println(librarian.toString());
			System.out.println("===============2");
			if(librarian.getAccount()==0)
			{
				url="Login.jsp?mima=no";
			}
			else if(librarian.getPassword().equals(pd))
			{
				request.getSession().setAttribute("PERSON", librarian);
				request.setAttribute("Librarian", librarian);
				System.out.println(librarian.toString());
				if(librarian.getAnswer() == null||librarian.getAnswer().equals("")){
					request.setAttribute("account", librarian.getAccount());
					url="SecurityQuestion.jsp";
				}
				else{
					url="LibrarianFirstPage.jsp";
				}
				
			}
			else{
				System.out.println("�������");
				url="Login.jsp?mima=no";
			}
		}
		else if(authority.equals("Reader"))
		{
			Reader reader=ToReader.getByAccount(account);
			if(reader.getPassword().equals(pd))
			{
				request.getSession().setAttribute("PERSON", reader);
				url="/getreader";
			}
			else{
				System.out.println("�������");
				url="Login.jsp?mima=no";
			}
		}
		//��ɾ
//		Properties prop = new Properties();
//        prop.put("mail.host","smtp.163.com" );
//		prop.put("mail.transport.protocol", "smtp");
//		prop.put("mail.smtp.auth", true);
//		try{
//			int start = 0;
//			int count = 0;
//			int i = 0;
//			int size = 0;
//			count=ToBorrowedRecord.getTotal();
//			System.out.println("diao total="+count);
//			List<BorrowedRecord> borrowedRecord = ToBorrowedRecord.listByDiao(start, count);
//			List<BorrowedRecord> nowrecord = new ArrayList<BorrowedRecord>();
//			size=borrowedRecord.size();
//			System.out.println("diao size bor="+size);
//			while(i < size) {//�ڲ������� ִ��Ч�ʸ� �������������
//			    if(borrowedRecord.get(i).getBorrowedDate().after(borrowedRecord.get(i).getReturnedDate())){
//			    	nowrecord.add(borrowedRecord.get(i));			    	
//			    }
//			    i++;
//			}
//			i = 0;
//			size = nowrecord.size();
//
//			int day = ToAdmin.getByAccount("1").getFineTime();
//			int temday = 0;
//			while(i < size){
//				Date nowdate = new Date(System.currentTimeMillis());
//				Date begindate = nowrecord.get(i).getBorrowedDate();
//				temday = (int)( (nowdate.getTime() - begindate.getTime())/(3600*24*1000));
//				System.out.println("temday="+temday);
//				if(temday == day){
//					try{
//						 //ʹ��JavaMail�����ʼ���5������
//				        //1������session
//				        Session session = Session.getInstance(prop);
//				        //����Session��debugģʽ�������Ϳ��Բ鿴��������Email������״̬
//				        session.setDebug(true);
//				        //2��ͨ��session�õ�transport����
//				        Transport ts = session.getTransport();
//				        System.out.println("163163163163163163");
//				        //3��ʹ��������û��������������ʼ��������������ʼ�ʱ����������Ҫ�ύ������û����������smtp���������û��������붼ͨ����֤֮����ܹ����������ʼ����ռ��ˡ�
//				        ts.connect("wangleksdjh", "diao123456");
//				        //4�������ʼ�
//				        StringBuffer str = new StringBuffer();
//				        String st="";
//				        str.append("<h1>");
//				        st="Dear reader, hello. The books you borrowed will expire soon, please return them in time. Thank you for your cooperation.";
//				        str.append(st+"</h1>");
//				        Message message = SendEmail.createSimpleMail(session,ToReader.getByAccount(nowrecord.get(i).getReaderAccount()).getEmail(),str);
//				        //5�������ʼ�
//				        ts.sendMessage(message, message.getAllRecipients());
//				        ts.close();
//					}catch(Exception e){
//						
//					}
//				}
//				if(temday > day){
//					try{
//						 //ʹ��JavaMail�����ʼ���5������
//				        //1������session
//				        Session session = Session.getInstance(prop);
//				        //����Session��debugģʽ�������Ϳ��Բ鿴��������Email������״̬
//				        session.setDebug(true);
//				        //2��ͨ��session�õ�transport����
//				        Transport ts = session.getTransport();
//				        System.out.println("163163163163163163");
//				        //3��ʹ��������û��������������ʼ��������������ʼ�ʱ����������Ҫ�ύ������û����������smtp���������û��������붼ͨ����֤֮����ܹ����������ʼ����ռ��ˡ�
//				        ts.connect("wangleksdjh", "diao123456");
//				        //4�������ʼ�
//				        StringBuffer str = new StringBuffer();
//				        String st="";
//				        str.append("<h1>");	        
//				        st="Dear reader, hello. The books you borrowed have been overdue, please return them in time to avoid any fine.";
//				        str.append(st+"</h1>");
//				        Message message = SendEmail.createSimpleMail(session,ToReader.getByAccount(nowrecord.get(i).getReaderAccount()).getEmail(),str);
//				        //5�������ʼ�
//				        ts.sendMessage(message, message.getAllRecipients());
//				        ts.close();
//					}catch(Exception e){
//						
//					}
//				}				
//				i++;
//			}			
//		}
//		catch(Exception e){
//			System.out.println("Send Email error" + e.getMessage());
//		}
		//��ɾ
		
		
		request.getRequestDispatcher(url).forward(request, response);
	}
}
