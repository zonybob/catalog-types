package mil.nasic.catalog.types;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;

public class CatalogJsonUtils {

	private static ObjectMapper mapper;

	private static synchronized void init() {
		if (mapper == null) {
			mapper = new ObjectMapper();
			mapper.registerModule(new JodaModule());
			mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
			mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		}
	}

	public static ObjectMapper getMapper() {
		if (mapper == null) {
			init();
		}
		return mapper;
	}

	public static <T> T readObject(String json, Class<T> clazz) throws JsonProcessingException, IOException {
		return getMapper().readValue(json, clazz);
	}

	public static <T> T readObject(InputStream in, Class<T> clazz) throws JsonProcessingException, IOException {
		return getMapper().readValue(in, clazz);
	}

	public static String writeObject(Object o) throws JsonProcessingException, IOException {
		return getMapper().writeValueAsString(o);
	}

	public static void writeObject(Object o, OutputStream os) throws JsonProcessingException, IOException {
		// mapper will flush
		getMapper().writeValue(os, o);
	}

	public static boolean areJsonFormsEqual(Object o1, Object o2) throws JsonProcessingException, IOException {
		String sr1 = getMapper().writeValueAsString(o1);
		String sr2 = getMapper().writeValueAsString(o2);
		
		JsonNode n1 = mapper.readTree(sr1);
		JsonNode n2 = mapper.readTree(sr2);
		
		return n1.equals(n2);
	}

}
