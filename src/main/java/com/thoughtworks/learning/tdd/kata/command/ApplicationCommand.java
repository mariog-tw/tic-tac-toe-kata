package com.thoughtworks.learning.tdd.kata.command;

import com.thoughtworks.learning.tdd.kata.Application;

public interface ApplicationCommand {
    void executeIn(Application application);
}
