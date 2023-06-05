package be.pxl.paj.olympicgames.config;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Converter(autoApply = true)
public class LocalTimeAttributeConverter implements AttributeConverter<LocalTime, String>{
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

	@Override
	public String convertToDatabaseColumn(LocalTime localTime) {
		if (localTime == null) {
			return (null);
		} else {

			return (localTime.format(FORMATTER));
		}
	}

	@Override
	public LocalTime convertToEntityAttribute(String time) {
		return (time == null ? null : LocalTime.parse(time, FORMATTER));
	}

}
