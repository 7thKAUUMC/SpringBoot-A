package umc.spring.converter.Member;

import umc.spring.domain.Enums.Gender;
import umc.spring.domain.Member;
import umc.spring.web.dto.Member.MemberRequestDTO;
import umc.spring.web.dto.Member.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .gender(gender)
                .password(request.getPassword())
                .email(request.getEmail())
                .name(request.getName())
                .memberPreferList(new ArrayList<>())
                .build();
    }
}