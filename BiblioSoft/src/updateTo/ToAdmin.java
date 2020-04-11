/**
 * 
 */
package updateTo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import entity.Book;
import entity.BorrowedRecord;
import entity.Librarian;
import entity.Post;
import entity.Reader;
import entity.ReservedRecord;
import entity.Admin;
import utils.DBhelper;
/**
 * @author ����
 *
 */
public class ToAdmin {

	/*
	 * ���admin�˺�����
	 */
	public static int getTotal() {
		int total = 0;
		try {

			Connection c = DBhelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select count(*) from admin";

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
	 * ���һ��admin����Ȼ�о��ò���
	 */
	public static void add(Admin admin) {

		try {

			Connection c = DBhelper.getInstance().getConnection();

			String sql = "insert into admin(account,password,fine,borrowedMaxinum,reservedMaxinum,fineTime) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setLong(1, admin.getAccount());
			ps.setString(2, admin.getPassword());
			ps.setDouble(3, admin.getFine());
			ps.setInt(4, admin.getBorrowedMaxinum());
			ps.setInt(5, admin.getReservedMaxinum());
			ps.setInt(6, admin.getResercedTime());
			ps.setInt(7, admin.getFineTime());
			
			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();

			DBhelper.closeConnection(c, ps, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * ����admin��Ϣ��Ҳ�ǽ����admin��Ϣ������ȫ����Ϣ�����緣�����������
	 */
	public static void update(Admin admin) {
		try {

			Connection c = DBhelper.getInstance().getConnection();

			String sql = "update admin set password= ?, fine = ? , borrowedMaxinum = ? , reservedMaxinum=?,reservedTime=?,fineTime=?, cash=? where account = ?";
			
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setDouble(8, admin.getCash());
			ps.setLong(7, admin.getAccount());
			ps.setString(1, admin.getPassword());
			ps.setDouble(2, admin.getFine());
			ps.setInt(3, admin.getBorrowedMaxinum());
			ps.setInt(4, admin.getReservedMaxinum());
			ps.setInt(5, admin.getResercedTime());
			ps.setInt(6, admin.getFineTime());

			ps.execute();

			DBhelper.closeConnection(c, ps, null);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/*
	 * ��������������Ϣ
	 */
	public static void updatePassword(String password) {
		try {

			Connection c = DBhelper.getInstance().getConnection();

			String sql = "update admin set password=?";
			
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, password);
		
			ps.execute();

			DBhelper.closeConnection(c, ps, null);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/*
	 * �������·�����Ϣ
	 */
	public static void updateFine(double fine) {
		try {

			Connection c = DBhelper.getInstance().getConnection();

			String sql = "update admin set fine=?";
			
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setDouble(1, fine);
		
			ps.execute();

			DBhelper.closeConnection(c, ps, null);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/*
	 * �������½�������
	 */
	public static void updateBorrowedMax(int num) {
		try {

			Connection c = DBhelper.getInstance().getConnection();

			String sql = "update admin set borrowedMaxinum=?";
			
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setDouble(1, num);
		
			ps.execute();

			DBhelper.closeConnection(c, ps, null);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/*
	 * ��������ԤԼ����
	 */
	public static void updateReservedMax(int num) {
		try {

			Connection c = DBhelper.getInstance().getConnection();

			String sql = "update admin set reservedMaxinum=?";
			
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setDouble(1, num);
		
			ps.execute();

			DBhelper.closeConnection(c, ps, null);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/*
	 * ��������ԤԼʱ��
	 */
	public static void updateReservedTime(int num) {
		try {

			Connection c = DBhelper.getInstance().getConnection();

			String sql = "update admin set reservedTime=?";
			
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setDouble(1, num);
		
			ps.execute();

			DBhelper.closeConnection(c, ps, null);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void updateCash(double num) {
		try {

			Connection c = DBhelper.getInstance().getConnection();

			String sql = "update admin set cash=?";
			
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setDouble(1, num);
		
			ps.execute();

			DBhelper.closeConnection(c, ps, null);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/*
	 * �������·���ʱ��
	 */
	public static void updateFineTime(int num) {
		try {

			Connection c = DBhelper.getInstance().getConnection();

			String sql = "update admin set fineTime=?";
			
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setDouble(1, num);
		
			ps.execute();

			DBhelper.closeConnection(c, ps, null);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/*
	 * ɾ��ĳһ�˺ţ���Ȼ�о��ò���
	 */
	public static void delete(String account) {
		try {

			Connection c = DBhelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "delete from admin where account = " +"'"+account+"';";

			s.execute(sql);

			DBhelper.closeConnection(c, s, null);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * �����˺Ż��admin��Ϣ
	 */
	public static Admin getByAccount(String account) {
		Admin admin = new Admin();
		try {

			Connection c = DBhelper.getInstance().getConnection();

			Statement s = c.createStatement();

			String sql = "select * from admin where account = " + "'"+account+"';";

			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {
				admin.setAccount(rs.getLong("account"));
				admin.setPassword(rs.getString("password"));
				admin.setFine(rs.getDouble("fine"));
				admin.setBorrowedMaxinum(rs.getInt("borrowedMaxinum"));
				admin.setReservedMaxinum(rs.getInt("reservedMaxinum"));
				admin.setResercedTime(rs.getInt("reservedTime"));
				admin.setFineTime(rs.getInt("fineTime"));
				
			}

			DBhelper.closeConnection(c, s, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}
	/*
	 * ����б�
	 */
	public static List<Admin> list() {
		return list(0, Short.MAX_VALUE);
	}
	/*
	 * ���admin�б�
	 */
	public static List<Admin> list(int start, int count) {
		List<Admin> admins = new ArrayList<Admin>();

		try {

			Connection c = DBhelper.getInstance().getConnection();

			String sql = "select * from admin order by account desc limit ?,? ";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, count);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Admin admin = new Admin();
				admin.setAccount(rs.getLong("account"));
				admin.setPassword(rs.getString("password"));
				admin.setFine(rs.getDouble("fine"));
				admin.setBorrowedMaxinum(rs.getInt("borrowedMaxinum"));
				admin.setReservedMaxinum(rs.getInt("reservedMaxinum"));
				admin.setResercedTime(rs.getInt("reservedTime"));
				admin.setFineTime(rs.getInt("fineTime"));
				admin.setCash(rs.getDouble("cash"));
				admins.add(admin);
			}
			DBhelper.closeConnection(c, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admins;
	}
}
