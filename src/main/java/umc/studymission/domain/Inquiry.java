package umc.studymission.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.studymission.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Inquiry extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Override
    public String toString() {
        return "Inquiry{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", user=" + (user != null ? user.getUsername() : "N/A") +
                '}';
    }
}
