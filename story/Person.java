package com.excittingCode.story;

/**
 *
 * @author ChenChangJian
 * @createTime 2016年10月11日 下午5:35:01
 */
public class Person {

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 总共拥有的钱
	 */
	private double money;

	private YuntaiTicketOffice yuntai = new YuntaiTicketOffice();

	private boolean student;

	public boolean isStudent() {
		return student;
	}

	public String getName() {
		return name;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public void cost() {
		if (yuntai.qualify(this)) {
			System.out.println("就这么愉快的决定了，去云台山玩。");
		} else {
			System.out.println("云台山太贵，本人屌丝一个，还是在宿舍开黑吧。");
		}
	}

	public Person(String name, double money, boolean student) {
		this.name = name;
		this.money = money;
		this.student = student;
	}

}
