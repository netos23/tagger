package ru.fbtw.tagger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.fbtw.tagger.domain.VkEvent;
import ru.fbtw.tagger.service.EventHandlerService;

@RestController
public class WebHookController {
	public static final String SUCCESS = "ok";

	private final EventHandlerService eventHandlerService;

	public WebHookController(EventHandlerService eventHandlerService) {
		this.eventHandlerService = eventHandlerService;
	}

	@GetMapping("/")
	String callback(@RequestBody VkEvent event){
		return eventHandlerService.handle(event);
	}
}
