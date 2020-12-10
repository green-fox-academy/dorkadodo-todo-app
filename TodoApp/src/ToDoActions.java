import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ToDoActions {
    private Path toDoListPath= Paths.get("data/ToDoList.txt");
    private Path toDoListPathCommandLine= Paths.get("../data/ToDoList.txt");

    public List<String> getToDoList() {
        List<String> toDoList = new ArrayList<>();
        try {
            toDoList = Files.readAllLines(toDoListPath);
        } catch (IOException e) {
            try {
                toDoList = Files.readAllLines(toDoListPathCommandLine);
            } catch (IOException e2) {
                System.out.println("Sorry, couldn't find the list. Please try again.");
            }
        }
        return toDoList;
    }

    public void removeToDo (int number){
        List<String> toDoList = getToDoList();
        toDoList.remove(number-1);
        try {
            Files.write(toDoListPath, toDoList);
        } catch (IOException e) {
            try {
                Files.write(toDoListPathCommandLine, toDoList);
            } catch (IOException e2) {
                System.out.println("Sorry, couldn't find the list.");
            }
        }
    }

 /*   public void completedTask (int number) {
        List<String> toDoList = getToDoList();
        toDoList.get(number-1);
        try {
            Files.write(toDoListPath, toDoList);
        } catch (IOException e) {
            try {
                Files.write(toDoListPathCommandLine, toDoList);
            } catch (IOException e2) {
                System.out.println("Sorry, couldn't find the list.");
            }
        }
    }*/

    public void printToDoList (){
        List<String> listToPrint = getToDoList();
        for (int i = 0; i < listToPrint.size(); i++) {
            String[] toDoValues = listToPrint.get(i).split("% ");
            String statusAndDescription = toDoValues[0];
            String timeAdded = toDoValues[1];
            String priority = toDoValues[2];
            System.out.println(statusAndDescription);
        }
    }

    public void addToDo(String description) {
        ToDos toDo = new ToDos(description.trim());
        try {
            Files.write(toDoListPath, Arrays.asList(toDo.toString()), StandardOpenOption.APPEND);
        } catch (IOException e) {
            try {
                Files.write(toDoListPathCommandLine, Arrays.asList(toDo.toString()), StandardOpenOption.APPEND);
            } catch (IOException e2) {
                System.out.println("Sorry, couldn't find the list.");
            }
        }

    }


}
