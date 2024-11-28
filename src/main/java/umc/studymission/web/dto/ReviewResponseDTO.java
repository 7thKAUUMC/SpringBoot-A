package umc.studymission.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import umc.studymission.domain.Store;
import umc.studymission.domain.User;

@Getter
@Setter
@Builder
public class ReviewResponseDTO {
    private Long id;
    private int rating;
    private String content;
    private Long user;
    private Long store;

    public ReviewResponseDTO(Long id, int rating, String content, Long userId, Long storeId) {
        this.id = id;
        this.rating = rating;
        this.content = content;
        this.user = userId;
        this.store = storeId;
    }
}