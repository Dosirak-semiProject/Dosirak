package com.ohgiraffers.dosirak.admin.suitBox.model.service;

import com.ohgiraffers.dosirak.admin.suitBox.model.dao.AdminSuitBoxDAO;
import com.ohgiraffers.dosirak.admin.suitBox.model.dto.SuitBoxMenuDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminSuitBoxService {
    private final AdminSuitBoxDAO mapper;
    public AdminSuitBoxService(AdminSuitBoxDAO mapper) {
        this.mapper = mapper;
    }

    public List<SuitBoxMenuDTO> getSuitBoxMenu() {
        return mapper.getSuitBoxMenu();
    }
}
