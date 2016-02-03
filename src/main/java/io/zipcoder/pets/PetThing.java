package io.zipcoder.pets;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by roberthitchens3 on 2/2/16.
 */
public class PetThing {
    private ArrayList<Pet> pets;
    public PetThing(){
        pets = new ArrayList<Pet>();
        run();
    }
    public void run(){
        int numOfPets = Integer.parseInt(userInput("how many pets do you have? ", "number"));
        for (int i = 0; i<numOfPets; i++){
            String type = userInput("What kind of pet do you have? ","");
            String name = userInput("what's your pets' name? ", "");
            Pet pet = null;
            switch(type){
                case "Dog":
                    pet = new Dog();
                    pet.setName(name);
                    break;
                case "Cat":
                    pet = new Cat();
                    pet.setName(name);
                    break;
                case "Hamster":
                    pet = new Hamster();
                    pet.setName(name);
                    break;
                default:
                    System.out.println("not a recognized pet.");

            }
            try {
                pets.add(pet);
            }catch(NullPointerException e){
                    //something
            }
        }
        printPets();

    }
    public void printPets(){
        for(Pet p : pets){
            System.out.println(p.getName() + " " + p.speak());
        }
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
