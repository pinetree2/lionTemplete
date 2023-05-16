package com.example.board.service;

import com.example.board.entity.Board;
import com.example.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired //스프링빈이 읽어와서 알아서 boardrepository 를 주입을 해준다. (Dependency Injection)
    private BoardRepository boardRepository;

    public void write(Board board){
        boardRepository.save(board);
    }

    public List<Board> boardList()
    {
        return boardRepository.findAll(); //list를 반환해주는 메소드
    }

    //특정 게시글 불러오기
    public Board boardView(Integer id){
        //findbyid 로 하면 optional 로 받아지기때문에 get() 써야함
        return boardRepository.findById(id).get();
    }
}
