package ru.sberbank.homework.bobrov.terminal.exception;


/**
 * Task terminal.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 19.02.2018
 */


public class NotEnoughMoney extends RuntimeException {
    public NotEnoughMoney(String message) {
        super(message);
    }
}