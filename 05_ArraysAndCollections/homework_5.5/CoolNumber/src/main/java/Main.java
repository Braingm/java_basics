import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    private static final String SUCCESS = "Номер найден, поиск занял (нс) : ";
    private static final String FAILURE = "Номер не найден, поиск занял (нс) : ";
    static long nanoTime;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> hashSet = new HashSet<>(CoolNumbers.coolNumbers);
        TreeSet<String> treeSet = new TreeSet<>(CoolNumbers.coolNumbers);
        ArrayList<String> arrayList = new ArrayList<>(CoolNumbers.coolNumbers);
        ArrayList<String> bruteArrayList = new ArrayList<>(CoolNumbers.coolNumbers);
        Collections.sort(arrayList);

        while (true){
            String input = reader.readLine();

            if (input.equals("0")){
                break;
            }

            nanoTime = System.nanoTime();
            if (CoolNumbers.bruteForceSearchInList(bruteArrayList,input)){
                System.out.println("Поиск перебором: " + SUCCESS + getNanos());
            } else {
                System.out.println("Поиск перебором: " + FAILURE + getNanos());
            }

            nanoTime = System.nanoTime();
            if (CoolNumbers.binarySearchInList(arrayList,input)){
                System.out.println("Бинарный поиск: " + SUCCESS + getNanos());
            } else {
                System.out.println("Бинарный поиск: " + FAILURE + getNanos());
            }

            nanoTime = System.nanoTime();
            if (CoolNumbers.searchInHashSet(hashSet,input)){
                System.out.println("Поиск в HashSet : " + SUCCESS + getNanos());
            } else {
                System.out.println("Поиск в HashSet : " + FAILURE + getNanos());
            }

            nanoTime = System.nanoTime();
            if (CoolNumbers.searchInTreeSet(treeSet,input)){
                System.out.println("Поиск в TreeSet : " + SUCCESS + getNanos());
            } else {
                System.out.println("Поиск в TreeSet : " + FAILURE + getNanos());
            }

        }
    }


    private static long getNanos(){
        return System.nanoTime() - nanoTime;
    }
}
