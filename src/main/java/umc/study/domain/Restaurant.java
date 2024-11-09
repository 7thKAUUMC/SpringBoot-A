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

    @Column(length = 10, nullable = false)
    private String name;

    @Column(length = 225, nullable = false)
    private String address;

    @Column(name = "phone_num", length = 15)
    private String phoneNum;

    @Column(name = "total_rating")
    private Float totalRating;

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", score=" + totalRating +
                '}';
    }
}
