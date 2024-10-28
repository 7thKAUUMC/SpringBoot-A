package umc.study.domain;

import jakarta.persistence.*; // JPA 관련 어노테이션
import lombok.*; // Lombok 관련 어노테이션
import umc.study.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Float score;

    @ManyToOne // Member와의 다대일 관계 설정
    @JoinColumn(name = "member_id") // 외래 키 이름을 지정
    private Member member;
}
