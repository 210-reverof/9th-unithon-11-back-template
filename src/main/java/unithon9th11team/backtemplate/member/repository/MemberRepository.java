package unithon9th11team.backtemplate.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unithon9th11team.backtemplate.member.entity.Member;

import javax.transaction.Transactional;
import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsById(Long Id);

    Optional<Member> findById(Long Id);

    @Transactional
    void deleteById(Long Id);
}
