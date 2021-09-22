package ru.fbtw.tagger.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.vk.api.sdk.objects.messages.Message;

import java.io.IOException;

public class MessageDeserializer extends StdDeserializer<Message> {
	protected MessageDeserializer(Class<?> vc) {
		super(vc);
	}

	protected MessageDeserializer() {
		this(null);
	}

	@Override
	public Message deserialize(JsonParser jp, DeserializationContext context)
			throws IOException, JsonProcessingException {
		return null;
	}
}
