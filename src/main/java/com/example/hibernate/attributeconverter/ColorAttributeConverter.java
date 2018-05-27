package com.example.hibernate.attributeconverter;

import java.awt.Color;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/*
 * Using autoApply = true here, will by default enable this converter to Color type in all entities and embedables in 
 * this persistent context.
 * To exclude application of this particular entity/embadable field use @Converter(disableConversion = true)
 */
@Converter(autoApply = false)
public class ColorAttributeConverter implements AttributeConverter<Color, String> {

	private static final String SEPERATOR = ",";

	@Override
	public String convertToDatabaseColumn(Color color) {
		System.out.println("inside convertToDatabaseColumn");
		return new StringBuilder().append(color.getRed()).append(SEPERATOR).append(color.getGreen()).append(SEPERATOR)
				.append(color.getBlue()).toString();
	}

	@Override
	public Color convertToEntityAttribute(String dbData) {
		System.out.println("inside convertToEntityAttribute");
		String[] colors = dbData.split(SEPERATOR);
		return new Color(Integer.parseInt(colors[0]), Integer.parseInt(colors[1]), Integer.parseInt(colors[2]));
	}

}
