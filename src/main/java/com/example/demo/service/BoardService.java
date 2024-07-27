package com.example.demo.service;

import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;


@Service
public class BoardService {

    @Autowired
  private BoardRepository boardRepository;


    public List<Board> getAllPost(){
        return boardRepository.findAll();
    }


  public void write(Board board){

      boardRepository.save(board);
  }



    public Board getDetailInfo(Integer id){

       return boardRepository.findById(id).orElseThrow(()-> new ResourceAccessException("리소스를 발견하지 못했습니다."));

    }

    @GetMapping(" /board/delete ")
    public void boardDelete(Integer id){

        boardRepository.deleteById(id);

    }


}
