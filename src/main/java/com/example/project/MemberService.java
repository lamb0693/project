package com.example.project;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberService {
    PasswordEncoder passwordEncoder;
    MemberRepository memberRepository;

    public void register(String name, String password) throws Exception{
        Member member = new Member();
        member.setUsername(name);
        member.setPassword(passwordEncoder.encode(password));
        memberRepository.save(member);
    }

    public MemberAuthDTO getMember(String username) {
        Member member= memberRepository.findByUsername();

    }
}
