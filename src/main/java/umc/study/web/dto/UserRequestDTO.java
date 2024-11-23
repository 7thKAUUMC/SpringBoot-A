package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.study.validation.annotation.ExistCategories;


import java.util.Date;
import java.util.List;

public class UserRequestDTO {

    @Getter
    public static class JoinDto {
        @Size(min = 5, max = 12)
        private String phoneNum;
        @NotNull
        private String email;
        @NotNull
        private String nickname;
        @NotNull
        private String password;
        @NotBlank
        private String name;
        @NotNull
        private Integer gender;
        @Size(min = 5, max = 12)
        private Date birthday;
        @Size(min = 5, max = 12)
        private String address;
        @ExistCategories
        List<Long> preferCategory;
    }
}
