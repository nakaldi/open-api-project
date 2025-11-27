package com.example.open_api_project.service;


public interface MemberService {

    /**
     * 로그인 처리
     *
     * @param vo (사용자가 입력한 ID/PW)
     * @return MemberVO (로그인 성공한 회원 정보, 실패하면 null)
     * @throws Exception
     */
    MemberVO actionLogin(MemberVO vo) throws Exception;
}