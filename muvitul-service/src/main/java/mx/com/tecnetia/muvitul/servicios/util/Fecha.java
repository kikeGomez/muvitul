package mx.com.tecnetia.muvitul.servicios.util;

import java.util.Calendar;
import java.util.Date;

public class Fecha {

	public static String getDayOfWeek(Date date) {
		String[] days = { "DO", "LU", "MA", "MI", "JU", "VI", "SA" };
		int numberDay = 0;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		numberDay = cal.get(Calendar.DAY_OF_WEEK);
		return days[numberDay - 1];
	}

	public static Date getTime(String date) {
		
		String[] parts = date.split(":");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(parts[0]));
		cal.set(Calendar.MINUTE, Integer.parseInt( parts[1]));
		cal.set(Calendar.SECOND, 0);
		
		return cal.getTime();
	}
}
