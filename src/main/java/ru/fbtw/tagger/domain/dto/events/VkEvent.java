package ru.fbtw.tagger.domain.dto.events;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import ru.fbtw.tagger.domain.enums.EventType;
import ru.fbtw.tagger.util.VkEventAdapter;

@Data
@AllArgsConstructor
@JsonAdapter(VkEventAdapter.class)
public class VkEvent {
	@SerializedName("type")
	EventType type;

	@SerializedName("object")
	Object object;

	@SerializedName("group_id")
	Long groupId;

	public VkEvent() {
	}
}
