package sn.odc.oumar.springproject.Web.Dtos.Response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseResponse<T> {
    private String status;
    private String message;
    private T data;
    private int code;
}