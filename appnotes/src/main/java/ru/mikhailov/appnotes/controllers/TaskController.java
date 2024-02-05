package ru.mikhailov.appnotes.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.mikhailov.appnotes.model.Task;
import ru.mikhailov.appnotes.services.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;

    //Возвращает все задачи по get-запросу
    @GetMapping()
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    //Добавляет задачу. В теле необходимо указать "description". Остальные параметры присваиваются автоматически.
    @PostMapping ()
    public Task addTask(@RequestBody Task task){
        return taskService.addTask(task);
    }

    //Возвращает список задач по статусу, указанному в адресной строке
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable Task.TaskStatus status){
        return taskService.findTaskByStatus(status);
    }

    //Присваивает задаче новый статус. В адресной строке указать ID и новый статус. Сохраняет изменения в БД. Возвращает обновленную задачу
    @PutMapping("/status/{id}/{status}")
    public Task	updateTaskStatus(@PathVariable Long id, @PathVariable Task.TaskStatus status){
        return taskService.setTaskStatus(id, status);
    }

    //Удаляет задачу по ID
    @DeleteMapping("/delete/{id}")
    public void deleteTaskById(@PathVariable Long id){
        taskService.deleteTask(id);
    }




}
