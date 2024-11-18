package umc.study.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // 주 키에 대한 컬럼 이름 설정
    private Long id;

    private String name;

    private String address;

    private float score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id") // 외래 키를 정의
    private Region region;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Mission> missionList = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @Override
    public String toString() {
        return "Store{" +
                "storeId=" + id + // storeId로 변경
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", score=" + score +
                ", region=" + (region != null ? region.getName() : "N/A") + // region의 이름 출력
                '}';
    }

    // 추가 필드가 필요하다면 아래 주석을 해제
    // @Column(name = "location", length = 100)
    // private String location;

    // @Column(name = "store_info", length = 500)
    // private String storeInfo;
}
