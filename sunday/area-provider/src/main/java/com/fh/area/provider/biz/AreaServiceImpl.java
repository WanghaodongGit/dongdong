package com.fh.area.provider.biz;

import com.fh.area.api.biz.IAreaService;
import com.fh.area.provider.mapper.IAreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("areaService")
public class AreaServiceImpl implements IAreaService {
    @Autowired
    private IAreaMapper areaMapper;
    @Override
    public List queryArea(Integer id) {
        List areaList =areaMapper.queryArea(id);
        return areaList;
    }
}
