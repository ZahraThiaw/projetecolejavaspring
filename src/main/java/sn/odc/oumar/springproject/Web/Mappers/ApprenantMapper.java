package sn.odc.oumar.springproject.Web.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import sn.odc.oumar.springproject.Datas.Entity.Apprenant;
import sn.odc.oumar.springproject.Datas.Entity.User;
import sn.odc.oumar.springproject.Web.Dtos.Request.ApprenantDTO;
import sn.odc.oumar.springproject.Web.Dtos.Request.UserCreationDTO;

@Mapper
public interface ApprenantMapper {
    ApprenantMapper INSTANCE = Mappers.getMapper(ApprenantMapper.class);


    Apprenant toApprenant(ApprenantDTO apprenantDTO);

    User toUser(UserCreationDTO userDTO);
}
