package com.sal.service;

import com.sal.dao.PositionMapper;
import com.sal.exception.MyException;
import com.sal.pojo.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
   private PositionMapper positionMapper;

    @Override
    public List<Position> selectPositionAll() {
        List<Position> list=positionMapper.selectPositionAll();
        return list;
    }

    @Override
    public String addPosition(Position position) {
        Integer id=positionMapper.addPosition(position);
        if(id==0||id==null){
            throw new MyException(500,"添加失败！");
        }
        return "添加成功";
    }

    @Override
    public String deletePosition(Integer positionId) {
        Integer id=positionMapper.deletePosition(positionId);
        if(id==0||id==null){
            throw new MyException(500,"删除失败！");
        }
        return "删除成功";
    }

    @Override
    public String updatePosition(Position position) {
        Integer id=positionMapper.updatePosition(position);
        if(id==0||id==null){
            throw new MyException(500,"修改失败！");
        }
        return "修改成功";
    }
}
