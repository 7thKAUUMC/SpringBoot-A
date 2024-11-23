package umc.study.domain;

import lombok.*;
import jakarta.persistence.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.UserStatus;

import java.util.Date;
import java.util.List;

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
    @Column(nullable = false)
    private UserStatus status; // 서버에서 자동으로 설정

    @Enumerated(EnumType.ORDINAL) // Enum의 순서를 저장
    @Column(columnDefinition = "TINYINT") // MySQL의 작은 정수 타입 사용
    private Gender gender;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(length = 225)
    private String address;

    @Column(name = "total_point", nullable = false)
    private Long totalPoint = 0L;

    @PrePersist
    protected void onCreate() {
        if (this.status == null) {
            this.status = UserStatus.ACTIVE; // 기본값 설정
        }
        if (this.totalPoint == null) {
            this.totalPoint = 0L; // 기본값 설정
        }
    }

}
