package com.gcu.business;

import com.gcu.models.LoginModel;

public interface SecurityServiceInterface {
    
    public boolean isAuthenticated(LoginModel model);
    public boolean isTaken(LoginModel model);
    public int addOne(LoginModel newUser);
}
