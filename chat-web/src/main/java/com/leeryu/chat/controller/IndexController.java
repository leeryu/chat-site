package com.leeryu.chat.controller;

import com.leeryu.chat.service.PostsRestInterface;
import com.leeryu.chat.service.ResultFailException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@RequiredArgsConstructor
@Controller
public class IndexController {

	private final PostsRestInterface restInterface;

	@GetMapping("/")
	public String index(Model model) throws IOException, ResultFailException {
		model.addAttribute("posts", restInterface.findByAll().getBody());
		return "index";
	}

	@GetMapping("/posts/save")
	public String postsSave() {
		return "posts-save";
	}
}
