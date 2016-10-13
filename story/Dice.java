package com.chinasofti.javase.ch9.extend.homework;

import java.math.BigDecimal;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ChenChangJian
 * @createTime 2016年10月11日 下午6:49:24
 */
public class Dice extends Game {

	private Scanner in = new Scanner(System.in);// 问题：将此语句写在playDice方法内时，第二次执行该程序时会报异常

	public void playDice(Person person) {
		if (person.getMoney() <= 0) {
			System.out.println("穷鬼，滚蛋！");
			return;
		}
		int targetNumber = (new Random().nextInt(6) + 1);
		// Scanner in = new Scanner(System.in);//此位置
		System.out.println("客官压几点：");
		int guessNumber = in.nextInt();
		System.out.println(guessNumber + "点买定离手，客官压多少：");
		this.setWager(in.nextDouble());
		while (this.getWager() > person.getMoney()) {
			System.out.println("我想：压太多了，重新压");
			this.setWager(in.nextDouble());
		}
		person.setMoney(person.getMoney() - this.getWager());
		System.out.println(this.getWager() + "元买定离手，客官压几倍：");
		this.setMultiple(in.nextDouble());
		// in.close();
		if (guessNumber == targetNumber) {
			System.out.println("恭喜客官压中了\r" + "客官压的" + guessNumber + "点" + this.getWager() + "元" + this.getMultiple()
					+ "倍共计：" + finalWager());
			person.setMoney(person.getMoney() + this.finalWager());

		} else {
			System.out.println("开" + targetNumber + "点没中客官下次请早");
			person.setMoney(person.getMoney() - finalWager() + this.getWager());
		}

	}

	private double finalWager() {
		return new BigDecimal(this.getWager()).multiply(new BigDecimal(this.getMultiple()))
				.divide(new BigDecimal(1), 2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
