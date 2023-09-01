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
@ToString(exclude = "writer")//writer 제외한 객체 정보에 대한 문자열

public class Board extends BaseEntity{
// primary key , generate value = bno값 자동증가
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    private String title;
    private String content;
//지연로딩방식 설정
    // 즉각 로딩 방식  eager 은 기본설정이며 무조건 모든 관계에 대해 join을 함
    // 불필요한 조인 발생
    // 데이터의 양이 많을 시에는 즉각로딩방식을 사용했을때 실행시간이 오래걸린다.
    //지연 로딩방식 설정
    @ManyToOne(fetch = FetchType.LAZY)
    private Member writer;//실제 board 테이블에는 writer_email이라는 컬럼이 생성되고 fk키(멤버테이블 email컬럼값만 참조하기위해) 설정



}
