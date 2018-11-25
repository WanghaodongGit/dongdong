package com.fh.log.provider.biz;

import com.fh.log.api.biz.ILogService;
import com.fh.log.api.po.Log;
import com.fh.log.provider.mapper.ILogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("logService")
public class LogServiceImpl implements ILogService {

    @Autowired
    private ILogMapper logMapper;

    @Override
    public void addLog(Log log) {
        log.setCreatTime(new Date());
        logMapper.addLog(log);
    }
}
