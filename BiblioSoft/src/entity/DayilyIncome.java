package entity;

import java.util.Date;

public class DayilyIncome {
	//����
	private Date date;
	//����Ѻ������
	private double cash;
	//���շ�������
	private double fine;
	
	//Ĭ�Ϲ��캯��
	public DayilyIncome (){
		date = null;
		cash = 0;
		fine = 0;
	}
	
	//�������Ĺ��캯��
	public DayilyIncome(Date date2, double cash, double fine) {
		super();
		this.date = date2;
		this.cash = cash;
		this.fine = fine;
	}
	
	/**
	 * @return the date
	 */
	public java.util.Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the cash
	 */
	public double getCash() {
		return cash;
	}
	/**
	 * @param cash the cash to set
	 */
	public void setCash(double cash) {
		this.cash = cash;
	}
	/**
	 * @return the fine
	 */
	public double getFine() {
		return fine;
	}
	/**
	 * @param fine the fine to set
	 */
	public void setFine(double fine) {
		this.fine = fine;
	}
}
