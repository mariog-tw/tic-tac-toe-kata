import java.io.*;

public class Application {
    public Application(Reader reader, PrintStream printStream) throws IOException {
        Game game = Game.newGame();
        String command;
        BufferedReader bufferedReader = new BufferedReader(reader);

        while (true) {
            printStream.print(game.printBoard());
            printStream.print("\nCommand: ");
            command = bufferedReader.readLine();

            if ("exit".equalsIgnoreCase(command)) {
                System.exit(0);
            } else if ("new".equalsIgnoreCase(command)) {
                game = Game.newGame();
            } else {
                game.playIn(command);
            }
            printStream.print("\n\n");
        }
    }

    public static void main(String[] args) throws IOException {
        new Application(new InputStreamReader(System.in), System.out);
    }
}
