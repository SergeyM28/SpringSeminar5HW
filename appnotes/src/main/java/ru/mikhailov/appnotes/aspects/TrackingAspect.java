package ru.mikhailov.appnotes.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/*
Базовое задание:
Домашнее задание выполнить для одного из пройденных семинаров в проекте с Базой Данных.
Вам необходимо разработать механизм регистрации действий пользователя в вашем Spring Boot приложении. Используйте Spring AOP
для создания журнала действий, в котором будет сохраняться информация о том, какие методы сервиса вызывались, кем и с какими параметрами.

Создайте аннотацию @TrackUserAction.
Реализуйте aspect, который будет регистрировать действия пользователя, когда вызывается метод, отмеченный этой аннотацией.
Примените аннотацию @TrackUserAction к нескольким методам в слое сервиса.
Результаты регистрации в консоль
 */

@Aspect
@Component
public class TrackingAspect {

    private Logger logger = Logger.getLogger(TrackingAspect.class.getName());

    @AfterReturning(value = "@annotation(TrackUserAction)", returning = "returnedValue")
    public void log(Object returnedValue) {
        logger.info("Activity tracked -> " + returnedValue);
    }
}
