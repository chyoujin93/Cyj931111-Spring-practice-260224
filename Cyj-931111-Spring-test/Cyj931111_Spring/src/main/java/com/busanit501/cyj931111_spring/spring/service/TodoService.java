package com.busanit501.cyj931111_spring.spring.service;

import com.busanit501.cyj931111_spring.spring.dto._2_TodoDTO;

import java.util.List;

public interface TodoService {
    //추가
    // 화면에서, 입력된 정보를 받기 -> DTO담기 -> VO 변환 -> DB 에 전달.
    void register(_2_TodoDTO todoDTO);

    // 전체 목록
    List<_2_TodoDTO> getAll();

    // 하나 조회
    _2_TodoDTO getOne(Long tno);

    // 삭제
    void remove(Long tno);

    //수정
    void modify(_2_TodoDTO todoDTO);
}
