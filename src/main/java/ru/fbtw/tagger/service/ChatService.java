package ru.fbtw.tagger.service;

import ru.fbtw.tagger.domain.Define;

import java.util.List;

public interface ChatService {
	void addDefine(Define define);
	void editDefine(Define define);
	void removeDefine(Define define);
	List<Define> getDefines();
}
