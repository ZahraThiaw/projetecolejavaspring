package sn.odc.oumar.springproject.Web.Controller.Interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import sn.odc.oumar.springproject.Datas.Entity.Promo;
import sn.odc.oumar.springproject.Web.Dtos.Request.PromotionRequestDTO;
import sn.odc.oumar.springproject.Web.Dtos.Response.BaseResponse;

public interface PromoControllerInterface {
    public ResponseEntity<BaseResponse<Promo>> create(@RequestBody PromotionRequestDTO requestDTO);
}
