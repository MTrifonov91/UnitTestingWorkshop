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
        playerPatrickUnderThirty = new Players("Patrick", 27);
        statisticsOfPatrickUnderThirty = new PlayersStatistics(playerPatrickUnderThirty, 3, 3);
    }

    // create a test object of the Player.class with the same name as already initialized
    // write an isEqualTo assertion for the 2 objects names
    @Test
    public void playerNameEqual() {
        System.out.println("test 1");
        Players player2 = new Players("Patrick", 25);
        assertThat(player2.getName())
                .as("Players should have the same name")
                .isEqualTo(playerPatrickUnderThirty.getName());
    }

    // create a test object of the Player.class with a different name to already initialized one
    // write an isNotEqualTo assertion for the 2 objects names
    @Disabled
    @Test
    public void playerNamesNotEqual() {
        System.out.println("test 2");
        Players player2 = new Players("Kalvin", 25);
        PlayerAssert.assertThat(player2).isNotEqualTo(playerPatrickUnderThirty);
    }

    // test the "getYoungerPlayer()" method with an "isSameAs()" assertion
    @Test
    public void youngerPlayerSame() {
        System.out.println("test 3");
        Players player2 = new Players("Patrick", 25);
        PlayerAssert.assertThat(PlayersStatistics.getYoungerPlayer(playerPatrickUnderThirty, player2))
                .isSameAs(player2);
    }

    // write a test for underThirty() method with initialized class instance (the return true path)
    @Test
    public void underThirtyTrue() {
        System.out.println("test 4");
        assertThat(statisticsOfPatrickUnderThirty.underThirty()).isTrue();
    }

    // write a test for underThirty() method for return false path
    @Test
    public void underThirtyFalse() {
        System.out.println("test 5");
        Players player1 = new Players("Patrick", 37);
        PlayersStatistics statistics = new PlayersStatistics(player1, 3, 3);
        assertThat(statistics.underThirty()).isFalse();
    }

    // write a test for "createCsvRecord()" method for return null path
    @Test
    public void csvReportNull() {
        System.out.println("test 6");
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

    // write a test on Player's "getAge()" method
    @Test
    public void playerConstructorNameAssigned() {
        System.out.println("test 9");
        Players player1 = new Players("Stuart", 30);
        assertThat(player1.getAge()).isEqualTo(30);
    }

    // write a test on Player's "getName()" method
    // Using Custom AssertJ Matchers (hasName)
    @Test
    public void playerNameEqualCustom() {
        System.out.println("test 1");
        Players player2 = new Players("Patrick", 25);
        PlayerAssert.assertThat(player2).hasName(playerPatrickUnderThirty.getName());
    }

    // write a test on Player's "getAge()" method
    // Using Custom AssertJ Matchers (hasAge)
    @Test
    public void playerAgeEqualCustom() {
        System.out.println("test 1");
        Players player2 = new Players("Patrick", 27);
        PlayerAssert.assertThat(player2).hasAge(playerPatrickUnderThirty.getAge());
    }

    // write a test on Player's "getAge()" and getName() methods
    // Using Custom AssertJ Matchers hasAge() and hasName()
    @Test
    public void playerAgeEqualAndNameEqualCustom() {
        System.out.println("test 1");
        Players player2 = new Players("Patrick", 27);
        PlayerAssert.assertThat(player2)
                .hasAge(playerPatrickUnderThirty.getAge())
                .hasName(playerPatrickUnderThirty.getName());
    }
}