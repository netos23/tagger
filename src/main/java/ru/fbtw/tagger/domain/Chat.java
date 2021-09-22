package ru.fbtw.tagger.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.util.List;

@Setter
public class Chat {
	Long chatId;

	List<Define> defineList;
}
