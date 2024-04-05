package natwest.com.task.task3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

class ScoreAnalyzer {
    private LinkedList<Integer> runsData;

    public ScoreAnalyzer() {
        runsData = new LinkedList<>();
    }

    public void addRunsToList(int runs) {
        runsData.add(runs);
    }


    public double calcRunRate() {
        double totalRuns = 0;
        for (double runs : runsData) totalRuns += runs;
        return totalRuns / 50;
    }

    public int lowestRunsScored() {
        int minRuns = runsData.get(0);
        for (int runs : runsData) {
            if (runs < minRuns) minRuns = runs;
        }
        return minRuns;
    }


    public void displayRuns() {
        System.out.print("Runs Scored: " + runsData);
    }
}

public class TestScoreAnalyzer {
    public static void main(String[] args) {
        ScoreAnalyzer analyzer = new ScoreAnalyzer();
        Scanner sc= new Scanner(System.in);

        System.out.println("Number of player: ");
        int n = sc.nextInt();
        ArrayList<Integer> runs = new ArrayList<>();
        System.out.println("Enter runs scored by players");
        for( int i=0;i<n;i++){
            runs.add(sc.nextInt());
        }


        analyzer.displayRuns();
        System.out.println("Runrate: " + analyzer.calcRunRate());
        System.out.println("Lowest Runs: " + analyzer.lowestRunsScored());
        System.out.println("Count of players who batted: " + runs.size());
    }
}
