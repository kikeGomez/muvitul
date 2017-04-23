package mx.com.tecnetia.muvitul.servicios.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		int hora= Integer.parseInt(partsHora[0]);
		int minuto= Integer.parseInt( partsMin[0]);
		
		if (date.contains(Constantes.PM)){
			hora= hora == 12 ? hora : hora+12 ;
		} else {
			hora= hora == 12 ? 0 : hora ;
		}
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, hora);
		cal.set(Calendar.MINUTE, minuto);
		cal.set(Calendar.SECOND, 0);
		
		return cal.getTime();
	}
	
	public static Date formatddMMyyyy(Date date) {
		Date output = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String dateStr = sdf.format(date);
			output = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return output;
	}
	
}
