package umc.study.domain;

import umc.study.domain.common.BaseEntity;
import jakarta.persistence.*; // JPA 관련 어노테이션
import lombok.*; // Lombok 관련 어노테이션

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FoodCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


}
