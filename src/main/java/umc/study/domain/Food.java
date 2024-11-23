package umc.study.domain;

import lombok.*;
import jakarta.persistence.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.FoodType;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Food extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private FoodType type;

    @Column(nullable = false)
    private String name;
}
