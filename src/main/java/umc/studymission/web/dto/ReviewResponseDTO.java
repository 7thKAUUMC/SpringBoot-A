package umc.studymission.web.dto;

import lombok.Getter;
import lombok.Setter;
import umc.studymission.domain.Store;
import umc.studymission.domain.User;

@Getter
@Setter
public class ReviewResponseDTO {
    private Long id;
    private int rating;
    private String content;
    private Long user;
    private Long store;

    public ReviewResponseDTO(Long id, int rating, String content, User user, Store store) {
        this.id = id;
        this.rating = rating;
        this.content = content;
        this.user = user.getId();  // user 객체 대신 userId만 포함
        this.store = store.getId();  // store 객체 대신 storeId만 포함
    }
}