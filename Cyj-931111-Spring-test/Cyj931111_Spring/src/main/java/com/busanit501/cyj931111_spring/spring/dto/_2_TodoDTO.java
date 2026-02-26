package com.busanit501.cyj931111_spring.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Builder // 객체 생성을 체인 기법을 이용해서, 편하게 작업하기 위해서 사용함.
@NoArgsConstructor // 기본 생성자를 생성함.
@AllArgsConstructor // 모든 멤버를 매개변수로 가지는 생성자를 생성함.
public class _2_TodoDTO {
    private Long tno;

    @NotBlank
    private String title;

    @Future
    private LocalDate dueDate;

    private  boolean finished;

    @NotBlank
    private String writer;
}
