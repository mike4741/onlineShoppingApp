package org.perscholas.onlineshoppingapp.service.user;

import org.perscholas.onlineshoppingapp.dao.MyUserRepository;
import org.perscholas.onlineshoppingapp.models.User.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserServiceImpl implements MyUserService{
    private final MyUserRepository myUserRepository;
@Autowired
    public MyUserServiceImpl(MyUserRepository myUserRepository) {
        this.myUserRepository = myUserRepository;
    }


//    @Override
//    public MyUser updatePassword(String email, MyUser myUser) {
//      MyUser myUser1= myUserRepository.findByEmailAllIgnoreCase(email).get();
//            myUser1.setPassword(myUser.getPassword());
//
//        return myUserRepository.save(myUser1);
//    }

    @Override
    public MyUser createOrUpdate(MyUser user) {

        return  myUserRepository.saveAndFlush(user);
    }



}
