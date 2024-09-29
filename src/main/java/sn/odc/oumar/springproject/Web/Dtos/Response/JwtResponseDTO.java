package sn.odc.oumar.springproject.Web.Dtos.Response;

import lombok.Data;

@Data
public class JwtResponseDTO {
    private String token;

    public JwtResponseDTO(String token) {
        this.token = token;
    }

}