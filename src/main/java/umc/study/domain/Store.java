package umc.study.domain;

import jakarta.persistence.*; // JPA 관련 어노테이션
import lombok.*; // Lombok 관련 어노테이션
import umc.study.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private Float score;
}
