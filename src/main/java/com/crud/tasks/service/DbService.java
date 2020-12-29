package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DbService {
    @Autowired
    private TaskRepository repository;

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task getTaskById(Long aLong) {
        try {
            return repository.findById(aLong).get();
        } catch (NoSuchElementException e) {
            System.out.println(e + " occurs while trying get Task by the ID.");
        }
        return null;
    }

//                    Optional<Task> taskOptional = Optional.ofNullable(repository.findById(aLong).get());
//            return taskOptional.get();
//        } catch (NoSuchElementException e) {
//            System.out.println(e);
//        }

    //utwórz metodę pobierającą zadania przy użyciu id zadania

}
