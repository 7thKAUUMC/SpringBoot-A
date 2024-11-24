package umc.study.domain;

import lombok.*;
import jakarta.persistence.*;
import umc.study.domain.common.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Restaurant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "restaurant_name", length = 50, nullable = false)
    private String restaurantName;

    @Column(length = 255, nullable = false)
    private String address;

    @Column(name = "phone_number", length = 20, nullable = false)
    private String phoneNumber;

    @Column(length = 30, nullable = false)
    private String category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;

    @PrePersist
    protected void onCreate() {
        // 추가적인 필드 초기화가 필요하면 여기서 처리
    }
}
