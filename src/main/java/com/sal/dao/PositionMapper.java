package com.sal.dao;

import com.sal.pojo.Position;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PositionMapper {

    //查询所有职称
    List<Position> selectPositionAll();

    //添加职称
    Integer addPosition(Position position);

    //删除职称
    Integer deletePosition(Integer positionId);

    //修改职称
    Integer updatePosition(Position position);

}
