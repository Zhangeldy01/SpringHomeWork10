package com.example.SpringHomeWork10.services;

import com.example.SpringHomeWork10.models.Act;
import com.example.SpringHomeWork10.repositories.ActRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceImplement implements ActService {
    private final ActRepository actRepository;

    /**
     * Метод получения списка всех задач
     *
     * @return список заметок
     */
    @Override
    public List<Act> getAllActs() {
        return actRepository.findAll();
    }

    /**
     * Метод сохранения заметки
     *
     * @param act новая заметка
     * @return сохраненная заметка
     */
    @Override
    public Act createAct(Act act) {
        return actRepository.save(act);
    }

    /**
     * Метод получения заметки по id
     *
     * @param id id заметки
     * @return искомая заметка
     */
    @Override
    public Act getActById(Long id) {
        return actRepository.findById(id).orElseThrow(null);
    }

    /**
     * Метод изменения заметки по id
     *
     * @return обновленная заметка
     */
    @Override
    public Act updateAct(Act act) {
        return actRepository.save(act);
    }

    /**
     * Метод удаления заметки по id
     *
     * @param id id заметки
     */
    @Override
    public void deleteAct(Long id) {
        Act actById = getActById(id);
        actRepository.delete(actById);
    }

    @Override
    public List<Act> findActByReportingPeriod(String reportingPeriod){
        return actRepository.findActByReportingPeriod(reportingPeriod);
    }

}
