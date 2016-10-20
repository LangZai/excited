package part3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author ChenChangJian
 * @createTime 2016��10��19�� ����5:29:25
 */
public class TheMagicBladeTime {
	/**
	 * ����׼String���͵��ַ���-->Date
	 * 
	 * @param ʱ��
	 * @return
	 */
	private Date dateFormat(String stringDate) {
		Date tempDate = null;
		try {
			tempDate = new SimpleDateFormat("HH:mm").parse(stringDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return tempDate;
	}

	/**
	 * ת��Ϊ�������µ�ʱ��
	 * 
	 * @param date
	 * @return
	 */
	private String traditionTime(Date date) {
		if (date.equals(this.ziShi()) || date.before(this.chouShi()) && date.after(this.ziShi())) {
			return "��ʱ";
		} else if (date.equals(this.chenShi()) || date.before(this.yinShi()) && date.after(this.chouShi())) {
			return "��ʱ";
		} else if (date.equals(this.yinShi()) || date.before(this.maoShi()) && date.after(this.yinShi())) {
			return "��ʱ";
		} else if (date.equals(this.maoShi()) || date.before(this.chenShi()) && date.after(this.maoShi())) {
			return "îʱ";
		} else if (date.equals(this.chenShi()) || date.before(this.siShi()) && date.after(this.chenShi())) {
			return "��ʱ";
		} else if (date.equals(this.siShi()) || date.before(this.wuShi()) && date.after(this.siShi())) {
			return "��ʱ";
		} else if (date.equals(this.wuShi()) || date.before(this.weiShi()) && date.after(this.wuShi())) {
			return "��ʱ";
		} else if (date.equals(this.weiShi()) || date.before(this.shenShi()) && date.after(this.weiShi())) {
			return "δʱ";
		} else if (date.equals(this.shenShi()) || date.before(this.youShi()) && date.after(this.shenShi())) {
			return "��ʱ";
		} else if (date.equals(this.youShi()) || date.before(this.xuShi()) && date.after(this.youShi())) {
			return "��ʱ";
		} else if (date.equals(this.xuShi()) || date.before(this.haiShi()) && date.after(this.xuShi())) {
			return "��ʱ";
		} else if (date.equals(this.haiShi()) || date.before(this.dateFormat("22:04")) && date.after(this.haiShi())) {
			return "��ʱ";
		} else {
			return "error";
		}
	}

	private Date ziShi() {
		return dateFormat("18:04");
	}

	private Date chouShi() {
		return dateFormat("18:09");
	}

	private Date yinShi() {
		return dateFormat("18:16");
	}

	private Date maoShi() {
		return dateFormat("18:26");
	}

	private Date chenShi() {
		return dateFormat("18:50");
	}

	private Date siShi() {
		return dateFormat("19:31");
	}

	private Date wuShi() {
		return dateFormat("19:55");
	}

	private Date weiShi() {
		return dateFormat("20:02");
	}

	private Date shenShi() {
		return dateFormat("20:16");
	}

	private Date youShi() {
		return dateFormat("21:02");
	}

	private Date xuShi() {
		return dateFormat("21:36");
	}

	private Date haiShi() {
		return dateFormat("21:55");
	}

	/**
	 * ����ʵʱ��ת��Ϊ��׼ʱ��
	 * 
	 * @param date
	 * @return
	 */
	private Date changeStardardDate(Date date) {
		date = this.dateFormat(new SimpleDateFormat("HH:mm").format(date));
		Calendar c = Calendar.getInstance();
		if (isBefore4Hours(date)) {
			date = before4Hours(date, c);
			return date;
		} else if (isBefore8Hours(date)) {
			date = before8Hours(date, c);
			return date;
		} else if (isBefore12Hours(date)) {
			date = before12Hours(date, c);
			return date;
		} else if (isBefore16Hours(date)) {
			date = before16Hours(date, c);
			return date;
		} else if (date.equals(this.dateFormat("23:59"))
				|| date.before(this.dateFormat("23:59")) && date.after(this.dateFormat("22:03"))) {
			// ��Date-->Calendar
			c.setTime(date);
			// ��Сʱ+4
			c.set(Calendar.HOUR_OF_DAY, c.get(Calendar.HOUR_OF_DAY) - 4);
			// ��Calendar-->Date
			date = this.dateFormat(new SimpleDateFormat("HH:mm").format(c.getTime()));
			return date;
		} else if (date.equals(this.dateFormat("00:00"))
				|| date.before(this.dateFormat("2:04")) && date.after(this.dateFormat("00:00"))) {
			// ��Date-->Calendar
			c.setTime(date);
			// ��Сʱ+4
			c.set(Calendar.HOUR_OF_DAY, c.get(Calendar.HOUR_OF_DAY) + 20);
			// ��Calendar-->Date
			date = this.dateFormat(new SimpleDateFormat("HH:mm").format(c.getTime()));
			return date;
		}
		return date;

	}

	/**
	 * �ȱ�׼��ǰ4��Сʱ
	 * 
	 * @param date
	 * @return
	 */
	private boolean isBefore4Hours(Date date) {
		return date.before(this.dateFormat("18:04")) && date.after(this.dateFormat("14:03"));
	}

	private Date before4Hours(Date date, Calendar c) {
		// ��Date-->Calendar
		c.setTime(date);
		// ��Сʱ+4
		c.set(Calendar.HOUR_OF_DAY, c.get(Calendar.HOUR_OF_DAY) + 4);
		// ��Calendar-->Date
		date = this.dateFormat(new SimpleDateFormat("HH:mm").format(c.getTime()));
		return date;
	}

	/**
	 * �ȱ�׼��ǰ8��Сʱ
	 * 
	 * @param date
	 * @return
	 */
	private boolean isBefore8Hours(Date date) {
		return date.before(this.dateFormat("14:04")) && date.after(this.dateFormat("10:03"));
	}

	private Date before8Hours(Date date, Calendar c) {
		// ��Date-->Calendar
		c.setTime(date);
		// ��Сʱ+4
		c.set(Calendar.HOUR_OF_DAY, c.get(Calendar.HOUR_OF_DAY) + 8);
		// ��Calendar-->Date
		date = this.dateFormat(new SimpleDateFormat("HH:mm").format(c.getTime()));
		return date;
	}

	/**
	 * �ȱ�׼��ǰ12��Сʱ
	 * 
	 * @param date
	 * @return
	 */
	private boolean isBefore12Hours(Date date) {
		return date.before(this.dateFormat("10:04")) && date.after(this.dateFormat("6:03"));
	}

	private Date before12Hours(Date date, Calendar c) {
		// ��Date-->Calendar
		c.setTime(date);
		// ��Сʱ+4
		c.set(Calendar.HOUR_OF_DAY, c.get(Calendar.HOUR_OF_DAY) + 12);
		// ��Calendar-->Date
		date = this.dateFormat(new SimpleDateFormat("HH:mm").format(c.getTime()));
		return date;
	}

	/**
	 * �ȱ�׼��ǰ16��Сʱ
	 * 
	 * @param date
	 * @return
	 */
	private boolean isBefore16Hours(Date date) {
		return date.before(this.dateFormat("6:04")) && date.after(this.dateFormat("2:03"));
	}

	private Date before16Hours(Date date, Calendar c) {
		// ��Date-->Calendar
		c.setTime(date);
		// ��Сʱ+4
		c.set(Calendar.HOUR_OF_DAY, c.get(Calendar.HOUR_OF_DAY) + 16);
		// ��Calendar-->Date
		date = this.dateFormat(new SimpleDateFormat("HH:mm").format(c.getTime()));
		return date;
	}

	/**
	 * ת��Ϊ�������µ�ʱ��
	 * 
	 * @param date
	 * @return
	 */
	private Date traditionTime(String traditionTime) {
		switch (traditionTime) {

		case "��ʱ":
			return this.ziShi();
		case "��ʱ":
			return this.chouShi();
		case "��ʱ":
			return this.yinShi();
		case "îʱ":
			return this.maoShi();
		case "��ʱ":
			return this.chenShi();
		case "��ʱ":
			return this.siShi();
		case "��ʱ":
			return this.wuShi();
		case "δʱ":
			return this.weiShi();
		case "��ʱ":
			return this.shenShi();
		case "��ʱ":
			return this.youShi();
		case "��ʱ":
			return this.xuShi();
		case "��ʱ":
			return this.haiShi();
		default:
			return new Date();
		}

	}

	public String waitTime(String traditionTime) {
		Date date = this.traditionTime(traditionTime);
		Date nowDate = this.changeStardardDate(new Date());
		GregorianCalendar date1 = new GregorianCalendar();
		date1.setTime(date);
		GregorianCalendar nowdate1 = new GregorianCalendar();
		nowdate1.setTime(nowDate);
		if (date.before(nowDate)) {
			date1.add(Calendar.HOUR_OF_DAY, 4);
			date1.add(Calendar.HOUR_OF_DAY, -nowdate1.get(Calendar.HOUR_OF_DAY));
			date1.add(Calendar.MINUTE, -nowdate1.get(Calendar.MINUTE));
			return this.waitTimeFormat(date1.getTime(), traditionTime);
		} else if (date.after(nowDate)) {

			date1.add(Calendar.HOUR_OF_DAY, -nowdate1.get(Calendar.HOUR_OF_DAY));
			date1.add(Calendar.MINUTE, -nowdate1.get(Calendar.MINUTE));
			return this.waitTimeFormat(date1.getTime(), traditionTime);
		} else {
			return "�����Ѿ���" + traditionTime;
		}

	}

	private String waitTimeFormat(Date waitDate, String traditionTime) {
		return new SimpleDateFormat("�����ҪHHСʱmm���Ӳ��ܵ�" + traditionTime).format(waitDate);
	}

	/**
	 * ��ǰʱ����������µ���ʱ��
	 * 
	 * @return
	 */
	public String theMagicBladeTime() {
		Date date = new Date();
		return traditionTime(this.changeStardardDate(date));
	}

	/**
	 * ָ��ʱ����������µ���ʱ��
	 * 
	 * @param ָ��ʱ��
	 * @return
	 */
	public String theMagicBladeTime(String dateTime) {
		Date date = null;
		date = this.dateFormat(dateTime);
		return traditionTime(this.changeStardardDate(date));
	}

}
