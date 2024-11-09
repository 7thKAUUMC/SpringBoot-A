package umc.study.domain;

import lombok.*;
import jakarta.persistence.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.UserStatus;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phone_num", length = 15)
    private String phoneNum;

    @Column(length = 30, nullable = false, unique = true)
    private String email;

    @Column(length = 20, nullable = false, unique = true)
    private String nickname;

    @Column(length = 20, nullable = false)
    private String password;

    @Column(length = 10, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'", nullable = false)
    private UserStatus status;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(1)")
    private Gender gender;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(length = 225)
    private String address;

    @Builder.Default
    @Column(name = "total_point", nullable = false)
    private Long totalPoint = 0L;
}
