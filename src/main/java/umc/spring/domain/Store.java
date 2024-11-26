package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;

import umc.spring.domain.Enums.*;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.domain.mapping.StoreMission;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private String name;

    @Column(nullable = false, length = 40)
    private String address;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<StoreMission> storeMissionList = new ArrayList<>();

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +'}';
    }
}