package com.example.modiraa.loginAndRegister.service;

import com.example.modiraa.loginAndRegister.auth.UserDetailsImpl;
import com.example.modiraa.loginAndRegister.dto.LoginIdCheckDto;
import com.example.modiraa.loginAndRegister.dto.SignupRequestDto;
import com.example.modiraa.loginAndRegister.model.Member;
import com.example.modiraa.loginAndRegister.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    // 회원가입
    public String registerUser(SignupRequestDto requestDto) {
        String error = "";
        String username = requestDto.getUsername();
        String password = requestDto.getPassword();
        String profileImage = requestDto.getUserProfile();
        String oauth = requestDto.getOauth();
        String passwordCheck = requestDto.getPasswordCheck();
        String nickname = requestDto.getNickname();
        String pattern = "^[a-zA-Z0-9]*$";

        System.out.println(username);

        // 회원 ID 중복 확인
        Optional<Member> found = userRepository.findByUsername(username);
        if (found.isPresent()) {
            return "중복된 id 입니다.";
        }

        Optional<Member> founds = userRepository.findByNickname(nickname);
        if (founds.isPresent()) {
            return "중복된 nickname 입니다.";
        }

        // 회원가입 조건
        if (username.length() < 3) {
            return "아이디를 3자 이상 입력하세요";
        } else if (!Pattern.matches(pattern, username)) {
            return "알파벳 대소문자와 숫자로만 입력하세요";
        } else if (password.length() < 3) {
            return "비밀번호를 4자 이상 입력하세요";
        } else if (password.contains(username)) {
            return "비밀번호에 아이디를 포함할 수 없습니다.";
        }else if (password == null) {
            return "비밀번호를 입력해 주세요.";
        }
        if (!password.equals(passwordCheck)) {
            return "비밀번호가 일치하지 않습니다";
        }



        // 패스워드 인코딩
        password = passwordEncoder.encode(password);
        requestDto.setPassword(password);

        // 유저 정보 저장
        Member member = new Member(username, password, profileImage, nickname);
        userRepository.save(member);
        return error;
    }

    //로그인 유저 정보 반환
    public LoginIdCheckDto userInfo(UserDetailsImpl userDetails) {
        String username = userDetails.getUsername();
        String usernickname = userDetails.getMember().getNickname();
        LoginIdCheckDto userinfo = new LoginIdCheckDto(username, usernickname);
        return userinfo;
    }
}