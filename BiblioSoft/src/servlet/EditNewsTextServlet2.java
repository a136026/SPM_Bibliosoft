
	package servlet;

	import java.io.IOException;
	import java.sql.Date;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import java.sql.Timestamp;
	import java.text.SimpleDateFormat;
	import java.util.List;

	import entity.Book;
	import entity.BorrowedRecord;
import entity.Librarian;
import entity.Post;
	import entity.Reader;
	import updateTo.ImgUtil;
	import updateTo.StringUtil;
	import updateTo.ToBook;
	import updateTo.ToBorrowedRecord;
	import updateTo.ToPost;
	import updateTo.ToReader;

	public class EditNewsTextServlet2 extends HttpServlet {
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			response.setContentType("text/html; charset=UTF-8");
			request.setCharacterEncoding("utf-8");
			Librarian librarian=(Librarian)(request.getSession().getAttribute("PERSON"));
			//System.out.print("===========================>Here :"+postID);
			long postID= 0;
			int start = 0;
			int id=0;
			String account=String.valueOf(librarian.getAccount());
			
			String barcode="";
			String text_content = "";
			String image_content = "";
			String word_content ="";
			String picturePath = "";
			System.out.println("===========================>Here :");
	
			try{
				text_content = request.getParameter("editorValue");//��ø��ı��༭������
				image_content = request.getParameter("postImage");//��ø��ı��༭������
				postID=Integer.parseInt(request.getParameter("postID"));

				word_content = request.getParameter("postTitle");//��ø��ı��༭������
				List list = ImgUtil.getImageSrc(request.getParameter("editorValue"));
//				List list = ImgUtil.getImageSrc(request.getParameter("MyPostTitle"));

			}catch(NumberFormatException e){

			}
			System.out.println("===========================>postID:"+postID);

			
			System.out.println("===========================>content is :"+text_content);

			
			Date date = new Date(System.currentTimeMillis());//��ͬ��java.util.Date

			
			Post post = new Post(postID,account,date,text_content,image_content,word_content);
			
			System.out.println("postis"+post.toString());
			ToPost.update(post);
			request.setAttribute("post", post);
			
			
			

			int count = 1;
			//
//					try {
//						start = Integer.parseInt(request.getParameter("start"));
//					} catch (NumberFormatException e) {
//						// �������û�д�����startʱ
//					}
					
					request.getRequestDispatcher("LibrarianFirstPage").forward(request, response);

					return;
//			if(reader.getEmail()==null){
//				request.setAttribute("ifAccountExists",0);		
//				request.getRequestDispatcher("LibrarianBorrowBook4.jsp").forward(request, response);
//				return;
//			}
					
//			Book book = new ToBook().getByBarCode(barcode);
//			System.out.print(book.toString());
	//
//			if(book.getBarCode() == null){//�жϸ����Ƿ����
//				request.setAttribute("ifExist", 0);
//				System.out.println("���鲻����");
//				request.getRequestDispatcher("LibrarianBorrowBook.jsp").forward(request, response);
//				return;
//			}
//			System.out.print(book.toString());
//			System.out.print('\n');
//			Date date1 = new Date(System.currentTimeMillis());//��ͬ��java.util.Date
//			
////			Date date2 = new Date(System.currentTimeMillis());//��ͬ��java.util.Date
////			
////			Calendar calendar = Calendar.getInstance();
////			calendar.setTime(date2);		
////			calendar.add(Calendar.DAY_OF_MONTH, +30);
	////
////			date2 = new java.sql.Date(calendar.getTime().getTime());
////			
//			
//			String bookName = book.getBookName();
//			System.out.print("======================================================================>");
//			System.out.print(bookName);
//			int ifBorrow = 0;
//			
//			/*
//			 * �涨ÿ��ֻ�ܽ�һ�� 
//			 * ����ͨ��Reader.account �� Book.barCode ʵ��
//			 */
//			request.setAttribute("borrowBook", book);
	//
//			if(reader.getBorrowedNum()<10){//�ж��û��Ƿ��ܹ�����
//				if(book.getStatus() == 0){//�жϸ����Ƿ�ԤԼ���߽��
//					BorrowedRecord record = new BorrowedRecord(barcode,bookName,account,date1,null,0.0);
//					//bRID���������������а�������д����Ҹ��˾������ݿ�ͦ�Եģ���֪������ôд��������ôд��
//					System.out.print("======================================================================>");
//					System.out.print(record.toString());
//					new ToBorrowedRecord().add(record);
//					new ToBook().setStatus(barcode, 2);
//					request.getRequestDispatcher("LibrarianBorrowBook3.jsp").forward(request, response);
//					System.out.print("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++>");
//					return;
//				}
	//
//				else{
//					System.out.println("�����ѱ�ԤԼ���߽���������д���");
//				}
//			}
//			else{
//				System.out.println("�û����鳬�����ޣ������д���");
//			}
//			request.getRequestDispatcher("LibrarianBorrowBook4.jsp").forward(request, response);
		}
		
	}
