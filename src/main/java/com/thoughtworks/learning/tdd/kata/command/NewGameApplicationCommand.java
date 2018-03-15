package com.thoughtworks.learning.tdd.kata.command;

import com.thoughtworks.learning.tdd.kata.Application;
import com.thoughtworks.learning.tdd.kata.Game;

public class NewGameApplicationCommand implements ApplicationCommand {
    @Override
    public void executeIn(Application application) {
        application.setGame(Game.newGame());
    }
}
