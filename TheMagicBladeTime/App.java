package part3;

import java.util.Scanner;

/**
 * 三个功能：1.显示当前时间下的天涯明月刀的游戏时辰 2.指定时间显示天涯明月刀的时辰 3.指定天涯明月刀的时辰显示还需要等待多长时间
 * 
 * @author ChenChangJian
 * @createTime 2016年10月19日 下午7:39:11
 */
public class App {
	public static void main(String[] args) {
		// 功能1
		Scanner in = new Scanner(System.in);
		TheMagicBladeTime gameTime = new TheMagicBladeTime();
		System.out.println("天涯明月刀的现在时刻：" + gameTime.theMagicBladeTime());

		// 功能2
		System.out.print("指定时间显示天涯明月刀游戏时间(y\\n)：");
		String judge = in.nextLine();
		String time = null;
		while (judge.equals("y")) {
			System.out.print("请输入时间(如：00:00):");
			time = in.nextLine();
			System.out.println("天涯明月刀的时间：" + gameTime.theMagicBladeTime(time));
			System.out.print("是否继续(y\\n)：");
			judge = in.nextLine();
		}

		// 功能3
		System.out.println("指定某个时辰距现在还有多长时间：");
		System.out.print("请输入时辰：");
		String traditionTime = null;
		do {
			traditionTime = in.nextLine();
			System.out.println(gameTime.waitTime(traditionTime));
			System.out.print("是否继续(y\\n)：");
		} while (judge.equals("y"));

	}
}
