package kr.ac.kopo.board.service;

import kr.ac.kopo.board.dto.ReplyDTO;
import kr.ac.kopo.board.entity.Board;
import kr.ac.kopo.board.entity.Reply;

import java.util.List;

public interface ReplyService {

    //댓글 등
    //댓글 목록
    //댓글 수정
    //댓글 삭제
    //dto -> entity로 변환
    //entity -> dto로 변환

    Long register(ReplyDTO replyDTO); // 댓글 등록
    List<ReplyDTO> getList(Long bno); // 특정 게시물의 댓글 목록 가져오기
    void modify(ReplyDTO replyDTO); // 댓글 수정
    void remove(Long rno); // 댓글 삭제
    default Reply dtoToEntity(ReplyDTO replyDTO) {
        Board board = Board.builder().bno(replyDTO.getBno()).build();

        return Reply.builder()
                .rno(replyDTO.getRno())
                .text(replyDTO.getText())
                .replyer(replyDTO.getReplyer())
                .board(board)
                .build();
    }

    // Reply 객체를 ReplyDTO로 변환
// Board 객체가 필요하지 않으므로 게시물 번호만
    default ReplyDTO entityToDTO(Reply reply) {
        ReplyDTO dto = ReplyDTO.builder()
                .rno(reply.getRno())
                .text(reply.getText())
                .replyer(reply.getReplyer())
                .regDate(reply.getRegDate())
                .modDate(reply.getModDate())
                .build();
        return dto;
    }


}
