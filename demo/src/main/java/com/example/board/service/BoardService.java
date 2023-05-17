package com.example.board.service;

import com.example.board.entity.Board;
import com.example.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class BoardService {

    @Autowired //스프링빈이 읽어와서 알아서 boardrepository 를 주입을 해준다. (Dependency Injection)
    private BoardRepository boardRepository;

    public void boardwrite(Board board, MultipartFile file) throws IOException {
        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files"; //프로젝트 경로를 담아주는 변수

        UUID uuid = UUID.randomUUID(); //식별자
        String filename = uuid+"_" + file.getOriginalFilename(); //파일이름 생성
        File saveFile = new File(projectPath,filename); //객체 생성
        file.transferTo(saveFile); //
        board.setFilename(filename);
        board.setFilepath("/files/"+filename);
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

    //특정 게시글 삭제
    public void boardDelete(Integer id){
        boardRepository.deleteById(id);
    }
}
