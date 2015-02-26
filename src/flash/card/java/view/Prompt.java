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
            println(input);
            
            switch (input) {
                
            case "exit":
                running = false;
                println("goodbye!");
                break;
            case "login":
                print("Please enter username: ");
                String name = read(br);
                print("Please enter password: ");
                String pass = read(br);
                println("you input: " + name + " " + pass);
                break;
            default:
                println("Command not recognized");
            }
        } while (running);
    }
}
