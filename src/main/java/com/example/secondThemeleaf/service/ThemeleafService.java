package com.example.secondThemeleaf.service;

import java.util.List;

import com.example.secondThemeleaf.Entity.ThemeleafEntity;

public interface ThemeleafService {

	ThemeleafEntity getById(int id);
	List<ThemeleafEntity> getAll();
	void deleteById(int id);
	void save(ThemeleafEntity myEntity);
}
