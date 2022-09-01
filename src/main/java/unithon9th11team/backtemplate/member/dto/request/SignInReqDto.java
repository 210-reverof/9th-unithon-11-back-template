package unithon9th11team.backtemplate.member.dto.request;

import lombok.Getter;

@Getter
public class SignInReqDto {
    private String email;
    private String password;
    private String nick;
    private int age;
}
