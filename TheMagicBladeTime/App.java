package part3;

import java.util.Scanner;

/**
 *
 * @author ChenChangJian
 * @createTime 2016��10��19�� ����7:39:11
 */
public class App {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		TheMagicBladeTime gameTime = new TheMagicBladeTime();
		System.out.println("�������µ�������ʱ�̣�" + gameTime.theMagicBladeTime());
		System.out.print("ָ��ʱ����ʾ�������µ���Ϸʱ��(y\\n)��");
		String judge = in.nextLine();
		String time = null;
		while (judge.equals("y")) {
			System.out.print("������ʱ��(�磺00:00):");
			time = in.nextLine();
			System.out.println("�������µ���ʱ�䣺" + gameTime.theMagicBladeTime(time));
			System.out.print("�Ƿ����(y\\n)��");
			judge = in.nextLine();
		}

	}
}
