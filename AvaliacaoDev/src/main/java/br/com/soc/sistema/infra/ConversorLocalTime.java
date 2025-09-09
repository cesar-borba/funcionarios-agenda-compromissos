package br.com.soc.sistema.infra;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class ConversorLocalTime extends StrutsTypeConverter {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    @Override
    public Object convertFromString(Map context, String[] values, Class toClass) {
        if (values != null && values.length > 0 && values[0] != null && values[0].length() > 0) {
            try {
                return LocalTime.parse(values[0], FORMATTER);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    @Override
    public String convertToString(Map context, Object o) {
        if (o instanceof LocalTime) {
            return ((LocalTime) o).format(FORMATTER);
        }
        return "";
    }
}