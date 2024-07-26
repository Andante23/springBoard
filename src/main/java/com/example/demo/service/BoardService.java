package com.example.demo.service;

import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service //=> 비즈니스 로직 처리에 붙는 어노테이션 => 예를 들어서, 데이터베이스 조작 , 예외처리
public class BoardService {

    @Autowired
  private BoardRepository boardRepository;

    //=> 게시글 db로부터 모든 데이터 블러오는 메서드
    public List<Board> getAllPost(){
        return boardRepository.findAll();
    }

    //=> 게시글 db에 게시글 저장하는 메서드
  public void write(Board board){

      boardRepository.save(board);
  }


}
