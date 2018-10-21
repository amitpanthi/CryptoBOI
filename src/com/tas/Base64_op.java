package com.tas;

import java.util.Base64;

public class Base64_op
{
    public String encryption(String str)
    {
        String crypt = Base64.getEncoder().withoutPadding().encodeToString(str.getBytes());
        return crypt;
    }
}