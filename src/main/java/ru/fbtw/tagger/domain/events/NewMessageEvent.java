package ru.fbtw.tagger.domain.events;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.objects.client.InfoForBots;
import com.vk.api.sdk.objects.messages.Message;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewMessageEvent {
	@JsonProperty("message")
	private Message message;

	@JsonProperty("client_info")
	private InfoForBots clientInfo;

	public NewMessageEvent() {
	}
}
