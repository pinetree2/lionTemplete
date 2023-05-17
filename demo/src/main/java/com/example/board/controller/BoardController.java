package com.example.board.controller;

import com.example.board.entity.Board;
import com.example.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;
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

    //boardwrite.html 에서의 요청이 넘어왔는지 확인하는 메소드
    @PostMapping("/board/writepro")
    public String boardWritePro(Board board){ //html 에서지정한 이름대로 매개변수가 Board 클래스에 담겨서 들어옴
        boardService.boardwrite(board);
        return "redirect:/board/list";

    }

    @GetMapping("/board/list")
    public String boardList(Model model){
        //서비스의 메소드를 통해 반환된 list 를 list 라는 이름으로 넘기겠다는 것
       model.addAttribute("list",boardService.boardList());
        return "boardlist";
    }


    @GetMapping("/board/view") //localhost:8090/board/view?id=1 하면, 1 이 id 값이된다.
    public String boardView(Model model,Integer id){

        model.addAttribute("board",boardService.boardView(id));

        return "boardview";
    }

    @GetMapping("/board/delete")
    public String boardDelete(Integer id){
        boardService.boardDelete(id);
        return "redirect:/board/list";
    }

    //수정 버튼 동작
    //path variable 을 이용한 get 방식입니다.
    @GetMapping("/board/modify/{id}")
    public String boardModify(@PathVariable("id") Integer id,
                              Model model) {

        model.addAttribute("board", boardService.boardView(id));

        return "boardmodify";
    }
    //수정 반영
    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id,Board board){

        Board boardTemp =boardService.boardView(id);
        boardTemp.setTitle(board.getTitle());
        boardTemp.setContent(board.getContent());
        boardService.boardwrite(boardTemp);
        return "redirect:/board/list";


    }
}
