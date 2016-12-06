
package com.weinxi.util;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JsonUtils {

	private static ObjectMapper mapper = new ObjectMapper();

	private JsonUtils() {
	}

	public static String toJson(Object value) {
		try {
			return mapper.writeValueAsString(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> T toObject(String json, Class<T> valueType) {
		try {

			return mapper.readValue(json, valueType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> T toObject(String json, TypeReference<?> typeReference) {
		try {
			return mapper.readValue(json, typeReference);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> T toObject(String json, JavaType javaType) {
		try {
			return mapper.readValue(json, javaType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void writeValue(Writer writer, Object value) {
		try {
			mapper.writeValue(writer, value);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static JavaType getCollectionType(Class<?> collectionClass,Class<?>... elementClasses) {
		return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> toObject1(String json,Class<T> valueType) {
		try {
			JavaType javaType = getCollectionType(ArrayList.class, valueType);
			
			List<T> lst =  (List<T>)mapper.readValue(json, javaType);
			
			return lst;
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}