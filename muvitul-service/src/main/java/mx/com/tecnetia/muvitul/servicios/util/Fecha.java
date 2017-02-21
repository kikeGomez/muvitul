package mx.com.tecnetia.muvitul.servicios.util;

import java.util.Calendar;
import java.util.Date;

public class Fecha {

	public static String getDayOfWeek() {
		String[] days = { "DO", "LU", "MA", "MI", "JU", "VI", "SA" };
		Date today = new Date();
		int numberDay = 0;
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		numberDay = cal.get(Calendar.DAY_OF_WEEK);
		return days[numberDay - 1];
	}

}