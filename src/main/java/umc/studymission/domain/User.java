package umc.studymission.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.studymission.domain.common.BaseEntity;
import umc.studymission.domain.enums.MemberStatus;
import umc.studymission.domain.mapping.Point;

import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String username;

//    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(nullable = false, length = 60)  // 보안상 해시된 비밀번호를 저장
    private String password;

    @Column(length = 200) // 좋아하는 항목의 리스트 (선택 항목이므로 nullable 설정 생략)
    private String likes;

    @Column(length = 15, unique = true)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus status;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mission> missions;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Point> points;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Notification> notifications;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inquiry> inquiries;

    // 암호화된 비밀번호를 설정하는 메서드 추가
    public void setPassword(String password) {
        this.password = password; // 암호화된 비밀번호를 저장하도록
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                '}';
    }
}
