package part3;

import java.util.Scanner;

/**
 *
 * @author ChenChangJian
 * @createTime 2016年10月19日 下午7:39:11
 */
public class App {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		TheMagicBladeTime gameTime = new TheMagicBladeTime();
		System.out.println("天涯明月刀的现在时刻：" + gameTime.theMagicBladeTime());
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

	}
}
