package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity //=> db의 테이블을 의미합니다.
@Data //=> 데이터 가져오는데(=get) 용이한 어노테이션
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer bo_id;

  private String bo_title;

  private String bo_content;




}
