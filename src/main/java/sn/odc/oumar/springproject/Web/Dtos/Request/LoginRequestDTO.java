package sn.odc.oumar.springproject.Web.Dtos.Request;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String email;
    private String password;

    // getters and setters
}