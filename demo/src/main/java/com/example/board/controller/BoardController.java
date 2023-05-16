package com.example.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {
    /**
     * 역슬래시 경로로 들어왔을때 helloworld 를 리턴합니다.
     * @GetMapping("/")
     *     @ResponseBody
     *     public String main(){
     *         return "Hello World";
     *     }
     *
     * */
    //GetMapping : 어떤 url 로 접근할 것인지 지정해주는 어노테이션

    //localhost:8090/board/wirte 주소로 접속하면 board write 페이지 보여주는 설정
    @GetMapping("/board/write")
    public String boardwriteForm(){
        return "boardwrite";
    }

}
