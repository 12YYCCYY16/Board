package kr.ac.kopo.board.repository;

import kr.ac.kopo.board.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class MemberRepositoryTests {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void insertMembers(){
        IntStream.rangeClosed(1,100).forEach(i->{
            //반복문 1~100까지 i를 1씩 증가시키면서 100번
            Member member = Member.builder()
                    .email("user"+i+"@kopo.ac.kr")
                    .password("1111")
                    .name("USER"+i)
                    .build(); //Member에 초기화를 시켜서 객체를 생성하고 그 참조값을 member 변수에 대입
            //위에 Member 객체를 사용해 member 테이블에 insert(데이터행 삽입)하는 코드

            memberRepository.save(member);
        });

    }
}
