package com.example.board.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

//테이블을 의미하는 어노테이션
@Entity
@Data //get,set 메소드 이용가능하게 하는 어노테이션
public class Board {
    @Id //해당 클래스의 주요 식별자(primary key)를 나타내는 어노테이션
    //@GeneratedValue(strategy = GenerationType.IDENTITY)는 JPA에서 기본 키를 자동으로 생성할 때 사용하는 방법 중 하나
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String content;
    private String filename;
    private String filepath;
}
