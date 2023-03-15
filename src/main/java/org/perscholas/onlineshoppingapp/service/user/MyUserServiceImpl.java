package org.perscholas.onlineshoppingapp.service.user;

import org.perscholas.onlineshoppingapp.dao.MyUserRepository;
import org.perscholas.onlineshoppingapp.models.User.MyUser;
import org.springframework.stereotype.Service;

@Service
public class MyUserServiceImpl implements MyUserService{
    private final MyUserRepository myUserRepository;

    public MyUserServiceImpl(MyUserRepository myUserRepository) {
        this.myUserRepository = myUserRepository;
    }


    @Override
    public MyUser createOrUpdate(MyUser user) {

        return  myUserRepository.saveAndFlush(user);
    }



}
