package com.ycsoft.aop;

public interface SecurityService {
    boolean checkAccess(User user, String service);
}
