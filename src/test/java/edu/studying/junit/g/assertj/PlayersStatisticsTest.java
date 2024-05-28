package edu.studying.junit.g.assertj;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

// test class used to test PlayersStatistics.class methods
class PlayersStatisticsTest {

    // AssertJ provides improved readability compared to JUnit assertions
    // Using standard matchers

    // declare the instance of external dependency
    private Players playerPatrickUnderThirty;
    // declare the instance of class under test
    private PlayersStatistics statisticsOfPatrickUnderThirty;

    // initialize the external dependency and the class under test
    @BeforeEach
    public void setup() {
        System.out.println("setup");
        playerPatrickUnderThirty = new Players("Patrick", 27, "Football");
        statisticsOfPatrickUnderThirty = new PlayersStatistics(playerPatrickUnderThirty, 3, 3);
    }

    // create a test object of the Player.class with the same name as already initialized
    // write an isEqualTo assertion for the 2 objects names
    @Test
    public void playerNameEqual() {
        System.out.println("test 1");
        Players player2 = new Players("Patrick", 25, "Football");
        assertThat(player2.getName())
                .as("Players should have the same name")
                .isEqualTo(playerPatrickUnderThirty.getName());
    }

    //TODO create a test object of the Player.class
    // with a different name to already initialized one
    // write an isNotEqualTo assertion for the 2 objects names
    @Test
    public void playerNamesNotEqual() {
        Players player2 = new Players("Kalvin", 25, "Football");
        PlayerAssert.assertThat(player2).isNotEqualTo(playerPatrickUnderThirty);
    }


    //TODO test the "getYoungerPlayer()" method with an "isSameAs()" assertion
    @Test
    public void youngerPlayerSame() {
        Players player2 = new Players("Patrick", 25, "Football");
        PlayerAssert.assertThat(PlayersStatistics.getYoungerPlayer(playerPatrickUnderThirty, player2))
                .isSameAs(player2);
    }

    //TODO write a test with an "isNotSameAs()" assertion
    @Test
    public void playersNotSame() {
        Players player2 = new Players("Patrick", 27, "Football");
        PlayerAssert.assertThat(playerPatrickUnderThirty)
                .isEqualTo(player2)
                .isNotSameAs(player2);
    }


    // write a test for underThirty() method with initialized class instance (the return true path)
    @Test
    public void underThirtyTrue() {
        System.out.println("test 4");
        assertThat(statisticsOfPatrickUnderThirty.underThirty()).isTrue();
    }

    //TODO write a test for underThirty() method for return false path
    @Test
    public void underThirtyFalse() {
        Players player1 = new Players("Patrick", 37, "Football");
        PlayersStatistics statistics = new PlayersStatistics(player1, 3, 3);
        assertThat(statistics.underThirty()).isFalse();
    }

    //TODO write a test for "createCsvRecord()" method for return null path
    @Test
    public void csvReportNull() {
        PlayersStatistics statistics = new PlayersStatistics(playerPatrickUnderThirty, 0, 0);
        assertThat(statistics.createCsvRecord()).isNull();
    }


    // write a test for "createCsvRecord()" method for return NOT null path
    @Test
    public void csvReportNotNull() {
        System.out.println("test 7");
        PlayersStatistics statistics = new PlayersStatistics(playerPatrickUnderThirty, 3, 3);
        assertThat(statistics.createCsvRecord()).isNotNull();
    }

    // write a test for "createCsvRecord()" method for return NOT null path, validating the return
    @Test
    public void getCsvStatsRecord() {
        System.out.println("test 8");
        PlayersStatistics statistics = new PlayersStatistics(playerPatrickUnderThirty, 4, 8);
        Double[] expectedArray = {2d, 0.5};
        assertThat(statistics.createCsvRecord()).isEqualTo(expectedArray);
    }

    //TODO write a test on Player's "getAge()" method
    // using isEqualTo() assertion
    @Test
    public void playerConstructorAgeAssigned() {
        Players player1 = new Players("Stuart", 30, "Football");
        assertThat(player1.getAge()).isEqualTo(30);
    }


    // write a test on Player's "getName()" method
    // Using Custom AssertJ Matchers (hasName)
    @Test
    public void playerNameEqualCustom() {
        System.out.println("test 1");
        Players player2 = new Players("Patrick", 25, "Football");
        PlayerAssert.assertThat(player2).hasName(playerPatrickUnderThirty.getName());
    }

    //TODO write a test on Player's "getAge()" method
    // Using Custom AssertJ Matchers (hasAge)
    @Test
    public void playerAgeEqualCustom() {
        Players player2 = new Players("Patrick", 27, "Football");
        PlayerAssert.assertThat(player2).hasAge(playerPatrickUnderThirty.getAge());
    }


    //TODO write a test on Player's "getAge()" and getName() methods
    // Using Custom AssertJ Matchers hasAge() and hasName()
    @Test
    public void playerAgeEqualAndNameEqualCustom() {
        Players player2 = new Players("Patrick", 27, "Football");
        PlayerAssert.assertThat(player2)
                .hasAge(playerPatrickUnderThirty.getAge())
                .hasName(playerPatrickUnderThirty.getName());
    }


    //TODO write a test on Player's "getSport()" method
    // Using Custom AssertJ Matchers (hasSport)
    @Test
    public void playerSportEqualCustom() {
        Players player2 = new Players("Patrick", 25, "Football");
        PlayerAssert.assertThat(player2).hasSport(playerPatrickUnderThirty.getSport());
    }


    //TODO write a test on Player's "getAge()", "getName()" and "getSport" methods
    // Using Custom AssertJ Matchers hasAge(), hasName() and hasSport()
    @Test
    public void playerAgeNameSportEqualCustom() {
        Players player2 = new Players("Patrick", 27, "Football");
        PlayerAssert.assertThat(player2)
                .hasAge(playerPatrickUnderThirty.getAge())
                .hasName(playerPatrickUnderThirty.getName())
                .hasSport(playerPatrickUnderThirty.getSport());
    }

}