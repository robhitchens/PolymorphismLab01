package io.zipcoder.pets;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Test class for the Pet class hierarchy. Part of Polymorphism Lab 1
 */
public class PetTest {

    //Classes to create
    Pet testPet;
    Dog testDog;
    Cat testCat;
    Hamster testHamster;


    //Instantiate here
    @Before
    public void resourcesNeededToTest() {
        testPet = new Pet();
        testDog = new Dog();
        testCat = new Cat();
        testHamster = new Hamster();
    }

    @Test
    public void givenADogShouldHaveUniqueSpeakMethod() {
        assertEquals("Dog should bark", "Bark!", testDog.speak());
    }

    @Test
    public void givenACatShouldHaveUniqueSpeakMethod() {
        assertEquals("Cat should Meow", "Meow!", testCat.speak());
    }

    @Test
    public void givenAHamsterShouldHaveUniqueSpeakMethod() { assertEquals("Hamster should squeak", "Squeak~", testHamster.speak());}

    @Test
    public void givenADogShouldSubclassPet(){
        assertThat(testDog, instanceOf(Pet.class));
    }

    @Test
    public void givenACatShouldSubclassPet(){
        assertThat(testCat, instanceOf(Pet.class));
    }

    @Test
    public void givenAHamsterShouldSubclassPet(){ assertThat(testHamster, instanceOf(Pet.class));}

    @Test
    public void petHasNameProperty(){
        String name = "Spot";
        String name2 = "Snowball";

        Pet snookums = new Pet();
        snookums.setName(name);
        assertEquals("Pet did not remember its name: " + name, name, snookums.getName());

        snookums.setName(name2);
        assertEquals("Pet did not remember its name: " + name2, name2, snookums.getName());

    }
    
}
