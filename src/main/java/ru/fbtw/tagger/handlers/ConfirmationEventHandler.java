package ru.fbtw.tagger.handlers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.fbtw.tagger.domain.events.Confirmation;

@Component
public class ConfirmationEventHandler implements EventHandler<Confirmation>{

	private final String activationCode;

	public ConfirmationEventHandler(@Value("${activation-code}") String activationCode) {
		this.activationCode = activationCode;
	}

	@Override
	public String handle(Confirmation event) {
		return activationCode;
	}

	@Override
	public String getEventName() {
		return "confirmation";
	}
}
