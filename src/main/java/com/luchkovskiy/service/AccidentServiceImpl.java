package com.luchkovskiy.service;

import com.luchkovskiy.domain.Accident;
import com.luchkovskiy.repository.AccidentRepository;
import com.luchkovskiy.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class AccidentServiceImpl implements AccidentService {

    @Autowired
    AccidentRepository accidentRepository;
    @Autowired
    SessionRepository sessionRepository;

    @Override
    public Accident read(Long id) {
        if (!accidentRepository.checkIdValid(id))
            throw new RuntimeException();
        return accidentRepository.read(id);
    }

    @Override
    public List<Accident> readAll() {
        return accidentRepository.readAll();
    }

    @Override
    public Accident create(Accident object) {
        return accidentRepository.create(object);
    }

    @Override
    public Accident update(Accident object) {
        if (!accidentRepository.checkIdValid(object.getId()))
            throw new RuntimeException();
        return accidentRepository.update(object);
    }

    @Override
    public void delete(Long id) {
        if (!accidentRepository.checkIdValid(id))
            throw new RuntimeException();
        accidentRepository.delete(id);
    }

    @Override
    public boolean checkIdExist(Long id) {
        return accidentRepository.checkIdValid(id);
    }

    @Override
    public List<Accident> getAccidentsBySession(Long sessionId) {
        if (!sessionRepository.checkIdValid(sessionId))
            throw new RuntimeException();
        return accidentRepository.getAccidentsBySession(sessionId);
    }
}
