package com.example.project;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

public interface MemberService {
    public void register(String name, String password, PasswordEncoder passwordEncoder) throws Exception;

    public MemberAuthDTO getMember(String username);
}
