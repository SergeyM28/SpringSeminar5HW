package ru.mikhailov.appnotes.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tasks")
@NoArgsConstructor

public class Task {
    //Уникальный ID генерируется автоматически
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //Текстовое описание задачи вводит пользователь при создании
    @Column(nullable = false)
    public String description;

    //Статус задачи. 3 варианта в перечислении
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    //Дата и время создания задачи
    @Column(nullable = false)
    private LocalDateTime creationTime;

    public enum TaskStatus {
        TO_DO,
        IN_PROGRESS,
        DONE
    }
}
