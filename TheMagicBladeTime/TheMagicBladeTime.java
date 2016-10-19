package part3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
	private Date dateFormat(String date) {
		Date tempDate = null;
		try {
			tempDate = new SimpleDateFormat("HH:mm").parse(date);
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
			// 将Date-->Calendar
			c.setTime(date);
			// 将小时+4
			c.set(Calendar.HOUR_OF_DAY, c.get(Calendar.HOUR_OF_DAY) - 4);
			// 将Calendar-->Date
			date = this.dateFormat(new SimpleDateFormat("HH:mm").format(c.getTime()));
			return date;
		} else if (date.equals(this.dateFormat("00:00"))
				|| date.before(this.dateFormat("2:04")) && date.after(this.dateFormat("00:00"))) {
			// 将Date-->Calendar
			c.setTime(date);
			// 将小时+4
			c.set(Calendar.HOUR_OF_DAY, c.get(Calendar.HOUR_OF_DAY) + 20);
			// 将Calendar-->Date
			date = this.dateFormat(new SimpleDateFormat("HH:mm").format(c.getTime()));
			return date;
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

	private Date before4Hours(Date date, Calendar c) {
		// 将Date-->Calendar
		c.setTime(date);
		// 将小时+4
		c.set(Calendar.HOUR_OF_DAY, c.get(Calendar.HOUR_OF_DAY) + 4);
		// 将Calendar-->Date
		date = this.dateFormat(new SimpleDateFormat("HH:mm").format(c.getTime()));
		return date;
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

	private Date before8Hours(Date date, Calendar c) {
		// 将Date-->Calendar
		c.setTime(date);
		// 将小时+4
		c.set(Calendar.HOUR_OF_DAY, c.get(Calendar.HOUR_OF_DAY) + 8);
		// 将Calendar-->Date
		date = this.dateFormat(new SimpleDateFormat("HH:mm").format(c.getTime()));
		return date;
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

	private Date before12Hours(Date date, Calendar c) {
		// 将Date-->Calendar
		c.setTime(date);
		// 将小时+4
		c.set(Calendar.HOUR_OF_DAY, c.get(Calendar.HOUR_OF_DAY) + 12);
		// 将Calendar-->Date
		date = this.dateFormat(new SimpleDateFormat("HH:mm").format(c.getTime()));
		return date;
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

	private Date before16Hours(Date date, Calendar c) {
		// 将Date-->Calendar
		c.setTime(date);
		// 将小时+4
		c.set(Calendar.HOUR_OF_DAY, c.get(Calendar.HOUR_OF_DAY) + 16);
		// 将Calendar-->Date
		date = this.dateFormat(new SimpleDateFormat("HH:mm").format(c.getTime()));
		return date;
	}

	/**
	 * 当前时间的天涯明月刀的时间
	 * 
	 * @return
	 */
	public String theMagicBladeTime() {
		Date date = new Date();
		date = this.dateFormat(new SimpleDateFormat("HH:mm").format(date));
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
