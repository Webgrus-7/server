package com.solveus.service;

import com.solveus.domain.dto.NewProblem;
import com.solveus.domain.dto.ProblemDto;
import com.solveus.domain.entity.Static;
import com.solveus.domain.repository.StaticRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProblemService {

    private final StaticRepository staticRepository;

    @Transactional
    public ProblemDto save(Static problem) {
        Static value =  staticRepository.save(problem);

        ProblemDto result = ProblemDto.builder()
                .id(value.getId())
                .creator_id(value.getCreator_id().getId())
                .title(value.getTitle())
                .content(value.getContent())
                .field(value.getField())
                .type(value.getType())
                .view_1(value.getView_1())
                .view_2(value.getView_2())
                .view_3(value.getView_3())
                .view_4(value.getView_4())
                .view_5(value.getView_5())
                .point(value.getPoint())
                .answer(value.getAnswer())
                .build();

        return result;
    }

    @Transactional
    public List<ProblemDto> getAllProblems() {
        List<Static> statics = staticRepository.findAll();

        List<ProblemDto> result = new ArrayList<>();
        for(Static s: statics){
            ProblemDto show = ProblemDto.builder()
                    .id(s.getId())
                    .creator_id(s.getCreator_id().getId())
                    .title(s.getTitle())
                    .content(s.getContent())
                    .field(s.getField())
                    .type(s.getType())
                    .view_1(s.getView_1())
                    .view_2(s.getView_2())
                    .view_3(s.getView_3())
                    .view_4(s.getView_4())
                    .view_5(s.getView_5())
                    .point(s.getPoint())
                    .answer(s.getAnswer())
                    .build();
            result.add(show);
        }
        return result;
    }

    @Transactional
    public Integer addLikeCount(Long problemID) {
        Static problem = staticRepository.findById(problemID)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 문제입니다."));

        problem.setLike_count(problem.getLike_count() + 1);
        return problem.getLike_count();

    }
}