package sn.odc.oumar.springproject.Web.Controller.Impl;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.odc.oumar.springproject.Datas.Entity.User;
import sn.odc.oumar.springproject.Services.Interfaces.UserService;
import sn.odc.oumar.springproject.Web.Controller.BaseControllerImpl;
import sn.odc.oumar.springproject.Web.Controller.Interfaces.UserControllerInterface;
import sn.odc.oumar.springproject.Web.Dtos.Request.UserCreationDTO;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "Users", description = "API pour gérer les users")
public class UserControllerImpl extends BaseControllerImpl<User, UserCreationDTO,Long> implements UserControllerInterface {

    @Autowired
    public UserControllerImpl(UserService userService) {
        super(userService);
    }


    @Override
    protected User convertToEntity(UserCreationDTO userCreationDTO) {
        return null;
    }

    @Override
    protected UserCreationDTO convertToDto(User entity) {
        return null;
    }
}
