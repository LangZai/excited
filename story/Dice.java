package com.excittingCode.story;

import java.math.BigDecimal;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ChenChangJian
 * @createTime 2016年10月11日 下午6:49:24
 */
public class Dice extends Game {

	public void playDice(Person person) {
		Scanner in = new Scanner(System.in);
		if (person.getMoney() <= 0) {
			System.out.println("赌博有害身心，望君思之慎之");
			return;
		}
		int targetNumber = (new Random().nextInt(6) + 1);

		System.out.println("客官压几点：");
		int guessNumber = in.nextInt();
		System.out.println(guessNumber + "点买定离手，客官压多少：");
		setWager(person, in);
		System.out.println(this.getWager() + "元买定离手，客官压几倍：");
		setMultiple(person, in);

		if (guessNumber == targetNumber) {
			System.out.println("恭喜客官压中了\r" + "客官压的" + guessNumber + "点" + super.getWager() + "元" + super.getMultiple()
					+ "倍共计：" + finalWager());
			person.setMoney(person.getMoney() + this.finalWager());

		} else {
			System.out.println("开" + targetNumber + "点没中客官下次请早");
			person.setMoney(person.getMoney() - finalWager());
		}

	}

	private void setWager(Person person, Scanner in) {
		super.setWager(in.nextDouble());
		while (super.getWager() > person.getMoney()) {
			System.out.println("我想：压太多了，重新压");
			super.setWager(in.nextDouble());
		}
	}

	private void setMultiple(Person person, Scanner in) {
		super.setMultiple(in.nextDouble());
		while (super.getWager() * super.getMultiple() > person.getMoney()) {
			System.out.println("我想：压太多了，重新压");
			super.setMultiple(in.nextDouble());
		}
	}

	private double finalWager() {
		return new BigDecimal(super.getWager()).multiply(new BigDecimal(super.getMultiple()))
				.divide(new BigDecimal(1), 2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
