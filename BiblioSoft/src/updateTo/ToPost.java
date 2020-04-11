/**
 * 
 */
package updateTo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import entity.Post;
import entity.BorrowedRecord;
import entity.Librarian;
import entity.Book;
import entity.Reader;
import entity.ReservedRecord;
import entity.Admin;
import utils.DBhelper;
/**
 * @author ����
 *
 */
public class ToPost {
	/*
	 * ���ĳ��������֪ͨ������
	 */
	public static int getTotalAuthor(String author) {
		int total = 0;
		try {

			Connection c = DBhelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select count(*) from post where author = "+"'"+author+"';";

			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				total = rs.getInt(1);
			}


			DBhelper.closeConnection(c, s, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}
	/*
	 * ��ȡ֪ͨ������
	 */
	public static int getTotal() {
		int total = 0;
		try {

			Connection c = DBhelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select count(*) from post";

			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				total = rs.getInt(1);
			}

			System.out.println("total:" + total);

			DBhelper.closeConnection(c, s, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}
	
	

	/*
	 * ���һ��֪ͨ
	 */
	/*
	 * �޸��ˣ������postImage��postTitle��������
	 */
	public static void add(Post post) {

		try {

			Connection c = DBhelper.getInstance().getConnection();

			String sql = "insert into post(author,time,text,postImage,postTitle) values(?,?,?,?,?)";
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, post.getAuthor());
			ps.setDate(2, post.getTime());
			ps.setString(3, post.getText());
			ps.setString(4, post.getPostImage());
			ps.setString(5, post.getPostTitle());
			
			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();

			DBhelper.closeConnection(c, ps, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * ����һ��֪ͨ
	 */
	/*
	 * �޸��ˣ������postImage��postTitle��������
	 */
	public static void update(Post post) {
		try {

			Connection c = DBhelper.getInstance().getConnection();

			String sql = "update post set author = ? , time = ? , text=? ,postImage = ?, postTitle = ? where postID = ?";
			
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setLong(6, post.getPostID());
			ps.setString(1, post.getAuthor());
			ps.setString(3,post.getText());
			ps.setDate(2, post.getTime());
			ps.setString(4,post.getPostImage());
			ps.setString(5,post.getPostTitle());

			ps.execute();

			DBhelper.closeConnection(c, ps, null);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/*
	 * ͨ��֪ͨ���ɾ��һ��֪ͨ
	 */
	public static void delete(String postID) {
		try {

			Connection c = DBhelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "delete from post where postID = " +"'"+postID+"';";

			s.execute(sql);

			DBhelper.closeConnection(c, s, null);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * ͨ����Ż�ȡ֪ͨ
	 */
	/*
	 * �޸��ˣ������postImage��postTitle��������
	 */
	public static Post getByPostID(String postID) {
		Post post = new Post();
		try {

			Connection c = DBhelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select * from post where postID = " + "'"+postID+"';";

			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {
				post.setPostID(rs.getLong("postID"));
				post.setAuthor(rs.getString("author"));
				post.setTime(rs.getDate("time"));
				post.setText(rs.getString("text"));
				post.setPostImage(rs.getString("postImage"));
				post.setPostTitle(rs.getString("postTitle"));
				
				
			}

			DBhelper.closeConnection(c, s, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return post;
	}
	/*
	 * �г�����֪ͨ
	 */
	public static List<Post> list() {
		return list(0, Short.MAX_VALUE);
	}
	/*
	 * �г�����֪ͨ
	 */
	/*
	 * �޸��ˣ������postImage��postTitle��������
	 */
	public static List<Post> list(int start, int count) {
		List<Post> posts = new ArrayList<Post>();

		try {

			Connection c = DBhelper.getInstance().getConnection();

			String sql = "select * from post order by postID desc limit ?,? ";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, count);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Post post = new Post();
				post.setPostID(rs.getLong("postID"));
				post.setAuthor(rs.getString("author"));
				post.setTime(rs.getDate("time"));
				post.setText(rs.getString("text"));
				post.setPostImage(rs.getString("postImage"));
				post.setPostTitle(rs.getString("postTitle"));
				
				posts.add(post);
			}
			DBhelper.closeConnection(c, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return posts;
	}
	/*
	 * �г�ĳ�˷�����֪ͨ
	 */
	/*
	 * �޸��ˣ������postImage��postTitle��������
	 */
	public static List<Post> list(int start, int count,String author) {
		List<Post> posts = new ArrayList<Post>();

		try {

			Connection c = DBhelper.getInstance().getConnection();

			String sql = "select * from post where author=? order by barCode desc limit ?,? ";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, author);
			ps.setInt(2, start);
			ps.setInt(3, count);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Post post = new Post();
				post.setPostID(rs.getLong("postID"));
				post.setAuthor(rs.getString("author"));
				post.setTime(rs.getDate("time"));
				post.setText(rs.getString("text"));
				posts.add(post);
			}
			DBhelper.closeConnection(c, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return posts;
	}

	
	
}
