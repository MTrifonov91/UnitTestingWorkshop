package edu.studying.mockito.classwork.stubbingvoid;
// class under test
public class ChessPlayer {

    // class variables (no external dependencies)
    private String name;
    private String category;
    private Integer age;

    private Integer wins;
    private Integer points;

    // class constructor
    public ChessPlayer(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    // method under test
    // method assigns a category to ChessPlayer object based on the age
    public void assignCategory() throws Exception{
        System.out.println("Assigning category for " + this.name);

        // path a -> throws exception when age is less than 5
        if(this.getAge() < 5){
            throw new Exception("Player age too low");
        }
        // path b -> assigns "Under 18's" if age is less than 18
        // path c -> assigns "Senior" if age 18 and over
        this.category = this.getAge() < 18 ? "Under 18's" : "Senior";
    }

    // method under test
    public void assignScoreStats(){
        System.out.println("Assigning score stats for " + this.name);

        //connects to database
        //calculates wins and sets value
        this.wins = 1;
        //calculates total points and sets to 'points'
        this.points = 2;
    }

    // getters and setters
    public Integer getAge() {
        return age;
    }

    public Integer getPoints() {
        return points;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    // getter tested in order to validate assignCategory() methods work
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return this.name;
    }

    public Integer getWins() {
        return this.wins;
    }
}
