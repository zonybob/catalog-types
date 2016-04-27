package mil.nasic.catalog.types;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
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

}
