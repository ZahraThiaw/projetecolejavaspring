package sn.odc.oumar.springproject.Services.Impl;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sn.odc.oumar.springproject.Services.Interfaces.ResponseService;
import sn.odc.oumar.springproject.Web.Dtos.Response.BaseResponse;

import java.util.List;

@Service
public class ResponseServiceImpl implements ResponseService {

    public <T> ResponseEntity<BaseResponse<T>> successResponse(T data, String message) {
        return buildResponse(data, message, HttpStatus.OK);
    }

    public <T> ResponseEntity<BaseResponse<T>> createdResponse(T data, String message) {
        return buildResponse(data, message, HttpStatus.CREATED);
    }

    @Override
    public <T> ResponseEntity<BaseResponse<T>> errorResponse(String message) {
        return  buildResponse( null,message, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<BaseResponse<Void>> deletedResponse(String message) {
        return buildResponse(null, message, HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<BaseResponse<Void>> notFoundResponse(String message) {
        return buildResponse(null, message, HttpStatus.NOT_FOUND);
    }


    private <T> ResponseEntity<BaseResponse<T>> buildResponse(T data, String message, HttpStatus status) {
        BaseResponse<T> response = new BaseResponse<>(status == HttpStatus.OK || status == HttpStatus.CREATED ? "success" : "error", message, data, status.value());
        return new ResponseEntity<>(response, status);
    }

}
