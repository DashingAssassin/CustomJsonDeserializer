package com.deserializer;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ModelObject1CustomDeserialzer<T> extends JsonDeserializer<T> {

	List<String> str = Arrays.asList("modelObject2");
	private static final String JSON_MAPPER_PACKAGE = "com.deserializer.mapper";

	@Override
	public T deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		JsonNode node = p.getCodec().readTree(p);
		JsonNode arrayNode = node.get("data");
		Object modObjx = new Object();
		TypeReference<T> modObj1 = new TypeReference<T>() {
		};
		if (arrayNode.isArray()) {
			arrayNode.forEach((a) -> {

				Field[] fields = modObj1.getClass().getDeclaredFields();
//				String[] fieldNames = Arrays.stream(fields).map((b) -> {
//					return b.getName();
//				}).toArray(String[]::new);
				for (String key : str) {
					try {
						Field f = Arrays.stream(fields).filter((b) -> {
							return b.getName().equals(key);
						}).findAny().orElse(null);
						f.setAccessible(true);
						addObjectToList(new ObjectMapper(), a.get(key).traverse(p.getCodec()), f, f.get(modObj1));
						f.setAccessible(false);
					} catch (IOException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}

			});
		}

		return null;
	}

	private void addObjectToList(ObjectMapper mapper, JsonParser parser, Field f, Object list)
			throws JsonParseException, JsonMappingException, IOException {
		if (f.getType().isInstance(list)) {
//			JsonNode node = parser.getCodec().readTree(parser);
//			JsonNode arrayNode = node.get("data");

			((List<Object>) list).add(mapper.readValue(parser,
					(Class<?>) ((java.lang.reflect.ParameterizedType) f.getGenericType()).getActualTypeArguments()[0]));
		}

	}

}
