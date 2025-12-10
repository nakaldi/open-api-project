package com.example.open_api_project.module.member.service;

import com.example.open_api_project.common.exception.ApiException;
import com.example.open_api_project.common.exception.ErrorCode;
import com.example.open_api_project.module.member.entity.Member;
import com.example.open_api_project.module.member.repository.MemberMapper;
import com.example.open_api_project.module.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    @Override
    @Transactional(readOnly = true)
    public Member getMemberById(Long id) {
        return memberRepository.findById(id).orElseThrow(
                () -> new ApiException(ErrorCode.MEMBER_NOT_FOUND));
    }

    @Override
    @Transactional(readOnly = true)
    public Member getMemberByEmail(String email) {
        return memberRepository.findByEmail(email).orElseThrow(
                () -> new ApiException(ErrorCode.MEMBER_NOT_FOUND));
    }

    @Override
    public void changeNickname(Long id, String nickname) {
        if (memberRepository.existsByNickname(nickname)) {
            throw new ApiException(ErrorCode.DUPLICATE_NICKNAME);
        }
        if (memberRepository.updateNickname(id, nickname, LocalDateTime.now()) <= 0) {
            throw new ApiException(ErrorCode.MEMBER_NOT_FOUND);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public void validatePassword(Long id, String password) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new ApiException(ErrorCode.MEMBER_NOT_FOUND)
        );
        if (!passwordEncoder.matches(password, member.getPassword())) {
            throw new ApiException(ErrorCode.INCORRECT_PASSWORD);
        }
    }

    @Override
    public void processPasswordChangeRequest(Long id, String currentPassword, String newPassword) {
        validatePassword(id, currentPassword);
        changePassword(id, newPassword);
    }

    @Override
    public void changePassword(Long id, String newPassword) {
        String newEncodedPassword = passwordEncoder.encode(newPassword);
        if (memberRepository.updatePassword(id, newEncodedPassword, LocalDateTime.now()) == 0) {
            throw new ApiException(ErrorCode.MEMBER_NOT_FOUND);
        }
    }

    @Override
    public void withdrawMember(Long id, String password) {
        validatePassword(id, password);
        if (memberMapper.delete(id) == 0) {
            throw new ApiException(ErrorCode.MEMBER_NOT_FOUND);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public void validateDuplicateEmail(String email) {
        if (memberRepository.existsByEmail(email)) {
            throw new ApiException(ErrorCode.DUPLICATE_EMAIL);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public void validateDuplicateNickname(String nickname) {
        if (memberRepository.existsByNickname(nickname)) {
            throw new ApiException(ErrorCode.DUPLICATE_NICKNAME);
        }
    }

    @Override
    public void createMember(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member createMember(String email, String password, String nickname) {
        Member member = Member.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .nickname(nickname)
                .build();

        memberRepository.save(member);
        return member;
    }

}
