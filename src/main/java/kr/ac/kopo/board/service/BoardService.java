package kr.ac.kopo.board.service;

import kr.ac.kopo.board.dto.BoardDTO;
import kr.ac.kopo.board.dto.PageRequestDTO;
import kr.ac.kopo.board.dto.PageResultDTO;
import kr.ac.kopo.board.entity.Board;
import kr.ac.kopo.board.entity.Member;

public interface BoardService {
    Long register(BoardDTO dto); // 게시글 등록할때 필요함
    PageResultDTO<BoardDTO, Object[]>  getList(PageRequestDTO pageRequestDTO);
    //게시글 목록 처리할때 필요함

    BoardDTO get(Long bno);
    // 글 조회기능 선언
    void removeWithReplies(Long bno);
    // 댓글삭제후 원글 삭제

    void modify(BoardDTO boardDTO);
    //dto => entity로 변환
    default Board dtoToEntity (BoardDTO dto){
        Member member = Member.builder()
                .email(dto.getWriterEmail())
                .build();
        Board board = Board.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(member)
                .build();

        return board;
    }

    default BoardDTO entityToDTO(Board board, Member member, Long replyCount) {

        BoardDTO boardDTO = BoardDTO.builder()
                .bno(board.getBno())
                .title(board.getTitle())
                .content(board.getContent())
                .regDate(board.getRegDate())
                .modDate(board.getModDate())
                .writerEmail(member.getEmail())
                .writerName(member.getName())
                .replyCount(replyCount.intValue()) // int로 처리하도록
                .build();

        return boardDTO;
    }


}
