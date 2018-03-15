package com.thoughtworks.learning.tdd.kata.command;

import com.thoughtworks.learning.tdd.kata.Application;

public class PlayApplicationCommand implements ApplicationCommand {
    private final String cellCoordinates;

    public PlayApplicationCommand(String cellCoordinates) {
        this.cellCoordinates = cellCoordinates;
    }

    @Override
    public void executeIn(Application application) {
        application.getGame().playIn(cellCoordinates);
    }
}
