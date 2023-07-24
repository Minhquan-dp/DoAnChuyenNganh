package com.example.client_cinemaproject.models;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;
//@NotBlank check nếu trống thì báo lỗi
//@Size check min size
@Data
public class User {
    @NotBlank(message = "Không được để trống email!")
    @Email(message = "Bạn cần nhập email hợp lệ!")
    private String username;

    @NotBlank(message = "Không được để trống mật khẩu!")
    @Size(min=6,message = "Mật khẩu phải có ít nhất 6 ký tự")
    private String password;

    @NotBlank(message = "Không được để trống họ tên!")
    private String fullName;

    private Set<Role> roles;
}