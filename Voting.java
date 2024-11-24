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
	
}