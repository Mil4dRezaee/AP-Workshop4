import java.util.ArrayList;

public class VotingSystem {
    private ArrayList<Voting> votingList;

    public VotingSystem() {
        this.votingList = new ArrayList<>();
    }

    public void createVoting(String question, boolean isAnonymous, int type, ArrayList<String> choices) {
        Voting voting = new Voting(type, question, isAnonymous);
        for (String choice : choices) {
            voting.createChoice(choice);
        }
        votingList.add(voting);
    }

    public Voting getVoting(int index) {
        if (index >= 0 && index < votingList.size()) {
            return votingList.get(index);
        }
        return null;
    }

    public ArrayList<Voting> getVotingList() {
        return new ArrayList<>(votingList);
    }

    public void printResults(int index) {
        Voting voting = getVoting(index);
        if (voting != null) {
            voting.printResults();
        } else {
            System.out.println("Invalid voting index.");
        }
    }

    public void printVoters(int index) {
        Voting voting = getVoting(index);
        if (voting != null) {
            voting.printVoters();
        } else {
            System.out.println("Invalid voting index.");
        }
    }

    public void printVoting(int index) {
        Voting voting = getVoting(index);
        if (voting != null) {
            System.out.println("Voting " + (index + 1) + ": " + voting.getQuestion());
            System.out.println("Choices:");
            ArrayList<String> choices = voting.getChoices();
            for (String choice : choices) {
                System.out.println(choice);
            }
        } else {
            System.out.println("Invalid voting index.");
        }
    }

    public void vote(int index, Person voter, ArrayList<String> choices) {
        Voting voting = getVoting(index);
        if (voting != null) {
            voting.vote(voter, choices);
        } else {
            System.out.println("Invalid voting index.");
        }
    }
}
