package sn.odc.oumar.springproject.Services.Interfaces;

import sn.odc.oumar.springproject.Datas.Entity.Promo;
import sn.odc.oumar.springproject.Web.Dtos.Request.PromotionRequestDTO;

import java.util.Optional;


public interface PromoService extends BaseService<Promo, Long> {
    public boolean promoExists(String libelle);

}
