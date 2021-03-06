package com.solveus.domain.dto;

import com.solveus.domain.entity.Static;
import com.solveus.domain.entity.User;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NewProblem {

    private String title;
    private String content;
    private String field;
    private Integer type;
    private String view_1;
    private String view_2;
    private String view_3;
    private String view_4;
    private String view_5;
    private Integer point;
    private Integer answer;

    public Static toEntity(){
        Static build = Static.builder()
                .title(title)
                .content(content)
                .field(field)
                .type(type)
                .view_1(view_1)
                .view_2(view_2)
                .view_3(view_3)
                .view_4(view_4)
                .view_5(view_5)
                .point(point)
                .answer(answer)
                .build();
        return build;
    }

    @Builder
    public NewProblem(String title,String content,String field, Integer type, String view_1, String view_2, String view_3, String view_4, String view_5, Integer point, Integer answer) {
        this.title = title;
        this.content = content;
        this.field = field;
        this.type = type;
        this.view_1 = view_1;
        this.view_2 = view_2;
        this.view_3 = view_3;
        this.view_4 = view_4;
        this.view_5 = view_5;
        this.point = point;
        this.answer = answer;
    }
}
