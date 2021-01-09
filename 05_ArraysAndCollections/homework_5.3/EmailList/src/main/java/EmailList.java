import java.util.*;

public class EmailList {
    private Set<String> emailList = new TreeSet<>();

    public void add(String email) {
        if (email.matches(".+@.+\\.+.+"))
        emailList.add(email.toLowerCase());
    }

    public List<String> getSortedEmails() {
        return new ArrayList<>(emailList);
    }
}
