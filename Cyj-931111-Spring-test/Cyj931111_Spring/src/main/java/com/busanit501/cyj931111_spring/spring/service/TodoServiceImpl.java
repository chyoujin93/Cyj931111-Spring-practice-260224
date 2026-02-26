package com.busanit501.cyj931111_spring.spring.service;

import com.busanit501.cyj931111_spring.spring.domain._1_TodoVO;
import com.busanit501.cyj931111_spring.spring.dto._2_TodoDTO;
import com.busanit501.cyj931111_spring.spring.mapper._5_TodoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

    // 서비스는, 직접적으로 DB에 insert 기능이 있나요?
    // 아니요. 어떻게 ? 1) 직접 만들기 2) 만들어진 것  가져와서 이용한다.
    // 1) TodoMapper 2) DTO -> VO 변환 도구 : ModelMapper
    // 어떻게 가져오죠? 포함 관계, 다른 클래스의 객체를 가져오고,
    // 연결? 1)오토와이어드 2) 롬복을 이용해서, 생성자 주입 방식.
    //2)을 이용해서, 연결하기.
    private final _5_TodoMapper todoMapper;
    private final ModelMapper modelMapper;

    // 화면에서, 입력된 정보를 받기 -> DTO담기 -> VO 변환 -> DB 에 전달.
    @Override
    public void register(_2_TodoDTO todoDTO) {
        log.info("서비스 작업: insert 기능 작업중. ");
        _1_TodoVO todoVO = modelMapper.map(todoDTO, _1_TodoVO.class);
        log.info("서비스 작업: insert 기능 변환된 todoVO : " + todoVO);
        todoMapper.insert(todoVO);

    }

    @Override
    public List<_2_TodoDTO> getAll() {
        // todoMapper.selectAll() : DB로 부터 전달받은 정보를 TodoVO 타입을 요소로 가지는 리스트로 받기.
        // .stream() : 병렬처리, 중간 작업, 최종 작업,
        // 중간 작업 : .map(vo -> modelMapper.map(vo, TodoDTO.class)) , 리스트에서 요소를 하나 꺼내서, VO -> DTO 타입로 변환
        // 최종 작업 : 변환된 DTO를 리스트화 시키기.
        // 최종은 :  List<TodoDTO> dtoList, 변환된 요소들이 리스트로 반환되었다.
        List<_2_TodoDTO> dtoList = todoMapper.selectAll().stream()
                .map(vo -> modelMapper.map(vo, _2_TodoDTO.class))
                .collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public _2_TodoDTO getOne(Long tno) {
        _1_TodoVO todoVO = todoMapper.selectOne(tno);
        _2_TodoDTO todoDTO = modelMapper.map(todoVO, _2_TodoDTO.class);
        return todoDTO;
    }

    @Override
    public void remove(Long tno) {
        todoMapper.delete(tno);
    }

    @Override
    public void modify(_2_TodoDTO todoDTO) {
        // 화면에서 전달받은 데이터는 어디에 담죠? TodoDTO
        // 서비스에서 -> 데이터 수정할 때는 어디에 담죠 ? TodoVO
        // 여기서, 변환하기.
       _1_TodoVO todoVO = modelMapper.map(todoDTO, _1_TodoVO.class);
       todoMapper.update(todoVO);
    }
}
