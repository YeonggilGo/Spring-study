package practice.accountsExam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import practice.accountsExam.repository.JdbcMemberRepository;
import practice.accountsExam.repository.MemberRepository;
import practice.accountsExam.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}
