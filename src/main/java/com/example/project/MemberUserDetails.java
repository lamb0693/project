package com.example.project;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class MemberUserDetails implements UserDetails {
    String username;
    String password;
    //username과 password 이외의 Authentication Principal 사용시 필요한
    // 변수 선언 후 Getter Setter 설정
    // role 설정 - 필수?
    Collection<? extends GrantedAuthority> authorities;

    public MemberUserDetails(MemberAuthDTO memberAuthoDTO){
        this.username = memberAuthoDTO.getUsername();
        this.password = memberAuthoDTO.getPassword();
        //기타 설정
        //role은  설정 필수?
        // member table에 role 이 없으므로 ROLE_USER 로 설정함
        ArrayList<SimpleGrantedAuthority> authCol = new ArrayList<>();
        authCol.add (new SimpleGrantedAuthority("ROLE_USER") );
        this.authorities = authCol;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
