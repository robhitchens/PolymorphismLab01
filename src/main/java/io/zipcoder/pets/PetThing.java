package io.zipcoder.pets;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by roberthitchens3 on 2/2/16.
 */
public class PetThing {
    private ArrayList<String> pets;
    public PetThing(){
        pets = new ArrayList<String>();
        run();
    }
    public void run(){
        int numOfPets = Integer.parseInt(userInput("how many pets do you have? ", "number"));
        for (int i = 0; i<numOfPets; i++){
            pets.add(userInput("What kind of pet do you have? ","")+userInput("what's your pets' name? ", ""));
        }
        printPets();

    }
    public void printPets(){
        System.out.print(pets.toString());
    }
    public String userInput(String message, String type){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        String input = scanner.nextLine();

        if(type.equals("number")){
            String pattern = "(.*)\\d+(.*)";//should find number with decimal value or number without decimal value.
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(input);
            boolean okay =false;
            while(!okay){
                if(m.find()){
                    okay = true;
                    return input;

                }else{
                    System.out.println("entered value is invalid. enter new Value: ");
                    input = scanner.next();
                    m = p.matcher(input);
                }
            }

        }

        return input;
    }
}
