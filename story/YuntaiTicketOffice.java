package com.excittingCode.story;

/**
 *
 * @author ChenChangJian
 * @createTime 2016��10��11�� ����5:47:35
 */
public class YuntaiTicketOffice {

	public static final double PRICE = 210;

	public static int ticket = 200;

	public boolean qualify(Person person) {
		// �ж���ȫƱ����ѧ��Ʊ
		double finalPrice = YuntaiTicketOffice.PRICE;
		if (person.isStudent()) {
			finalPrice = 135;
		}

		if (person.getMoney() >= finalPrice && YuntaiTicketOffice.ticket != 0) {
			YuntaiTicketOffice.ticket--;
			return true;
		} else {
			return false;
		}
	}

}
