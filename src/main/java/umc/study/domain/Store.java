package umc.study.domain;

import jakarta.persistence.*; // JPA 관련 어노테이션
import jakarta.validation.constraints.NotNull;
import lombok.*; // Lombok 관련 어노테이션
import umc.study.domain.common.BaseEntity;

import java.net.CookieStore;

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
