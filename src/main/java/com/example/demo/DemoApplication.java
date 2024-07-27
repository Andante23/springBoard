package com.example.demo;


import com.example.demo.entity.Board;
import com.example.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@SpringBootApplication
@Controller
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Autowired
	private BoardService boardService;


	@GetMapping("/")
	public  String BoardStart(Model model){
		List<Board> boards = boardService.getAllPost();
		model.addAttribute("boards", boards);
		return "dashBoard";
	}




}
