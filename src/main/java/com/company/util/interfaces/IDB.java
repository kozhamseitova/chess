package com.company.util.interfaces;

import com.company.models.Messages;
import com.company.models.User;

import java.util.ArrayList;
import java.util.HashMap;


public interface IDB<T>{

    User getUserByEmail(String email);
}
