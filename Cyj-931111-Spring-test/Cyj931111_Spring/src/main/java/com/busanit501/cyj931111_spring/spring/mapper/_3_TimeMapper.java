package com.busanit501.cyj931111_spring.spring.mapper;

import org.apache.ibatis.annotations.Select;

public interface _3_TimeMapper {
    @Select("select now()")
    String getTime();
}
