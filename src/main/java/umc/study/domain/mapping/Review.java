package umc.study.domain.mapping;


import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.common.Member;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "body", length = 500)
    private String body;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false) // 외래키로 설정
    private Member member; // Member 객체를 참조



    @ManyToOne // Store와의 다대일 관계 설정
    @JoinColumn(name = "store_id", nullable = false)
    private Store store; // store라는 필드가 필요

    @Column(name = "score", nullable = false)
    private float score;
}
