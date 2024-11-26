package umc.spring.web.dto.Member;

import lombok.Getter;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDto{
        String name;
        Integer gender;
        String password;
        String email;
        String address;
        List<Long> preferCategory;
    }
}