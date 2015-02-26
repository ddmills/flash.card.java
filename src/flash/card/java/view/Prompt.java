package flash.card.java.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prompt {
    private static void print(String line) {
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
    
    public static void main (String args[]) {
        boolean running;
        String input;
        BufferedReader br;
        
        
        br = new BufferedReader(new InputStreamReader(System.in));
        running = true;
        
        do {
            input = read(br);
            print(input);
            
            if (input.equals("exit")) {
                print("goodbye!");
                running = false;
            }
        } while (running);
    }
}
