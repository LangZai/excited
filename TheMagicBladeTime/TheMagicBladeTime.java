package part3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author ChenChangJian
 * @createTime 2016年10月19日 下午5:29:25
 */
public class TheMagicBladeTime {
	/**
	 * 将标准String类型的字符串-->Date
	 * 
	 * @param 时间
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
	 * 转换为天涯明月刀时间
	 * 
	 * @param date
	 * @return
	 */
	private String traditionTime(Date date) {
		if (date.equals(this.ziShi()) || date.before(this.chouShi()) && date.after(this.ziShi())) {
			return "子时";
		} else if (date.equals(this.chenShi()) || date.before(this.yinShi()) && date.after(this.chouShi())) {
			return "丑时";
		} else if (date.equals(this.yinShi()) || date.before(this.maoShi()) && date.after(this.yinShi())) {
			return "寅时";
		} else if (date.equals(this.maoShi()) || date.before(this.chenShi()) && date.after(this.maoShi())) {
			return "卯时";
		} else if (date.equals(this.chenShi()) || date.before(this.siShi()) && date.after(this.chenShi())) {
			return "辰时";
		} else if (date.equals(this.siShi()) || date.before(this.wuShi()) && date.after(this.siShi())) {
			return "巳时";
		} else if (date.equals(this.wuShi()) || date.before(this.weiShi()) && date.after(this.wuShi())) {
			return "午时";
		} else if (date.equals(this.weiShi()) || date.before(this.shenShi()) && date.after(this.weiShi())) {
			return "未时";
		} else if (date.equals(this.shenShi()) || date.before(this.youShi()) && date.after(this.shenShi())) {
			return "申时";
		} else if (date.equals(this.youShi()) || date.before(this.xuShi()) && date.after(this.youShi())) {
			return "酉时";
		} else if (date.equals(this.xuShi()) || date.before(this.haiShi()) && date.after(this.xuShi())) {
			return "戌时";
		} else if (date.equals(this.haiShi()) || date.before(this.dateFormat("22:04")) && date.after(this.haiShi())) {
			return "亥时";
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
	 * 将现实时间转换为标准时间
	 * 
	 * @param date
	 * @return
	 */
	private Date changeStardardDate(Date date) {
		date = this.dateFormat(new SimpleDateFormat("HH:mm").format(date));
		Calendar c = Calendar.getInstance();
		if (isBefore4Hours(date)) {
			date = amendHours(date, c, 4);
			return date;
		} else if (isBefore8Hours(date)) {
			date = amendHours(date, c, 8);
			return date;
		} else if (isBefore12Hours(date)) {
			date = amendHours(date, c, 12);
			return date;
		} else if (isBefore16Hours(date)) {
			date = amendHours(date, c, 16);
			return date;
		} else if (date.equals(this.dateFormat("23:59"))
				|| date.before(this.dateFormat("23:59")) && date.after(this.dateFormat("22:03"))) {
			date = amendHours(date, c, -4);
			return date;
		} else if (date.equals(this.dateFormat("00:00"))
				|| date.before(this.dateFormat("2:04")) && date.after(this.dateFormat("00:00"))) {

			return amendHours(date, c, 20);
		}
		return date;

	}

	/**
	 * 比标准超前4个小时
	 * 
	 * @param date
	 * @return
	 */
	private boolean isBefore4Hours(Date date) {
		return date.before(this.dateFormat("18:04")) && date.after(this.dateFormat("14:03"));
	}

	/**
	 * 比标准超前8个小时
	 * 
	 * @param date
	 * @return
	 */
	private boolean isBefore8Hours(Date date) {
		return date.before(this.dateFormat("14:04")) && date.after(this.dateFormat("10:03"));
	}

	/**
	 * 比标准超前12个小时
	 * 
	 * @param date
	 * @return
	 */
	private boolean isBefore12Hours(Date date) {
		return date.before(this.dateFormat("10:04")) && date.after(this.dateFormat("6:03"));
	}

	/**
	 * 比标准超前16个小时
	 * 
	 * @param date
	 * @return
	 */
	private boolean isBefore16Hours(Date date) {
		return date.before(this.dateFormat("6:04")) && date.after(this.dateFormat("2:03"));
	}

	private Date amendHours(Date date, Calendar c, int amend) {
		// 将Date-->Calendar
		c.setTime(date);
		// 将小时+amend
		c.set(Calendar.HOUR_OF_DAY, c.get(Calendar.HOUR_OF_DAY) + amend);
		// 将Calendar-->Date
		date = this.dateFormat(new SimpleDateFormat("HH:mm").format(c.getTime()));
		return date;
	}

	/**
	 * 转换为天涯明月刀时间
	 * 
	 * @param date
	 * @return
	 */
	private Date traditionTime(String traditionTime) {
		switch (traditionTime) {

		case "子时":
			return this.ziShi();
		case "丑时":
			return this.chouShi();
		case "寅时":
			return this.yinShi();
		case "卯时":
			return this.maoShi();
		case "辰时":
			return this.chenShi();
		case "巳时":
			return this.siShi();
		case "午时":
			return this.wuShi();
		case "未时":
			return this.weiShi();
		case "申时":
			return this.shenShi();
		case "酉时":
			return this.youShi();
		case "戌时":
			return this.xuShi();
		case "亥时":
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
			return "现在已经是" + traditionTime;
		}

	}

	private String waitTimeFormat(Date waitDate, String traditionTime) {
		return new SimpleDateFormat("大概需要HH小时mm分钟才能到" + traditionTime).format(waitDate);
	}

	/**
	 * 当前时间的天涯明月刀的时间
	 * 
	 * @return
	 */
	public String theMagicBladeTime() {
		Date date = new Date();
		return traditionTime(this.changeStardardDate(date));
	}

	/**
	 * 指定时间的天涯明月刀的时间
	 * 
	 * @param 指定时间
	 * @return
	 */
	public String theMagicBladeTime(String dateTime) {
		Date date = null;
		date = this.dateFormat(dateTime);
		return traditionTime(this.changeStardardDate(date));
	}

}
