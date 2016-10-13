package com.chinasofti.javase.ch9.extend.homework;

/**
 *
 * @author ChenChangJian
 * @createTime 2016年10月11日 下午6:32:29
 */
public class App {

	public static void main(String[] args) {
		Person person = new Person("王二", 120, true);
		YuntaiTicketOffice ticketOffice = new YuntaiTicketOffice();
		Dice dice = new Dice();
		if (!ticketOffice.qualify(person)) {
			System.out.println("对不起，您还没买票，你不能进入景区");
		}

		person.cost();
		System.out.println("我去玩两把兴许能凑够钱");
		for (int i = 0; i < 2; i++) {
			dice.playDice(person);
			System.out.println("我还剩" + person.getMoney() + "元");
		}

	}

}
