package com.thoughtworks.learning.tdd.kata;

import com.thoughtworks.learning.tdd.kata.command.ApplicationCommandInterpreter;

import java.io.*;

public class Application {
    private Game game = Game.newGame();
    private boolean finished = false;

    public Application(Reader reader, PrintStream printStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(reader);
        boolean firstPrint = true;

        while (!finished) {
            if (!firstPrint) {
                printStream.print("\n\n");
            } else {
                firstPrint = false;
            }

            printStream.print(game.printBoard());
            printStream.print("\nCommand: ");
            String command = bufferedReader.readLine();

            ApplicationCommandInterpreter.create()
                    .interpret(command)
                    .executeIn(this);
        }
    }

    public static void main(String[] args) throws IOException {
        new Application(new InputStreamReader(System.in), System.out);
    }

    public void exit() {
        this.finished = true;
    }

    boolean isRunning() {
        return !finished;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }
}
