package com.ohgiraffers.dosirak.admin.member.model.service;

import com.ohgiraffers.dosirak.admin.member.model.dao.MemberMapper;
import com.ohgiraffers.dosirak.admin.member.model.dto.ManagerDTO;
import com.ohgiraffers.dosirak.admin.member.model.dto.MemberDTO;
import com.ohgiraffers.dosirak.common.member.MemberModifyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;

    public List<MemberDTO> findAllMember(){
        return memberMapper.findAllMember();
    }

    public List<ManagerDTO> findAllManager() {
        return memberMapper.findAllManager();
    }

    public MemberDTO selectMemberView(String id) {
        return memberMapper.selectMemberView(id);
    }

    @Transactional
    public void modifyMember(MemberDTO member) throws MemberModifyException {
        int result = memberMapper.modifyMember(member);
        if(!(result>0)) throw new MemberModifyException("회원 정보 수정 실패");
    }
//    @Transactional
//    public void modifyMember(MemberDTO modifyMember) throws MemberModifyException {
//
//        int result = memberMapper.updateMember(modifyMember);
//
//        if(!(result > 0)) throw new MemberModifyException("회원 정보 수정에 실패하였습니다.");
//
//    }
}
