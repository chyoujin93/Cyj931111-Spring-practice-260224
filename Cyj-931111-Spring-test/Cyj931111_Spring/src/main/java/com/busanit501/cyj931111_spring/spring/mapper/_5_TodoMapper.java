package com.busanit501.cyj931111_spring.spring.mapper;

import com.busanit501.cyj931111_spring.spring.domain._1_TodoVO;

import java.util.List;

public interface _5_TodoMapper {
    String getTime();

    //추가
    // 화면에서, 입력된 정보를 받기 -> DTO담기 -> VO 변환 -> DB 에 전달.
    void insert(_1_TodoVO todoVO);

    // 전체 목록 조회
    List<_1_TodoVO> selectAll();

    // 하나 조회
    _1_TodoVO selectOne(Long tno);

    // 삭제
    void delete(Long tno);
    
    //수정
    void update(_1_TodoVO todoVO);
}
