package fr.formation.twitterxs.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.twitterxs.dto.UserCreateDto;
import fr.formation.twitterxs.dto.ValueLabelDto;
import fr.formation.twitterxs.services.RegionService;
import fr.formation.twitterxs.services.UserService;

@Controller
@RequestMapping("/mvc/users")
public class UserMvcController {

	private final UserService service;
	private final RegionService regionService;
	
	
	protected UserMvcController(UserService service , RegionService regionService)
	{
		this.regionService = regionService;
		this.service=service;
	}
	
	@GetMapping("create")
	public String create(@ModelAttribute("user") UserCreateDto user , Model model) {
		populateModel(model);
		return "usercreate";
	}
	
	

	@PostMapping("save")
	public String save(@Valid @ModelAttribute("user") UserCreateDto user , BindingResult result , Model model) {
		if(!result.hasErrors()){
			service.create(user);
			model.addAttribute("user",new UserCreateDto()); //Reset form
		}
		populateModel(model);
		return "usercreate";
	}
	
	private void populateModel(Model model) {
		List<ValueLabelDto> regions = regionService.listValueLabel();
		model.addAttribute("regions",regions);
	}
}
