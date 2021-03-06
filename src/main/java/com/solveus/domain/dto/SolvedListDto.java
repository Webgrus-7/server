package com.solveus.domain.dto;

import com.solveus.domain.entity.SolvedList;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SolvedListDto {
    private Long id;
    private String user_id;
    private Long problem_id;
    private Integer grade;
    private Integer p_count;
    private LocalDateTime created;
    private LocalDateTime updated;


    @Builder
    public SolvedListDto(Long id, String user_id, Long problem_id, Integer grade, Integer p_count, LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.user_id = user_id;
        this.problem_id = problem_id;
        this.grade = grade;
        this.p_count = p_count;
        this.created = created;
        this.updated = updated;
    }
}
