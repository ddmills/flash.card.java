package flash.card.java.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prompt {
    public static void main (String args[]) {
        boolean running;
        String input;
        BufferedReader br;
        
        running = true;
        
        do {
            try {
                br = new BufferedReader(new InputStreamReader(System.in));

                while ((input = br.readLine()) != null) {
                    System.out.println(input);
                }
                
            } catch (IOException io) {
                // invalid input?
                io.printStackTrace();
            }
        
        } while (running);
        
    }
}
