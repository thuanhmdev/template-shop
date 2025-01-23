package com.templateshop.templateshop.dto;

import com.templateshop.templateshop.support.validation.RegisterChecked;
import com.templateshop.templateshop.support.validation.StrongPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@RegisterChecked
public class RegisterDTO {

    @NotNull
    @Size(min = 3, message = "FirstName phải có tối thiểu 3 ký tự")
    private String fullName;

    @NotNull
    @Email(message = "Email không hợp lệ", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;

    @StrongPassword
    private String password;
    private String confirmPassword;
}
