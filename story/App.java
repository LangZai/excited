package com.chinasofti.javase.ch9.extend.homework;

/**
 *
 * @author ChenChangJian
 * @createTime 2016��10��11�� ����6:32:29
 */
public class App {

	public static void main(String[] args) {
		Person person = new Person("����", 120, true);
		YuntaiTicketOffice ticketOffice = new YuntaiTicketOffice();
		Dice dice = new Dice();
		if (!ticketOffice.qualify(person)) {
			System.out.println("�Բ�������û��Ʊ���㲻�ܽ��뾰��");
		}

		person.cost();
		System.out.println("��ȥ�����������ܴչ�Ǯ");
		for (int i = 0; i < 2; i++) {
			dice.playDice(person);
			System.out.println("�һ�ʣ" + person.getMoney() + "Ԫ");
		}

	}

}
