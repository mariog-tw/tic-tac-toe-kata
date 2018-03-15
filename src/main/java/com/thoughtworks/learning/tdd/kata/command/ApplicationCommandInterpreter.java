package com.thoughtworks.learning.tdd.kata.command;

public class ApplicationCommandInterpreter {
    private ApplicationCommandInterpreter() { }

    public static ApplicationCommandInterpreter create() {
        return new ApplicationCommandInterpreter();
    }

    public ApplicationCommand interpret(String command) {
        if ("exit".equalsIgnoreCase(command)) {
            return new ExitApplicationCommand();
        } else if ("new".equalsIgnoreCase(command)) {
            return new NewGameApplicationCommand();
        } else {
            return new PlayApplicationCommand(command);
        }
    }
}
