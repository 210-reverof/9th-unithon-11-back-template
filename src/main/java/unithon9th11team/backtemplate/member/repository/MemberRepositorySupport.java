package unithon9th11team.backtemplate.member.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import unithon9th11team.backtemplate.member.dto.response.GetEmailAndAgeResDto;
import unithon9th11team.backtemplate.member.entity.Member;
import unithon9th11team.backtemplate.member.entity.QMember;
import java.util.*;

@Repository
public class MemberRepositorySupport extends QuerydslRepositorySupport  {
    private final JPAQueryFactory jpaQueryFactory;

    public MemberRepositorySupport(JPAQueryFactory jpaQueryFactory) {
        super(Member.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public GetEmailAndAgeResDto getEmailAndAgeById(Long id) {
        QMember m = QMember.member;

        List<GetEmailAndAgeResDto> members = jpaQueryFactory.select(Projections.bean(GetEmailAndAgeResDto.class, m.email, m.age))
                .from(m)
                .where(m.id.eq(id))
                .fetch();

        return members.get(0);
    }
}
