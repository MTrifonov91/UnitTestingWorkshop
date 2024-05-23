package edu.studying.mockito.presentation.d.stubmethodswithreturntype;

// class under test for multiple thenReturn()
public class GoalStatistics {

    // external dependency
    private GoalsService goalsService;

    public GoalStatistics(GoalsService goalsService) {
        this.goalsService = goalsService;
    }

    // method under test
    public Integer goalsPerGame(String player, Integer games) throws Exception {

        Integer goals = goalsService.getGoals(player);
        if (goals <= 0) {
            throw new Exception("No Goals Scored");
        }
        return goals / games;
    }
}

class GoalsService {

    // this method will be stubbed (multiple times)
    public Integer getGoals(String player) {
        return (int) Math.floor(Math.random() * (10) + 1);
    }
}
