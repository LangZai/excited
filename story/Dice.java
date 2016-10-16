package com.excittingCode.story;

import java.math.BigDecimal;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ChenChangJian
 * @createTime 2016��10��11�� ����6:49:24
 */
public class Dice extends Game {

	public void playDice(Person person) {
		Scanner in = new Scanner(System.in);
		if (person.getMoney() <= 0) {
			System.out.println("�Ĳ��к����ģ�����˼֮��֮");
			return;
		}
		int targetNumber = (new Random().nextInt(6) + 1);

		System.out.println("�͹�ѹ���㣺");
		int guessNumber = in.nextInt();
		System.out.println(guessNumber + "�������֣��͹�ѹ���٣�");
		setWager(person, in);
		System.out.println(this.getWager() + "Ԫ�����֣��͹�ѹ������");
		setMultiple(person, in);

		if (guessNumber == targetNumber) {
			System.out.println("��ϲ�͹�ѹ����\r" + "�͹�ѹ��" + guessNumber + "��" + super.getWager() + "Ԫ" + super.getMultiple()
					+ "�����ƣ�" + finalWager());
			person.setMoney(person.getMoney() + this.finalWager());

		} else {
			System.out.println("��" + targetNumber + "��û�п͹��´�����");
			person.setMoney(person.getMoney() - finalWager());
		}

	}

	private void setWager(Person person, Scanner in) {
		super.setWager(in.nextDouble());
		while (super.getWager() > person.getMoney()) {
			System.out.println("���룺ѹ̫���ˣ�����ѹ");
			super.setWager(in.nextDouble());
		}
	}

	private void setMultiple(Person person, Scanner in) {
		super.setMultiple(in.nextDouble());
		while (super.getWager() * super.getMultiple() > person.getMoney()) {
			System.out.println("���룺ѹ̫���ˣ�����ѹ");
			super.setMultiple(in.nextDouble());
		}
	}

	private double finalWager() {
		return new BigDecimal(super.getWager()).multiply(new BigDecimal(super.getMultiple()))
				.divide(new BigDecimal(1), 2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
