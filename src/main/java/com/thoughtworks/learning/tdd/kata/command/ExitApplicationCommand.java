package com.thoughtworks.learning.tdd.kata.command;

import com.thoughtworks.learning.tdd.kata.Application;

public class ExitApplicationCommand implements ApplicationCommand {
    @Override
    public void executeIn(Application application) {
        application.exit();
    }
}
