package edu.studying.mockito.presentation.d.stubmethodswithreturntype;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

// test class to test GoalStatistics.class methods
class GoalStatisticsTest {

    // declaring test dependencies
    GoalsService goalsServiceMock;
    GoalStatistics goalStatistics;
    GoalStatistics goalStatisticsSpy;

    @BeforeEach
    public void setup() {
        // instantiating test dependencies
        goalsServiceMock = mock();
        goalStatistics = new GoalStatistics(goalsServiceMock);
        goalStatisticsSpy = spy(goalStatistics);
    }

    // example test for goalsPerGame() method
    // while stubbing multiple times the getGoals() method
    @Test
    void testGoalsPerGameWithMultiStub() throws Exception {
        String playerName = "Player";

        // performing multiple stubbing
        when(goalsServiceMock.getGoals(playerName))
                .thenReturn(100) // 1st stub
                .thenReturn(10) // 2nd stub
                .thenReturn(0) // 3rd stub
                .thenReturn(90); // 4th stub

        // result of 1st stub
        System.out.println(goalStatistics.goalsPerGame(playerName, 10));
        // result of 2nd stub
        System.out.println(goalStatistics.goalsPerGame(playerName, 10));
        // result of 3rd stub
        assertThrows(Exception.class, () -> goalStatistics.goalsPerGame(playerName, 10));
        // result of 4th stub
        System.out.println(goalStatistics.goalsPerGame(playerName, 10));
        // result of 4th stub
        System.out.println(goalStatistics.goalsPerGame(playerName, 10));
        // result of 4th stub
        System.out.println(goalStatistics.goalsPerGame(playerName, 10));
    }
}