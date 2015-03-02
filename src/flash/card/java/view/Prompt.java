package flash.card.java.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import flash.card.java.controller.SchoolController;

public class Prompt {
    private SchoolController school;
    private boolean running;
    private BufferedReader br;
    private String cmd;
    
    public Prompt() {
        school = new SchoolController();
        running = true;
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public void start() {
        do {
            print("> ");
            cmd = read();
            handle(cmd);
        } while (running);
    }
    
    private static void print(int line) {
        System.out.print(line);
    }
    
    private static void print(String line) {
        System.out.print(line);
    }
    
    private static void println(int line) {
        System.out.println(line);
    }
    
    private static void println(String line) {
        System.out.println(line);
    }
    
    private String read() {
        try {
            return br.readLine();
        } catch (IOException io) {
            // invalid input?
            io.printStackTrace();
            return null;
        }
    }
    
    private int readInt() {
        while (true) {
            try {
                String inpt = read();
                int ret = Integer.parseInt(inpt);
                return ret;
            } catch (NumberFormatException e) {
                println("You must input an integer.");
            }
        }
    }
    
    private String ask(String var) {
        print(var + ": ");
        return read();
    }
    
    private int askInt(String var) {
        print(var + ": ");
        return readInt();
    }
    
    private boolean attempt(boolean command) {
        if (command) {
            println(cmd + " succeeded");
        } else {
            println(cmd + " failed");
        }
        return command;
    }
    
    private void handle(String command) {
        switch (command) {
        case "login":
            attempt(school.login(ask("username"), ask("password")));
            break;
        case "logout":
            attempt(school.logout());
            break;
        case "create teacher":
            attempt(school.createTeacher(ask("name"), ask("username"), ask("password")));
            break;
        case "create student":
            attempt(school.createStudent(ask("username"), ask("password"), ask("name")));
            break;
        case "create deck":
            attempt(school.createDeck(askInt("deckID"), ask("title"), ask("description")));
            break;
        case "create card":
            attempt(school.createCard(askInt("cardID"), ask("front text"), ask("back text"), askInt("deckID")));
            break;
        case "create quiz":
            attempt(school.createQuiz(askInt("quizID"), ask("title"), ask("description"), askInt("deckID")));
            break;
        case "create course":
            attempt(school.createCourse(askInt("courseID"), ask("title")));
            break;
        case "add quiz to student":
            attempt(school.addQuizToStudent(ask("student username"), askInt("quiz id")));
            break;
        case "add student to course":
            break;
        case "help":
        case "commands":
            println("- login");
            println("- logout");
            println("- create teacher");
            println("- create student");
            println("- create deck");
            println("- create card");
            println("- create quiz");
            println("- add quiz to student");
            break;
        case "exit":
            running = false;
            println("goodbye!");
            break;
        case "":
            break;
        default:
            println("command not recognized - use \"help\" for a list of commands");
        }
    }
    
    public static void main (String args[]) {
        Prompt p = new Prompt();
        p.start();
    }
}
