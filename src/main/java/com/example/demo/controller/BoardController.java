package com.example.demo.controller;


import com.example.demo.entity.Board;
import com.example.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;


    @GetMapping("/board/write")
    public String BoardWriteForm(){

        return "writeForm";
    }


    @GetMapping("/board/{id}")
    public String getPostDetail(@PathVariable("id") int id, Model model){
        Board board = boardService.getDetailInfo(id);
        model.addAttribute("board" , board);
        return "boardDetail";
    }



    @PostMapping("board/writepro")
    public String boardWritePro(Board board){
        boardService.write(board);
        return "redirect:/";
    }


    @GetMapping("/board/delete")
    public String boardDelete(Integer id){
        boardService.boardDelete(id);
        return "redirect:/";
    }

    @GetMapping("/board/modify/{id}")
    public  String boardModify(@PathVariable("id") Integer id , Model model){
        model.addAttribute("board" , boardService.getDetailInfo(id));
      return "boardModify";
    }

    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id, Board board){

        Board boardTemp = boardService.getDetailInfo(id);
        boardTemp.setBo_title(board.getBo_title());
        boardTemp.setBo_content(board.getBo_content());

        boardService.write(boardTemp);
        return "redirect:/";
    }


}
