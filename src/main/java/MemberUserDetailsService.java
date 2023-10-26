import com.example.project.MemberAuthDTO;
import com.example.project.MemberService;
import com.example.project.MemberUserDetails;
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
    private MemberService memberService
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if( username == null) log.error("*** loadUserByUsername@MMemberUserDetailsService :  username null" );
        else if( username.isEmpty()) log.error("*** loadUserByUsername@MemberUserDetailsService :  username Empty" );

        log.info("*** loadUserByUsername@MemberUserDetailsService :  username : {}", username );

        MemberAuthDTO memberAuthDTO = memberService.getMember(username);

        if(memberAuthDTO == null) throw new UsernameNotFoundException("No User with such username");

        MemberUserDetails memberUserDetails = new MemberUserDetails(memberAuthDTO);
        log.info("*****" + memberUserDetails.toString());

        return memberUserDetails;
    }
}
