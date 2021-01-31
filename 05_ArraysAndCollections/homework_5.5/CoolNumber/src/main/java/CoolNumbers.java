import java.util.*;

public class CoolNumbers {
    public static List<String> coolNumbers;

    static {
        coolNumbers = generateCoolNumbers();
    }

    public static List<String> generateCoolNumbers() {
        List<String> numbers = new ArrayList<>();
        char[] letters = {'А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'};

        for (char s1 : letters) {
            for (char s2 : letters) {
                for (char s3 : letters) {
                    for (int i = 0; i < 10; i++) {
                        for (int r = 1; r <= 199; r++) {
                            String region = String.valueOf(r);
                            if (r <= 9) {
                                region = "0" + region;
                            }
                            String number = String.format("%s%d%d%d%s%s%s", s1, i, i, i, s2, s3, region);
                            numbers.add(number);
                        }
                    }
                }
            }
        }
        return numbers;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        return list.contains(number);
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        return Collections.binarySearch(sortedList, number) >= 0;
    }


    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        return hashSet.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }

}