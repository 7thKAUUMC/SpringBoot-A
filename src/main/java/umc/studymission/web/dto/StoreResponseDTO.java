package umc.studymission.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreResponseDTO {
    private Long id;
    private String name;
    private String region;

    public StoreResponseDTO(Long id, String name, String region) {
        this.id = id;
        this.name = name;
        this.region = region;
    }
}