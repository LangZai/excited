package com.excittingCode.story;

import java.util.Scanner;

/**
 *
 * @author ChenChangJian
 * @createTime 2016年10月11日 下午6:32:29
 */
public class App {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Person person = new Person("王二", 120, true);
		YuntaiTicketOffice ticketOffice = new YuntaiTicketOffice();
		Dice dice = new Dice();
		if (!ticketOffice.qualify(person)) {
			System.out.println("对不起，您还没买票，你不能进入景区");
		}

		person.cost();
		System.out.println("开了两把黑后……，好无聊啊我去赌两把兴许能凑够钱");
		do {
			dice.playDice(person);
			System.out.println("我还剩" + person.getMoney() + "元");
			System.out.println("还玩吗（y\\n）");
		} while (in.next().equals("y"));

	}

}
