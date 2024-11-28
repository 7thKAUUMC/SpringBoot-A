package umc.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.MemberHandler;
import umc.study.convert.MemberMissionConverter;
import umc.study.convert.MissionConverter;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;
import umc.study.domain.mapping.MissionStatus;
import umc.study.repository.MemberRepository;
import umc.study.repository.MissionRepository;
import umc.study.web.dto.MissionRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{

    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;

    @Override
    public Mission joinMission(MissionRequestDTO.MRegisterDTO request) {
        Mission newMission = MissionConverter.toMission(request);
        List<Member> memberList = request.getMember_id().stream()
                .map(member -> {
                    return memberRepository.findById(member).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberMission> memberMissionList = MemberMissionConverter.toMemberMissionList(memberList);

        memberMissionList.forEach(memberMission -> {memberMission.setMission(newMission);});

        return missionRepository.save(newMission);
    }

    @Override
    public void updateMissionStatus(Long missionId, MissionStatus status) {
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new RuntimeException("Mission not found"));

        mission.getMemberMissionList().forEach(memberMission -> {
            memberMission.setStatus(status); // 상태 업데이트
        });

        missionRepository.save(mission); // 상태 변경 저장
    }
}