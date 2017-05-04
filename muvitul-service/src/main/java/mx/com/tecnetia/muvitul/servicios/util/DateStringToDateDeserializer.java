package mx.com.tecnetia.muvitul.servicios.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DateStringToDateDeserializer extends JsonDeserializer<Date>  {

	@Override
	public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
	     try {
	            String date = p.getValueAsString();
	            SimpleDateFormat sdf = new SimpleDateFormat(Constantes.FORMAT_DD_MM_YYYY);
	            return  sdf.parse(date);
	        } catch (ParseException e) {
	        	System.out.println("ERRORES GENERADOS");
	            throw new IOException(e);
	        }
	}

}
