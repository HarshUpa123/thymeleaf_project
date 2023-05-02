package com.example.secondThemeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.secondThemeleaf.Entity.ThemeleafEntity;
import com.example.secondThemeleaf.serviceImpl.ThemeleafServiceImpl;

@Controller
public class ThemeleafController {

	@Autowired
	ThemeleafServiceImpl themeleafServiceImpl;

	@GetMapping("/")
	public String Home(Model model) {
		model.addAttribute("allemplist", themeleafServiceImpl.getAll());
		return "index";
	}

	@GetMapping("/addnew")
	public String addData(Model model) {
		ThemeleafEntity themeleafEntity = new ThemeleafEntity();
		model.addAttribute("themeleafEntity", themeleafEntity);
		return "NewData";
	}

	@PostMapping("/save")
	public String saveData(@ModelAttribute("themeleafEntity") ThemeleafEntity themeleafEntity) {
		// System.out.println("....34...."+themeleafEntity);
		themeleafServiceImpl.save(themeleafEntity);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String update(@PathVariable(value = "id") int id, Model model) {
		ThemeleafEntity themeleafEntity = themeleafServiceImpl.getById(id);
		model.addAttribute("themeleafEntity", themeleafEntity);
		return "update";
	}

	@GetMapping("/deleteThemeleafEntity/{id}")
	public String delete(@PathVariable(value = "id") int id) {
		themeleafServiceImpl.deleteById(id);
		return "redirect:/";
	}
	
//	@GetMapping("/")
//    public String viewHomePage(Model model) {
//        model.addAttribute("allemplist", themeleafServiceImpl.getAll());
//        return "index";
//    }
}
