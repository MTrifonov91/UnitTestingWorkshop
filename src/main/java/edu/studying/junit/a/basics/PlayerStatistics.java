package edu.studying.junit.a.basics;

import lombok.AllArgsConstructor;
import lombok.Getter;

// Class under test
@Getter
@AllArgsConstructor
public class PlayerStatistics {

    // class variables, with an external dependency
    private Player player;
    private int games;
    private int goals;

    // internal method returns result of games divided by goals as double
    private double gamesPerGoal(){
        return (double)this.games / (double)this.goals;
    }

    // internal method returns result of goals divided by games as double
    private double goalsPerGame(){
        return (double)this.goals / (double)this.games;
    }

    // method returns true in case players age is less than 30, return false otherwise
    public boolean underThirty(){
        return this.player.getAge() < 30;
    }

    // method returns an array of Doubles with results from gamesPerGoal() and goalsPerGame()
    // methods
    public Double[] createCsvRecord(){
        if (this.games == 0){
            return null;
        }
        else{
            return new Double[]{goalsPerGame(), gamesPerGoal()};
        }
    }

    // method returns the player object with a smaller age
    public static Player getYoungerPlayer(Player player1, Player player2){
        if(player2.getAge() < player1.getAge()){
            return player2;
        }
        return player1;
    }

}
