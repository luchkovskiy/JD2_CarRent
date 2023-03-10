package com.luchkovskiy.service;

import com.luchkovskiy.domain.Session;

public interface SessionService extends CRUDService<Long, Session> {

    boolean checkIdExist(Long id);
}
