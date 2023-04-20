package com.example.kimbord.domain.board.service.delete;


import com.example.kimbord.domain.board.domain.BoardRepository;
import com.example.kimbord.domain.board.domain.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteService {

    private final BoardRepository boardRepository;
    private final ReplyRepository replyRepository;

    public void del(long id){
            boardRepository.deleteById(id);
    }
    public void replyDel(long id){replyRepository.deleteById(id);}

}
