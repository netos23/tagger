package ru.fbtw.tagger.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.fbtw.tagger.domain.dto.events.VkEvent;
import ru.fbtw.tagger.service.EventDispatcherService;

@RestController
@CrossOrigin(origins = {"https://vk.com"})
public class WebHookController {

	private final EventDispatcherService eventDispatcherService;

	public WebHookController(EventDispatcherService eventDispatcherService) {
		this.eventDispatcherService = eventDispatcherService;
	}

	@PostMapping("/")
	String callback(@RequestBody VkEvent event){
		return eventDispatcherService.dispatch(event);
	}
}
