package umc.study.domain.mapping;

import jakarta.persistence.*; // JPA 관련 어노테이션
import lombok.*; // Lombok 관련 어노테이션
import umc.study.domain.common.BaseEntity;
import umc.study.domain.Member; // Member 엔티티 import
import umc.study.domain.Mission; // Mission 엔티티 import

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

    @ManyToOne // Member와의 다대일 관계 설정
    @JoinColumn(name = "member_id") // 외래 키 이름 설정
    private Member member; // Member와의 연관 관계 추가

    @ManyToOne // Mission과의 다대일 관계 설정
    @JoinColumn(name = "mission_id") // 외래 키 이름 설정
    private Mission mission; // Mission과의 연관 관계 추가
}
