package unithon9th11team.backtemplate.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import unithon9th11team.backtemplate.member.dto.request.SignInReqDto;
import unithon9th11team.backtemplate.member.dto.response.GetEmailAndAgeResDto;
import unithon9th11team.backtemplate.member.entity.Member;
import unithon9th11team.backtemplate.member.repository.MemberRepository;
import unithon9th11team.backtemplate.member.repository.MemberRepositorySupport;

@Service
@Component
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final MemberRepositorySupport memberRepositorySupport;

    public Long addMember(SignInReqDto signInReqDto) {
        long id = memberRepository.save(Member.builder()
                .email(signInReqDto.getEmail())
                .password(signInReqDto.getPassword())
                .nick(signInReqDto.getNick())
                .age(signInReqDto.getAge())
                .build()).getId();

        return id;
    };

    public GetEmailAndAgeResDto getEmailAndAge(Long id) {
        return memberRepositorySupport.getEmailAndAgeById(id);
    }
}


