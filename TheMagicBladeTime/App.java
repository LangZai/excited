package part3;

import java.util.Scanner;

/**
 * �������ܣ�1.��ʾ��ǰʱ���µ��������µ�����Ϸʱ�� 2.ָ��ʱ����ʾ�������µ���ʱ�� 3.ָ���������µ���ʱ����ʾ����Ҫ�ȴ��೤ʱ��
 * 
 * @author ChenChangJian
 * @createTime 2016��10��19�� ����7:39:11
 */
public class App {
	public static void main(String[] args) {
		// ����1
		Scanner in = new Scanner(System.in);
		TheMagicBladeTime gameTime = new TheMagicBladeTime();
		System.out.println("�������µ�������ʱ�̣�" + gameTime.theMagicBladeTime());

		// ����2
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

		// ����3
		System.out.println("ָ��ĳ��ʱ�������ڻ��ж೤ʱ�䣺");
		System.out.print("������ʱ����");
		String traditionTime = null;
		do {
			traditionTime = in.nextLine();
			System.out.println(gameTime.waitTime(traditionTime));
			System.out.print("�Ƿ����(y\\n)��");
		} while (judge.equals("y"));

	}
}
