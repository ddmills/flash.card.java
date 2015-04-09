package flash.card.java.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

import flash.card.java.controller.SchoolController;
import flash.card.java.model.Answer;
import flash.card.java.model.Card;
import flash.card.java.model.CurrentUser;
import flash.card.java.model.Quiz;
import flash.card.java.model.Result;
import flash.card.java.model.Student;


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
    
    private void displayResult(Result result) {
        if(result == null)
        {
            println(cmd + " failed");
        }
        else
        {
            System.out.println();
            println("Student: " + result.getStudent().getUserID());
            System.out.println();
            
            HashMap<Integer, Answer> qaPair = result.getAnswers();
            for (Integer id : qaPair.keySet())
            {
                Answer qa = qaPair.get(id);
                println("Question: " + qa.getQuestion());
                println("Expected Answer: " + qa.getExpectedAnswer());
                println("Actual Answer: " + qa.getActualAnswer());
                System.out.println();
            }
        }
    }
    
    private void displayResultList(List<Result> list) {
        if(list == null)
        {
            println(cmd + " failed");
        }
        else
        {
            for(int i = 0; i < list.size(); i++)
            {
                displayResult(list.get(i));
            }
        }
    }

    private void attempt(boolean command) {
        if (command) {
            println(cmd + " succeeded");
        } else {
            println(cmd + " failed");
        }
    }
    
    private void runQuiz(int quizID)
    {
        Quiz quiz = school.startQuiz(quizID);
        if (quiz != null)
        {
            println("Loading quiz succeeded.");
            
            CurrentUser user = CurrentUser.getInstance();
            Result result = new Result(quizID, (Student)user.get());
            
            HashMap<Integer, Card> questions = quiz.getDeck().getCards();
            for (Integer cardID : questions.keySet())
            {
                Card question = questions.get(cardID);
                println("Question: " + question.getFront());
                print("Answer: ");
                String actualAnswer = read();
                Answer answer = new Answer(cardID, question.getFront(), question.getBack(), actualAnswer);
                result.addAnswer(answer);
            }
            
            school.endQuiz(quizID, result);
        }
        else
        {
            println("Loading quiz failed.");
        }
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
        case "remove quiz from student":
            attempt(school.addQuizToStudent(ask("student username"), askInt("quiz id")));
            break;
        case "add student to course":
            attempt(school.addStudentToCourse(askInt("courseID"), ask("student id")));
            break;
        case "remove student from course":
            attempt(school.removeStudentFromCourse(askInt("courseID"), ask("student id")));
            break;
        case "edit course name":
            attempt(school.editCourseName(askInt("courseID"), ask("new course name")));
            break;
        case "edit deck title":
            attempt(school.editDeckTitle(askInt("deckID"), ask("new deck title")));
            break;
        case "edit quiz title":
            attempt(school.editQuizTitle(askInt("quizID"), ask("new quiz title")));
            break;
        case "delete student":
            attempt(school.deleteStudent(ask("studentID")));
            break;
        case "delete teacher":
            attempt(school.deleteTeacher(ask("teacherID")));
            break;
        case "delete course":
            attempt(school.deleteCourse(askInt("courseID")));
            break;
        case "delete card":
            attempt(school.deleteCard(askInt("cardID"), askInt("deckID")));
            break;
        case "delete quiz":
            attempt(school.deleteQuiz(askInt("quizID")));
            break;
        case "delete deck":
            attempt(school.deleteDeck(askInt("deckID")));
            break;
        case "take quiz":
            runQuiz(askInt("quizID"));
            break;
        case "retrieve results":
            displayResult(school.retrieveResults(askInt("quizID")));
            break;
        case "retrieve all results":
            displayResultList(school.retrieveAllResults(askInt("quizID")));
            break;
        case "help":
        case "commands":
            println("- login");
            println("- logout");
            println("- take quiz");
            println("- create teacher");
            println("- create student");
            println("- create deck");
            println("- create card");
            println("- create quiz");
            println("- create course");
            println("- delete teacher");
            println("- delete student");
            println("- delete card");
            println("- delete deck");
            println("- delete quiz");
            println("- delete course");
            println("- add quiz to student");
            println("- remove quiz from student");
            println("- add student to course");
            println("- remove student from course");
            println("- edit course name");
            println("- edit deck title");
            println("- edit quiz title");
            println("- retrieve results");
            println("- retrieve all results");
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
