package com.excittingCode.story;

import java.util.Scanner;

/**
 *
 * @author ChenChangJian
 * @createTime 2016��10��11�� ����6:32:29
 */
public class App {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Person person = new Person("����", 120, true);
		YuntaiTicketOffice ticketOffice = new YuntaiTicketOffice();
		Dice dice = new Dice();
		if (!ticketOffice.qualify(person)) {
			System.out.println("�Բ�������û��Ʊ���㲻�ܽ��뾰��");
		}

		person.cost();
		System.out.println("�������Ѻں󡭡��������İ���ȥ�����������ܴչ�Ǯ");
		do {
			dice.playDice(person);
			System.out.println("�һ�ʣ" + person.getMoney() + "Ԫ");
			System.out.println("������y\\n��");
		} while (in.next().equals("y"));

	}

}
