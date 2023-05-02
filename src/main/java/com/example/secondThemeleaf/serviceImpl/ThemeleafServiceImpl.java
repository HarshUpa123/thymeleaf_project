package com.example.secondThemeleaf.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.secondThemeleaf.Entity.ThemeleafEntity;
import com.example.secondThemeleaf.Repository.ThemeleafRepository;
import com.example.secondThemeleaf.service.ThemeleafService;

@Service
public class ThemeleafServiceImpl implements ThemeleafService {

	@Autowired
	private ThemeleafRepository themeleafRepo;

	@Override
	public ThemeleafEntity getById(int id) {
		Optional<ThemeleafEntity> data = themeleafRepo.findById(id);
		ThemeleafEntity yes = null;
		if (data.isPresent()) {
			yes = data.get();
		} else {
			throw new RuntimeException("DataById not found" + id);
		}
		return yes;
	}

	@Override
	public List<ThemeleafEntity> getAll() {
		return themeleafRepo.findAll();
	}

	@Override
	public void deleteById(int id) {
		themeleafRepo.deleteById(id);
	}

	@Override
	public void save(ThemeleafEntity themeleafEntity) {
		System.out.println("......40...." + themeleafEntity);
		themeleafRepo.save(themeleafEntity);

	}

}
