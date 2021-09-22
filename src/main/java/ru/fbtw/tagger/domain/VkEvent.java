package ru.fbtw.tagger.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VkEvent {
	@JsonProperty("type")
	String type;
	@JsonProperty("object")
	String object;
	@JsonProperty("group_id")
	Long groupId;
}
