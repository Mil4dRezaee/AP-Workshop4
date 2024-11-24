import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Voting {
    private final int type;
    private String question;
    private HashMap<String, HashSet<Vote>> choices;
    private boolean isAnonymous;
    private ArrayList<Person> voters;

    public Voting(int type, String question, boolean isAnonymous) {
        this.type = type;
        this.question = question;
        this.choices = new HashMap<>();
        this.isAnonymous = isAnonymous;
        this.voters = new ArrayList<>();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void createChoice(String choice) {
        if (!this.choices.containsKey(choice)) {
            this.choices.put(choice, new HashSet<>());
        }
    }

    public void vote(Person voter, String choice) {
        if (this.type == 0 && voters.contains(voter)) {
            System.out.println(
                    voter.getFirstName() + " " + voter.getLastName() + " has already voted and can not vote again.");
            return;
        }

        HashSet<Vote> votes = this.choices.getOrDefault(choice, new HashSet<>());
        votes.add(new Vote(voter, "2004-08-12"));
        this.choices.put(choice, votes);
        this.voters.add(voter);
    }

    public void vote(Person voter, ArrayList<String> choices) {
        for (String choice : choices) {
            vote(voter, choice);
        }
    }

    public void printResults() {
        System.out.println("Voting results for: " + this.question);
        for (String choice : this.choices.keySet()) {
            System.out.println(choice + ": " + this.choices.get(choice).size() + " votes");
        }
    }

    public void printVoters() {
        if (this.isAnonymous) {
            System.out.println("The voting is anonymous. Voters' names cannot be displayed.");
            return;
        }

        System.out.println("Voters:");
        for (Person voter : this.voters) {
            System.out.println(voter.toString());
        }
    }

    public ArrayList<String> getChoices() {
        return new ArrayList<>(this.choices.keySet());
    }
	
}