package ru.mikhailov.appnotes.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mikhailov.appnotes.aspects.TrackUserAction;
import ru.mikhailov.appnotes.model.Task;
import ru.mikhailov.appnotes.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;


@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;


    //Возвращает все задачи, добавленные в БД
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    //Создание задачи. Статус при создании всегда "TO_DO". Текущие дата и время присваиваются автоматически
    @TrackUserAction
    public Task addTask (Task task){
        task.setCreationTime(LocalDateTime.now());
        task.setStatus(Task.TaskStatus.TO_DO);
        return taskRepository.save(task);
    }

    //Возвращает список задач по статусу
    public List<Task> findTaskByStatus(Task.TaskStatus status){
        return taskRepository.findByStatus(status);
    }

    //Присваивает задаче новый статус. Сохраняет изменения в БД. Возвращает обновленную задачу
    @TrackUserAction
    public Task setTaskStatus(Long id, Task.TaskStatus status){
        Task taskToUpdate = taskRepository.findById(id).get();
        taskToUpdate.setStatus(status);
        taskRepository.save(taskToUpdate);
        return taskToUpdate;
    }


    //Удаляет задачу по ID. Возвращает строку с описанием события для отображения в аспекте
    @TrackUserAction
    public String deleteTask(Long id){
        taskRepository.deleteById(id);
        return "Task " + id + " deleted";
    }

}
