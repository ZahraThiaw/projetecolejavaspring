package sn.odc.oumar.springproject.Services.Impl;

import org.springframework.stereotype.Service;
import sn.odc.oumar.springproject.Datas.Entity.User;
import sn.odc.oumar.springproject.Datas.Repository.Interfaces.BaseInterface;
import sn.odc.oumar.springproject.Datas.Repository.Interfaces.UserRepository;
import sn.odc.oumar.springproject.Services.Interfaces.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User,Long> implements UserService {
    protected UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

}
