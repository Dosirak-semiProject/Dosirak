package com.ohgiraffers.dosirak.admin.member.model.service;

import com.ohgiraffers.dosirak.admin.member.model.dao.MemberMapper;
import com.ohgiraffers.dosirak.admin.member.model.dto.ManagerDTO;
import com.ohgiraffers.dosirak.admin.member.model.dto.MemberDTO;
import com.ohgiraffers.dosirak.common.member.MemberModifyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;

    public List<MemberDTO> findAllMember(){
        return memberMapper.findAllMember();
    }

    public List<MemberDTO> memberListSearch(Map<String, String> searchMap) {
        return memberMapper.memberListSearch(searchMap);
    }

    public MemberDTO selectMemberView(String id) {
        return memberMapper.selectMemberView(id);
    }

    @Transactional
    public void modifyMember(MemberDTO member) throws MemberModifyException {
        int result = memberMapper.modifyMember(member);
        if(!(result>0)) throw new MemberModifyException("회원 정보 수정 실패");
    }

    public List<ManagerDTO> findAllManager() {
        return memberMapper.findAllManager();
    }

    public ManagerDTO selectManagerView(String id) {
        return memberMapper.selectManagerView(id);
    }

    @Transactional
    public void modifyManager(ManagerDTO manager) throws MemberModifyException {
        int result = memberMapper.modifyManager(manager);
        if(!(result>0)) throw new MemberModifyException("관리자 정보 수정 실패");
    }

    public boolean checkDuplication(String id) {
        String result = memberMapper.checkDuplication(id);
        return result != null;
    }
}
