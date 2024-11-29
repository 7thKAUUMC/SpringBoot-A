package umc.spring.converter.Member;

import org.springframework.data.domain.Page;
import umc.spring.converter.Store.StoreMissionConverter;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.domain.mapping.StoreMission;
import umc.spring.web.dto.Member.MemberResponseDTO;
import umc.spring.web.dto.Store.StoreResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MemberMissionConverter {

    public static MemberResponseDTO.MissionPreViewDTO missionPreViewDTO(MemberMission memberMission) {
        String ownerNickname = memberMission.getMember() != null ? memberMission.getMember().getName() : "Unknown";

        return MemberResponseDTO.MissionPreViewDTO.builder()
                .ownerNickname(ownerNickname)
                .createdAt(memberMission.getCreatedAt().toLocalDate())
                .description(memberMission.getMission().getDescription())
                .status(memberMission.getStatus())
                .build();
    }

    public static MemberResponseDTO.MissionPreViewListDTO missionPreViewListDTO(Page<MemberMission> missionList){

        List<MemberResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(MemberMissionConverter::missionPreViewDTO).collect(Collectors.toList());

        return MemberResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }

}
