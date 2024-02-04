package com.gcu.data;

import com.gcu.models.LoginModel;

public interface RegistrationDataInterface {
    public boolean isAuthenticated(LoginModel model);
    public boolean isTaken(LoginModel model);
    public int addOne(LoginModel newUser);
}
