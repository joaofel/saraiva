package com.joao.saraiva.deserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class FloatDecimalDeserializer extends JsonDeserializer<Float> {

	@Override
    public Float deserialize(JsonParser parser, DeserializationContext context)
            throws IOException {
        String floatString = parser.getText();
        if (floatString.contains(",")) {
            floatString = floatString.replace(",", ".");
        }
        return Float.valueOf(floatString);
    }

}
