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
		
		String[] partsHora = date.split(Constantes.COLON);
		String[] partsMin = partsHora[1].split(" ");
		Calendar cal = Calendar.getInstance();
		int hora= Integer.parseInt(partsHora[0]);
		int minuto= Integer.parseInt( partsMin[0]);
		
		if (partsMin[1].contains(Constantes.PM)){
			hora= hora+12;
		}
		
		cal.set(Calendar.HOUR_OF_DAY, hora);
		cal.set(Calendar.MINUTE, minuto);
		cal.set(Calendar.SECOND, 0);
		
		return cal.getTime();
	}
}
