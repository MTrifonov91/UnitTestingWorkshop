package edu.studying.junit.g.assertj;

import org.assertj.core.api.AbstractAssert;

// custom AssertJ matcher (assertion method) class
// must extend AbstractAssert class from AssertJ
// this class itself and the "object under assertion" class as generic parameters
public class PlayerAssert extends AbstractAssert<PlayerAssert, Players> {

    // creating a static assertThat method that returns a new instance of PlayerAssert
    // needed for the possibility of method chaining
    // method does not need a class instance as it is static,
    // and it returns an instance of current class with which we can work further
    // this way we make sure the assertions are performed on the same object
    public static PlayerAssert assertThat(Players players) {
        return new PlayerAssert(players);
    }

    // mandatory constructor from super class
    protected PlayerAssert(Players players) {
        super(players, PlayerAssert.class);
    }

    // custom assertion hasName()
    // must return PlayerAssert class instance
    // takes the name as String as parameter
    public PlayerAssert hasName(String expectedName) {
        // validating the parameter to not be null
        isNotNull();

        // logical part of the assertion using "actual" key word to refer to the tested object
        if (!actual.getName().equals(expectedName)) {
            failWithMessage("Expected name: " + expectedName + ", but was: " + actual.getName());
        }

        return this;
    }

    //TODO write a custom assertion hasAge()
    // must return PlayerAssert class instance
    // takes the age as int as parameter
    public PlayerAssert hasAge(int expectedAge) {

        // logical part of the assertion using "actual" key word to refer to the tested object
        if (!(actual.getAge() == expectedAge)) {
            failWithMessage("Expected age: " + expectedAge + ", but was: " + actual.getAge());
        }

        return this;
    }


    //TODO custom assertion hasSport()
    // must return PlayerAssert class instance
    // takes the name as String as parameter
    public PlayerAssert hasSport(String expectedSport) {
        // validating the parameter to not be null
        isNotNull();

        // logical part of the assertion using "actual" key word to refer to the tested object
        if (!actual.getSport().equals(expectedSport)) {
            failWithMessage("Expected sport: " + expectedSport + ", but was: " + actual.getSport());
        }

        return this;
    }

}
