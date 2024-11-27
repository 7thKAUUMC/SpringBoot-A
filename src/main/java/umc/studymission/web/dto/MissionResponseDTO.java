package umc.studymission.web.dto;

import lombok.Getter;
import lombok.Setter;
import umc.studymission.domain.Store;
import umc.studymission.domain.User;
import umc.studymission.domain.enums.MissionStatus;

@Getter
@Setter
public class MissionResponseDTO {
    private Long id;
    private String title;
    private String description;
    private MissionStatus status;
    private int pointEarned;
    private Store store;
    private User user;

    public MissionResponseDTO(Long id, String title, String description, MissionStatus status, int pointEarned, Store store, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.pointEarned = pointEarned;
        this.store = store;
        this.user = user;
    }
}