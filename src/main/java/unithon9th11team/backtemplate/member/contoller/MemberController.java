package unithon9th11team.backtemplate.member.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unithon9th11team.backtemplate.member.dto.request.SignInReqDto;
import unithon9th11team.backtemplate.member.dto.response.GetEmailAndAgeResDto;
import unithon9th11team.backtemplate.member.service.MemberService;
import unithon9th11team.backtemplate.response.DefaultRes;
import unithon9th11team.backtemplate.response.StatusCode;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("unithon/v1/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/sign-in")
    public ResponseEntity signIn(@RequestBody SignInReqDto signInReqDto) {
        Long id = memberService.addMember(signInReqDto);

        return new ResponseEntity(DefaultRes.res(StatusCode.OK, "회원가입 완료"), HttpStatus.OK);
    }

    @GetMapping("/email-and-age/{memberId}")
    public ResponseEntity signIn(@PathVariable("memberId") Long memberId) {
        GetEmailAndAgeResDto member = memberService.getEmailAndAge(memberId);

        return new ResponseEntity(DefaultRes.res(StatusCode.OK, "회원검색 완료", member), HttpStatus.OK);
    }

}
