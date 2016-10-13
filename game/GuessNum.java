package com.demo.day14.homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ChenChangJian
 * @createTime 2016年10月4日 下午4:29:53
 */
public class GuessNum {

	private Scanner in = new Scanner(System.in);
	/**
	 * 成绩
	 */
	private int mark = 100;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 猜测次数
	 */
	private int count;
	/**
	 * 存储
	 */
	private String storage;

	private void setMark() {
		mark = 100 - 5 * (count - 1);
	}

	private void setUserName() {
		userName = in.next();
	}

	/**
	 * 猜数游戏
	 */
	private void guessGame() {
		Random random = new Random();
		int num = random.nextInt(200);
		int guessNum = -1;
		for (; guessNum != num; count++) {
			System.out.print("第" + count + "次输入(0~200)：");
			guessNum = in.nextInt();
			String prompt = guessNum > num ? "大了" : "小了";
			if (guessNum != num) {
				System.out.println(prompt);
			} else {
				System.out.println("恭喜你完成了游戏");
			}

		}
		System.out.print("请输入用户名：");
		setUserName();
		setMark();
	}

	/**
	 * 判断成绩是否存储
	 * 
	 * @throws Exception
	 */
	private void judge() throws Exception {
		System.out.print("成绩是否录入排行榜(Y\\N)：");
		String judge = in.next();
		if (judge.equals("Y")) {
			out();
		} else {

		}
	}

	/**
	 * 取得存储格式
	 * 
	 * @return
	 */
	private String getStorage() {
		String str = userName + ":" + mark + " ";
		return str;
	}

	/**
	 * 将用户数据存储到
	 * 
	 * @throws Exception
	 */
	private void out() throws Exception {
		/**
		 * 用户数据存储位置
		 */
		File file = new File("d:" + File.separator + "guessNum" + File.separator + "sankingList.txt");
		// 判断路径是否存在，如不存在要创建路径
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}

		// 实例化OutputStream
		OutputStream output = new FileOutputStream(file, true);

		// 将字符串getStorage转换成byte数组;
		byte[] data = getStorage().getBytes();
		// 将byte数组写到文件中
		output.write(data);

		// 关闭资源
		output.close();

	}

	/**
	 * 做排行榜
	 * 
	 * @throws Exception
	 */
	private void rank() throws Exception {
		/**
		 * 用户数据存储位置
		 */
		File file = new File("d:" + File.separator + "guessNum" + File.separator + "sankingList.txt");
		// 判断是否存在文件
		if (file.exists()) {

			// 使用InputStream进行读取
			InputStream input = new FileInputStream(file);

			byte[] data = new byte[1024];// 准备一个1024的数组
			int foot = 0;// 数组脚标
			int temp = 0;// 每次读取的字节数组
			while ((temp = input.read()) != -1) {
				data[foot++] = (byte) temp;
			}
			// 关闭资源
			input.close();
			// 将取出的byte数组转换成String，去除前导，后导空白
			String str = new String(data).trim();
			// 将String从" "处拆开，使user数组中存储每个用户的数据
			String[] user = str.split(" ");
			// 从user数组中提取成绩，使之成为int型数组mark
			int[] mark = new int[user.length];
			for (int i = 0; i < user.length; i++) {
				String[] temp1 = user[i].split(":");
				Integer a = new Integer(temp1[1]);
				mark[i] = a.intValue();
			}
			// 利用int类型数组进行冒泡排序
			int temp2;
			String temp3;
			for (int i = 0; i < mark.length; i++) {
				for (int j = 0; j < mark.length - 1; j++) {
					if (mark[j] < mark[j + 1]) {
						// 成绩
						temp2 = mark[j];
						mark[j] = mark[j + 1];
						mark[j + 1] = temp2;
						// 用户
						temp3 = user[j];
						user[j] = user[j + 1];
						user[j + 1] = temp3;
					}
				}
			}
			System.out.println("用户排行榜：");
			for (int i = 0; i < user.length; i++) {
				System.out.println(user[i]);
			}

		}
	}

	private void resetting() {
		System.out.println("是否重置排行榜(Y\\N):");
		if (in.next().equals("Y")) {
			File file = new File("d:" + File.separator + "guessNum" + File.separator + "sankingList.txt");
			file.delete();
		}
	}

	public void Game() throws Exception {
		guessGame();
		System.out.println("用户名：" + userName + "\n成绩：" + mark + "分");
		judge();
		rank();
		resetting();
		in.close();

	}

	public static void main(String[] args) throws Exception {

		GuessNum test = new GuessNum();
		test.Game();

	}

}
