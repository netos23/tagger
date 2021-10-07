package ru.fbtw.tagger.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Define {
	String name;
	String charId;
	Long groupId;
	List<String> ids;
}
