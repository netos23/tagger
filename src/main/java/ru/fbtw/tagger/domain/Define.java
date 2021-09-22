package ru.fbtw.tagger.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Define {
	String name;
	String charId;
	List<String> ids;
}
