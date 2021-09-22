package ru.fbtw.tagger.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import ru.fbtw.tagger.domain.VkEvent;
import ru.fbtw.tagger.domain.events.EventType;

import java.io.IOException;
import java.util.Locale;

public class VkEventDeserializer extends StdDeserializer<VkEvent> {

	private ObjectMapper mapper;

	protected VkEventDeserializer(Class<?> vc) {
		super(vc);
		mapper = new ObjectMapper();
		
	}

	protected VkEventDeserializer() {
		this(null);
	}

	@Override
	public VkEvent deserialize(JsonParser jp, DeserializationContext deserializationContext)
			throws IOException, JsonProcessingException {
		JsonNode root = jp.getCodec().readTree(jp);

		String typeStr = root.get("type")
				.asText()
				.toUpperCase(Locale.ROOT);

		EventType type = EventType.valueOf(typeStr);

		Object object = null;
		if (root.has("object")) {
			JsonNode payload = root.get("object");


			object = mapper
					.readValue(payload.toString(), type.getType());
		}

		long groupId = root.get("group_id").asLong();
		return new VkEvent(type, object, groupId);
	}
}
