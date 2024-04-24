package com.ohgiraffers.dosirak.admin.controller.model.service;

import com.ohgiraffers.dosirak.admin.controller.model.dao.AdminMainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminMainService {
    
    @Autowired
    private AdminMainMapper adminMainMapper;
    
    public List<Map<String, String>> joinCount() {
        return adminMainMapper.joinCount();
    }

    public int joinNum() {
        return adminMainMapper.joinNum();
    }
}
