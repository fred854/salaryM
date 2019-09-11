package com.sal.service;

import com.sal.pojo.Position;

import java.util.List;

public interface PositionService {
    //查询所有职称
    List<Position> selectPositionAll();

    //添加职称
    String addPosition(Position position);

    //删除职称
    String deletePosition(Integer positionId);

    //修改职称
    String updatePosition(Position position);

}
