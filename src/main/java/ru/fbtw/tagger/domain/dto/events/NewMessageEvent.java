package ru.fbtw.tagger.domain.dto.events;

import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.client.InfoForBots;
import com.vk.api.sdk.objects.messages.Message;
import lombok.*;

@Data
@AllArgsConstructor
public class NewMessageEvent {
	@SerializedName("message")
	private Message message;

	@SerializedName("client_info")
	private InfoForBots clientInfo;

	public NewMessageEvent() {
	}
}
