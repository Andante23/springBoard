package com.example.demo.controller;


import com.example.demo.entity.Board;
import com.example.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


// 클라이언트에게 요청을 받습니다. 그리고, 그에 맞는 응답을 주는 어노테이션 입니다.
/*
* 24-28에서 27처럼 뷰를 반환합니다.
* 24처럼 매핑을 합니다.
*/
@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    //=> 게시글 작성창
    @GetMapping("/board/write")
    public String BoardWriteForm(){

        return "writeForm";
    }

    //=> 게시글 상세페이지로 이동하기
    @GetMapping("/board/{id}")
    public String getPostDetail(@PathVariable("id") int id, Model model){
        Board board = boardService.getDetailInfo(id);
        model.addAttribute("board" , board);
        return "boardDetail";
    }


    //=> (미구현) 게시글 작성시 프로세스...
    @PostMapping("board/writepro")  //=> 사용자가 폼에서 제출한 데이터가 찍혔는지 검증하는 로직
    public String boardWritePro(Board board){  //=>  메서드 매개변수도 form의 name과 일치해야함

        // 28: 사용자가 데이터를 입력하고 제출버튼을 클릭시 board라는 테이블에 데이터가 저장되는 로직
        boardService.write(board);

        return "";
    }
}
