package umc.study.domain.mapping;


import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.ENUM.MissionStatus;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.common.Member;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "mission_id")
    private Mission mission;

}