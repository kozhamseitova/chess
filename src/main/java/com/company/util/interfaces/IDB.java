package com.company.util.interfaces;

import com.company.models.User;

import java.util.HashMap;


public interface IDB<T>{

    User getUserByEmail(String email);
}
