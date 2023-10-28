package com.example.project;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
    MemberRepository memberRepository;

    @Transactional
    public void register(String name, String password, PasswordEncoder passwordEncoder) throws Exception{
        Member member = new Member();
        if( memberRepository.findByUsername(name) != null) throw new RuntimeException("member of that name already exist");
        member.setUsername(name);
        member.setPassword(passwordEncoder.encode(password));
        memberRepository.save(member);
    }

    public MemberAuthDTO getMember(String username) throws Exception{
        Member member= memberRepository.findByUsername(username);
        MemberAuthDTO memberAuthDTO = new MemberAuthDTO();
        memberAuthDTO.setUsername(member.getUsername());
        memberAuthDTO.setPassword(member.getPassword());
        return memberAuthDTO;
    }
}
