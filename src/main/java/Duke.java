import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;

public class Duke {
    Scanner scanner = new Scanner(System.in);
    int index = 0;
    ArrayList<Task> inputArray = new ArrayList<>();

    Duke() {
        Greet();
        while (true) {
            try {
                String input = scanner.nextLine();
                if (input.equals("bye")) {
                    Bye();
                    break;
                } else if (input.equals("list")) {
                    List();
                } else if (input.startsWith("mark")) {
                    markTask(input);
                } else if (input.startsWith("unmark")) {
                    unmarkTask(input);
                } else if (input.startsWith("todo")) {
                    addTodo(input);
                } else if (input.startsWith("deadline")) {
                    addDeadlines(input);
                } else if (input.startsWith("event")) {
                    addEvents(input);
                } else if (input.startsWith("delete")) {
                    deleteTask(input);
                } else {
                    System.out.println("Sorry, I do not accept that as a task!");
                    continue;
                }
                reportNum();
            } catch (InputMismatchException | ArrayIndexOutOfBoundsException |
                    NumberFormatException | NullPointerException e) {
                System.out.println("Please input correctly");
            }
        }
    }

    /*
     * Reports the number of items in the list
     *
     */
    private void reportNum() {
        System.out.println("Now you have " + index + " in the list.");
    }

    /*
     * Sends a greeting to the user
     *
     */
    private void Greet() {
        System.out.println("Hello! I'm BotChat123 \nWhat can I do for you?");
    }

    /*
     * Terminates the conversation with the user
     *
     */
    private void Bye(){
        System.out.println("Bye. Please chat with me again!");
    }

    /*
     * Reports all the items that are in the list
     *
     */
    private void List(){
        for (int i = 0; i < index; i++) {
            System.out.println(i + 1 + ": " + inputArray.get(i));
        }
    }

    /*
     * Adds a todo to the list
     *
     * @param input
     */
    private void addTodo(String input) {
        try {
            if (input.length() > 5) {
                inputArray.add(index, new Todo(input.substring(5)));
                System.out.println("Got it. I've added this task:\n" + inputArray.get(index));
                index++;
            } else {
                System.out.println("Please fill in what you want on the Todo!");
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Please fill in what you want on the Todo!");
        }
    }

    /*
     * Adds an event to the list
     *
     * @param input
     */
    private void addEvents(String input) {
        try {
            if (input.length() > 6) {
                int slashIndex = input.indexOf("/");
//                System.out.println(input.substring(slashIndex + 4));
                LocalDate date = LocalDate.parse(input.substring(slashIndex + 4));
                inputArray.add(index, new Events(input.substring(6, slashIndex), date));
                System.out.println("Got it. I've added this task:\n" + inputArray.get(index));
                index++;

            } else {
                System.out.println("Please fill in what you want on the Events!");
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Please fill in what you want on the Events!");
        }
    }

    /*
     * Adds a deadline to the list
     *
     * @param input
     */
    private void addDeadlines(String input) {
        try {
            if (input.length() > 9) {
                int slashIndex = input.indexOf("/");
                LocalDate date = LocalDate.parse(input.substring(slashIndex + 4));
                inputArray.add(index, new Deadlines(input.substring(9, slashIndex), date));
                System.out.println("Got it. I've added this task:\n" + inputArray.get(index));
                index++;
            } else {
                System.out.println("Please fill in what you want on the Deadlines!");
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Please fill in what you want on the Deadlines!");
        }
    }

    /*
     * Marks a task in the list as done
     *
     * @param input
     */
    private void markTask(String input) throws NullPointerException, ArrayIndexOutOfBoundsException,
            NumberFormatException {
        int markIndex = Integer.parseInt(input.substring(5));
        inputArray.get(markIndex -1).done();
        System.out.println("Nice! I've marked this task as done liao!:\n"
                + inputArray.get(markIndex - 1));
    }

    /*
     * Marks a task in the list as not done
     *
     * @param input
     */
    private void unmarkTask(String input) throws NullPointerException, ArrayIndexOutOfBoundsException,
            NumberFormatException {
        int markIndex = Integer.parseInt(input.substring(7));
        inputArray.get(markIndex - 1).unDone();
        System.out.println("OK, I unmark this task as not done le:\n"
                + inputArray.get(markIndex - 1));
    }

    /*
     * Deletes a task that is in the list
     *
     * @param input
     */
    private void deleteTask(String input) throws NullPointerException, ArrayIndexOutOfBoundsException , NumberFormatException {
        int markIndex = Integer.parseInt(input.substring(7));
        System.out.println("Swee! Task removed: " + inputArray.get(markIndex - 1));
        inputArray.remove(markIndex - 1);
        index--;
    }

    public static void main(String[] args) {
        Duke duke = new Duke();
    }
}
