package sn.odc.oumar.springproject.Services.Interfaces;

import org.springframework.http.ResponseEntity;
import sn.odc.oumar.springproject.Web.Dtos.Response.BaseResponse;

public interface ResponseService {

    <T> ResponseEntity<BaseResponse<T>> successResponse(T data, String message);

    <T> ResponseEntity<BaseResponse<T>> createdResponse(T data, String message);

    <T> ResponseEntity<BaseResponse<T>> deletedResponse(String message);

    <T> ResponseEntity<BaseResponse<T>> notFoundResponse(String message);

    <T> ResponseEntity<BaseResponse<T>> errorResponse(String message);
}
