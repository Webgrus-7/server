package com.solveus;

import com.solveus.domain.entity.Static;
import com.solveus.domain.repository.AuthRepository;
import com.solveus.domain.repository.StaticRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProblemLikeTest {

    @Autowired
    private  StaticRepository staticRepository;

    @Test
    void addLikeCount(){

        Static problem = staticRepository.findById(94L)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 문제입니다."));

        problem.setLike_count(problem.getLike_count() + 1);
        System.out.println(problem.getLike_count());

    }
}
