package com.example.demo.repository;

import com.example.demo.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// 데이터베이스와 관련된 작업을 합니다. => 데이터베이스 crud , 엔티티 관리 , 트랜잭션 관리

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer>{


}
