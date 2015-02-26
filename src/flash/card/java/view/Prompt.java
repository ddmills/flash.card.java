package flash.card.java.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import flash.card.java.controller.SchoolController;

public class Prompt {
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
    
    private static String read(BufferedReader br) {
        try {
            return br.readLine();
        } catch (IOException io) {
            // invalid input?
            io.printStackTrace();
            return null;
        }
    }
    
    private static int readInt(BufferedReader br) {
        while (true) {
            try {
                String inpt = read(br);
                int ret = Integer.parseInt(inpt);
                return ret;
            } catch (NumberFormatException e) {
                println("You must input an integer.");
            }
        }
    }
    
    public static void main (String args[]) {
        boolean running;
        String input;
        BufferedReader br;
        
        
        SchoolController school = new SchoolController();
        
        br = new BufferedReader(new InputStreamReader(System.in));
        running = true;
        
        do {
            print("> ");
            input = read(br);
            switch (input) {
                
            case "exit":
                running = false;
                println("goodbye!");
                break;
            case "login":
                String name;
                String pass;
                
                print("Please enter username: ");
                name = read(br);
                print("Please enter password: ");
                pass = read(br);

                if (school.login(name, pass)) {
                    println("welcome " + name);
                } else {
                    println("login failed.");
                }
                
                break;
            case "logout":
                if (school.logout()) {
                    println("you have been logged out");
                } else {
                    println("logout failed");
                }
                break;
            default:
                println("Command not recognized");
            }
        } while (running);
    }
}
