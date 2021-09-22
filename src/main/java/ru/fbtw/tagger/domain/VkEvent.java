package ru.fbtw.tagger.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import ru.fbtw.tagger.domain.events.EventType;
import ru.fbtw.tagger.util.VkEventDeserializer;

@Data
@JsonDeserialize(using = VkEventDeserializer.class)
@AllArgsConstructor
public class VkEvent {
	@JsonProperty("type")
	EventType type;

	@JsonProperty("object")
	Object object;

	@JsonProperty("group_id")
	Long groupId;

	public VkEvent() {
	}
}
