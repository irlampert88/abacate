package com.univates.tcc.abacate.integracao.json.conversores;

import java.io.IOException;
import java.time.LocalDateTime;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class LocalDateTimeRestDeserializer
	extends JsonDeserializer<LocalDateTime> {

	@Override
	public LocalDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
//		ObjectCodec oc = parser.getCodec();
//	    JsonNode node = oc.readTree(parser);
//	    
//	    Integer mes = node.get("monthValue").intValue();
//	    Integer ano = node.get("year").intValue();
//	    Integer dia = node.get("dayOfMonth").intValue();
//	    Integer hora = node.get("hour").intValue();
//	    Integer minuto = node.get("minute").intValue();
//	    
//	    LocalDateTime data = LocalDateTime.of(ano, mes, dia, hora, minuto);
//	    
//		return data;
		return LocalDateTime.parse(parser.getText());
	}

}
