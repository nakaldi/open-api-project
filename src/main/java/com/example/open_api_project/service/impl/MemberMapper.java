package com.example.open_api_project.service.impl;

import com.example.open_api_project.service.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    /**
     * 아이디로 회원 정보 조회
     * (로그인할 때 사용)
     *
     * @param username 로그인할 때 작성한 아이디
     * @return MemberVO
     */
    MemberVO selectMemberByUsername(String username);

    /**
     * 회원 가입
     *
     * @param vo 회원가입에 필요한 정보들이 담겨있는 MemberVO 객체
     */
    void insertMember(MemberVO vo);
}
