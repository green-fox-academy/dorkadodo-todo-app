import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Arguments {

    private Path instructionsPath = Paths.get("../data/InstructionsAboutArguments.txt");
    public ToDoActions toDoActions;

    public void argumentHandling(String[] arguments) {
        toDoActions = new ToDoActions();
        List<ToDos> toDoList = toDoActions.getToDoList();
        if (arguments.length == 0) {
            try {
                List<String> instructionSet = Files.readAllLines(instructionsPath);
                for (String line : instructionSet) {
                    System.out.println(line);
                }
                System.out.println();
            } catch (IOException e) {
                System.out.println("enter an argument beginning with a '-'");
            }
        } else {
            switch (arguments[0]) {
                case "-l": {
                    if (toDoList.isEmpty()) {
                        System.out.println("No todos for today! :)");
                    } else {
                        for (ToDos toDo : toDoList) {
                            System.out.println(toDo.getDescription());
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
