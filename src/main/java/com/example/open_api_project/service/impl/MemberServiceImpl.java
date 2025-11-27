package com.example.open_api_project.service.impl;

import com.example.open_api_project.service.MemberService;
import com.example.open_api_project.service.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;

    @Override
    public MemberVO actionLogin(MemberVO vo) throws Exception {

        // 아이디로 회원 정보 조회
        MemberVO loginUser = memberMapper.selectMemberByUsername(vo.getUsername());

        // 가져온 정보 검사
        if (loginUser != null) {
            if (loginUser.getPassword().equals(vo.getPassword())) {
                return loginUser;
            }
        }
        
        return null;
    }
}