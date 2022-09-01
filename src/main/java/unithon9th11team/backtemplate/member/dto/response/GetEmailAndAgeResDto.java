package unithon9th11team.backtemplate.member.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetEmailAndAgeResDto {
    String email;
    int age;

    public GetEmailAndAgeResDto() {
    }

    @QueryProjection
    public GetEmailAndAgeResDto(String email, int age) {
        this.email = email;
        this.age = age;
    }
}
