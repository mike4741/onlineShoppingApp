package org.perscholas.onlineshoppingapp.service.user;

import org.perscholas.onlineshoppingapp.models.User.MyUser;

public interface MyUserService {
    MyUser createOrUpdate(MyUser user);
}
