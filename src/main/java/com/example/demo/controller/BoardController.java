package com.example.demo.controller;


import com.example.demo.entity.Board;
import com.example.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


// 클라이언트에게 요청을 받습니다. 그리고, 그에 맞는 응답을 주는 어노테이션 입니다.
/*
* 24-28에서 27처럼 뷰를 반환합니다.
* 24처럼 매핑을 합니다.
* */
@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write")
    public String BoardWriteForm(){

        return "writeForm";
    }




    @PostMapping("board/writepro")  //=> 사용자가 폼에서 제출한 데이터가 찍혔는지 검증하는 로직
    public String boardWritePro(Board board){  //=>  메서드 매개변수도 form의 name과 일치해야함

        //=> 19 - 20 : 사용자가 입력한 데이터 출력해보기
//           System.out.println("제목:"+ board.getBo_title());
//            System.out.println("내용:"+ board.getBo_content());

        // 28: 사용자가 데이터를 입력하고 제출버튼을 클릭시 board라는 테이블에 데이터가 저장되는 로직
        boardService.write(board);

        return "";
    }
}
