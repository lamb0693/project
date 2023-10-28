package com.example.project;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Log4j2
public class MemberUserDetailsService implements UserDetailsService {
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if( username == null) log.error("*** loadUserByUsername@MMemberUserDetailsService :  username null" );
        else if( username.isEmpty()) log.error("*** loadUserByUsername@MemberUserDetailsService :  username Empty" );

        log.info("*** loadUserByUsername@MemberUserDetailsService :  username : {}", username );

        Member member = memberRepository.findByUsername(username);
        if(member == null) throw new UsernameNotFoundException("user name does not exist");

        MemberAuthDTO memberAuthDTO = new MemberAuthDTO();
        memberAuthDTO.setUsername(member.getUsername());
        memberAuthDTO.setPassword(member.getPassword());

        MemberUserDetails memberUserDetails = new MemberUserDetails(memberAuthDTO);
        log.info("*****" + memberUserDetails.toString());

        return memberUserDetails;
    }
}
