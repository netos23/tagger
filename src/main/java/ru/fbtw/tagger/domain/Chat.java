package ru.fbtw.tagger.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

@Setter
@Getter
@Entity
public class Chat {
	@Id
	Long chatId;

	List<Define> defineList;
}
