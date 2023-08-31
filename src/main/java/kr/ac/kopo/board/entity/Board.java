package kr.ac.kopo.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "writer")

public class Board extends BaseEntity{
// primary key , generate value = bno값 자동증가
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    private String title;
    private String content;

    @ManyToOne
    private Member writer;//실제 board 테이블에는 writer_email이라는 컬럼이 생성되고 fk키(멤버테이블 email컬럼값만 참조하기위해) 설정



}
