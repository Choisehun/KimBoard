package com.example.kimbord.controller.core.board;

import com.example.kimbord.domain.board.domain.Board;
import com.example.kimbord.domain.board.service.dto.BoardDto;
import com.example.kimbord.domain.board.service.dto.ReplyDto;
import com.example.kimbord.domain.board.service.list.ListService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequiredArgsConstructor
@Controller
@RequestMapping("/list")
public class ListController {

    private final ListService listService;



    @GetMapping("board-list")
    public String list(@PageableDefault(page=1) Pageable pageable, Model model){
        List<BoardDto> boardDtoList = listService.list();
        model.addAttribute("boardList", boardDtoList);

        pageable.getPageNumber();
        Page<BoardDto> boardDtoPage = listService.pageList(pageable);

        int blockLimit = 10;

        int startPage = (((int)(Math.ceil((double)pageable.getPageNumber()/blockLimit)))-1) * blockLimit +1;
        int endPage = Math.min((startPage + blockLimit - 1), boardDtoPage.getTotalPages());

        model.addAttribute("boardPage", boardDtoPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);


        return "freeBoard/mainBoard";
    }







}
