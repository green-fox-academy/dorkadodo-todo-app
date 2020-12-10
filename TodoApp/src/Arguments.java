import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Arguments {

    private Path instructionsPath = Paths.get("data/InstructionsAboutArguments.txt");
    private Path instructionsPathCommandLine = Paths.get("../data/InstructionsAboutArguments.txt");
    private static ToDoActions toDoActions = new ToDoActions();

    public void argumentHandling(String[] arguments) {
        if (arguments.length == 0) {
            List<String> instructionSet = new ArrayList<>();
            try {
                instructionSet = Files.readAllLines(instructionsPath);
            } catch (IOException e) {
                try {
                    instructionSet = Files.readAllLines(instructionsPathCommandLine);
                } catch (IOException e2) {
                    System.out.println("enter an argument beginning with a '-'");
                }
            }
            for (String line : instructionSet) {
                System.out.println(line);
            }
            System.out.println();
        } else {
            switch (arguments[0]) {
                case "-l": {
                    if (arguments.length == 1) {
                        toDoActions.printToDoList();
                    } else {
                        if (arguments[1].equals("-t")) {
                        } else {
                            System.out.println("Invalid argument after '-l'");
                        }
                    }
                    break;
                }
                case "-a": {
                    if (arguments.length == 1) {
                        System.out.println("Unable to add: no task provided");
                    } else {
                        toDoActions.addToDo(arguments[1]);
                    }
                    break;
                }
                case "-r": {
                    if (arguments.length == 1) {
                        System.out.println("Unable to remove: no index provided");
                    } else {
                        if (Pattern.matches("[0-9]+", arguments[1])) {
                            if (Integer.parseInt(arguments[1]) > toDoActions.getToDoList().size()) {
                                System.out.println("Unable to remove: index is out of bounds");
                            } else {
                                toDoActions.removeToDo(Integer.parseInt(arguments[1]) - 1);
                            }
                        } else {
                            System.out.println("Unable to remove: index is not a number");
                        }
                    }
                    break;
                }
                default: {
                    System.out.println("invalid argument");
                }
            }
        }
    }
}
