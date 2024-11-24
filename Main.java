import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        VotingSystem votingSystem = new VotingSystem();

        ArrayList<String> choicesForVoting1 = new ArrayList<>(
                Arrays.asList("#1 Option 1", "#2 Option 2", "#3 Option 3"));
        votingSystem.createVoting("Choose your favorite option (only one)", false, 0, choicesForVoting1);

        ArrayList<String> choicesForVoting2 = new ArrayList<>(Arrays.asList("#1 Apple", "#2 Banana", "#3 Cherry"));
        votingSystem.createVoting("Select all fruits you like", true, 1, choicesForVoting2);

        Person person1 = new Person("Milad", "Rezaee");
        Person person2 = new Person("Morteza", "Mahmoodi");

        votingSystem.printVoting(0);
        System.out.println("################################################################################");

        System.out.println(person1.getFirstName() + "`s turn:");

        String command = scanner.nextLine();
        String[] indexxx = command.split(" ");
        ArrayList<String> choiseListsList = new ArrayList<>();
        for (String in : indexxx) {
            if (Integer.valueOf(in) - 1 < choicesForVoting1.size()) {

                choiseListsList.add(choicesForVoting1.get(Integer.valueOf(in) - 1));
            } else
                System.out.println("invalid index");

        }

        System.out.println(person2.getFirstName() + "`s turn:");

        String command1 = scanner.nextLine();
        String[] indexxx1 = command1.split(" ");
        ArrayList<String> choiseListsList1 = new ArrayList<>();
        for (String in : indexxx1) {

            if (Integer.valueOf(in) - 1 < choicesForVoting1.size()) {

                choiseListsList1.add(choicesForVoting1.get(Integer.valueOf(in) - 1));
            } else {
                System.out.println("invalid index");
            }

        }
        System.out.println("################################################################################");

        System.out.println("Results for the first voting:");

        votingSystem.vote(0, person1, new ArrayList<>((choiseListsList)));

        votingSystem.vote(0, person2, new ArrayList<>((choiseListsList1)));

        votingSystem.printResults(0);
        System.out.println("Voters for the first voting:");
        votingSystem.printVoters(0);

        System.out.println("################################################################################");
        votingSystem.printVoting(1);
        System.out.println(person1.getFirstName() + "`s turn:");
        String command2 = scanner.nextLine();
        String[] indexxx2 = command2.split(" ");
        ArrayList<String> choiseListsList2 = new ArrayList<>();
        for (String in : indexxx2) {

            if (Integer.valueOf(in) - 1 < choicesForVoting2.size()) {

                choiseListsList2.add(choicesForVoting2.get(Integer.valueOf(in) - 1));
            } else {
                System.out.println("invalid index");
            }

        }
        System.out.println("################################################################################");

        System.out.println(person2.getFirstName() + "`s turn:");

        String command3 = scanner.nextLine();
        String[] indexxx3 = command3.split(" ");
        ArrayList<String> choiseListsList3 = new ArrayList<>();
        for (String in : indexxx3) {
            if (Integer.valueOf(in) - 1 < choicesForVoting2.size()) {

                choiseListsList3.add(choicesForVoting2.get(Integer.valueOf(in) - 1));
            } else {
                System.out.println("invalid index");
            }

        }
        System.out.println("################################################################################");
        System.out.println("Results for the second voting:");

        votingSystem.vote(1, person1, new ArrayList<>(choiseListsList2));
        votingSystem.vote(1, person2, new ArrayList<>(choiseListsList3));
        votingSystem.printResults(1);
        System.out.println("Voters for the second voting:");
        votingSystem.printVoters(1);
        System.out.println("################################################################################");

    }
}