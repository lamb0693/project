package com.example.project;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@Log4j2
public class HomeController {
    MemberService memberService;
    PasswordEncoder passwordEncoder;

    @GetMapping(value="/")
    @ResponseBody
    public ResponseEntity<ResultDTO> getTest(){
        ResultDTO resultDTO = new ResultDTO("Hello world");

        return ResponseEntity.ok().body(resultDTO);
    }

    @PostMapping(value="/signon")
    @ResponseBody
    public ResponseEntity<ResultDTO> register(@RequestParam String username, @RequestParam String password){
        try{
            memberService.register(username, password, passwordEncoder);
            return ResponseEntity.ok().body(new ResultDTO("success"));
        } catch (Exception e) {
            log.error(">>>> register@HomeController : Exception : {}", e.getMessage());
            return ResponseEntity.badRequest().body(new ResultDTO(e.getMessage()));
        }
    }

    @GetMapping("/secured")
    @ResponseBody
    public ResponseEntity<ResultDTO> displaySecured(){
        return ResponseEntity.ok().body(new ResultDTO("secured Page"));
    }
}
