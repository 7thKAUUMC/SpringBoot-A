package umc.studytm.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.studytm.domain.common.BaseEntity;
import umc.studytm.domain.common.Member;

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

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false) // 외래키로 설정
    private Member member; // Member 객체를 참조

    @Column(name = "store_id", nullable = false)
    private Long store_id;

    @Column(name = "body", length = 500)
    private String body;

    @Column(name = "score", nullable = false)
    private float score;
}
