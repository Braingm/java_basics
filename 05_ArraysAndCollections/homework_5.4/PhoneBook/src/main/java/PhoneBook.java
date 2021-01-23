import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class PhoneBook {
    private HashMap<String, Set<String>> contacts = new HashMap<>();

    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона
        // если такой номер уже есть в списке, то перезаписать имя абонента

        if (phone == "" || name == "") {
            return;
        }
        if (!name.matches("\\W+[^\\d]")) {
            return;
        }
        if (!phone.matches("\\d{11}")) {
            return;
        }

        if (!this.getNameByPhone(phone).equals("")) {
            String[] array = getNameByPhone(phone).split("-");
            String tmpName = array[0].trim();
            contacts.get(tmpName).remove(phone);
            if (contacts.get(tmpName).isEmpty()) {
                contacts.remove(tmpName.trim());
            }
        }
        if (contacts.containsKey(name)) {
            contacts.get(name).add(phone);
        } else {
            Set<String> numbers = new TreeSet<>();
            numbers.add(phone);
            contacts.put(name, numbers);
        }
    }

    public String getNameByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку

        for (String key : contacts.keySet()) {
            for (String contactPhone : contacts.get(key)) {
                if (contactPhone.equals(phone))
                    return contactFormat(key);
            }
        }
        return "";
    }

    public Set<String> getPhonesByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet

        if (contacts.containsKey(name)) {
            TreeSet<String> result = new TreeSet<>();
            result.add(contactFormat(name));
            return result;
        }
        return new TreeSet<>();
    }

    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet

        if (contacts.isEmpty())
            return new TreeSet<>();

        Set<String> result = new TreeSet<>();
        for (String key : contacts.keySet()) {
            result.add(contactFormat(key));
        }
        return result;
    }

    public boolean containsName(String name) {
        return contacts.containsKey(name);
    }

    private String contactFormat(String key) {
        StringBuilder result = new StringBuilder();
        String number = contacts.get(key).toString();
        result.append(key)
                .append(" - ")
                .append(number, 1, number.length() - 1);
        return result.toString();
    }

    public boolean containsNumber(String number) {
        for (Set<String> set : contacts.values()) {
            if (set.contains(number)) {
                return true;
            }
        }
        return false;
    }
}