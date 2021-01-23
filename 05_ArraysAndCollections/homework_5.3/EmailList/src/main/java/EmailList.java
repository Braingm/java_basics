import java.util.*;

public class EmailList {
    private Set<String> emailList = new TreeSet<>(new EmailComparator());

    public void add(String email) {
        if (email.matches(".+@.+\\.+.+"))
        emailList.add(email.toLowerCase());
    }

    public List<String> getSortedEmails() {
        return new ArrayList<>(emailList);
    }
}

class EmailComparator implements Comparator <String>{

    @Override
    public int compare(String o1, String o2) {
        int result = o1.substring(o1.indexOf("@")).compareTo(o2.substring(o2.indexOf("@")));
        if (result == 0)
            return o1.compareTo(o2);
        return result;
    }
}