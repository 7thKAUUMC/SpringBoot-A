package umc.study.convert;

import umc.study.domain.Member;
import umc.study.domain.mapping.MemberMission;
import java.util.List;
import java.util.stream.Collectors;

public class MemberMissionConverter {

    public static List<MemberMission> toMemberMissionList(List<Member> memberList){

        return memberList.stream()
                .map(member ->
                        MemberMission.builder()
                                .member(member)
                                .build()
                ).collect(Collectors.toList());
    }
}
