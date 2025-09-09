package br.com.soc.sistema.infra;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class ConversorLocalDate extends StrutsTypeConverter {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public Object convertFromString(Map context, String[] values, Class toClass) {
        if (values != null && values.length > 0 && values[0] != null && values[0].length() > 0) {
            try {
                return LocalDate.parse(values[0], FORMATTER);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    @Override
    public String convertToString(Map context, Object o) {
        if (o instanceof LocalDate) {
            return ((LocalDate) o).format(FORMATTER);
        }
        return "";
    }
}