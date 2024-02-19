package ru.mikhailov.appnotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*


Cоздать приложение для управления списком задач с использованием Spring Boot и Spring Data JPA. Требуется реализовать следующие функции:

Добавление задачи. Подсказка метод в контроллере:
Просмотр всех задач. Подсказка метод в контроллере:
Просмотр задач по статусу (например, "завершена", "в процессе", "не начата"). Подсказка метод в контроллере:
Изменение статуса задачи. Подсказка метод в контроллере:
Удаление задачи.

 */
@SpringBootApplication
public class AppnotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppnotesApplication.class, args);
	}

}
