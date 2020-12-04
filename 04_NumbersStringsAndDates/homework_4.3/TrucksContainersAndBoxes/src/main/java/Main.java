import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String boxes = scanner.nextLine();

        int boxesCount = Integer.parseInt(boxes);
        int boxNumber = 0;
        int trucks = 0;
        int containers = 0;

        int boxesInContainer = 27;
        int containersInTruck = 12;

        while (boxNumber < boxesCount) {
            if (boxNumber % (boxesInContainer * containersInTruck) == 0){
                trucks++;
                System.out.print("Грузовик: " + trucks + System.lineSeparator());
            }
            if (boxNumber % boxesInContainer == 0){
                containers++;
                System.out.print("\tКонтейнер: " + containers + System.lineSeparator());
            }
            boxNumber++;
            System.out.print("\t\tЯщик: " + boxNumber + System.lineSeparator());
        }

        System.out.println("Необходимо:");
        System.out.println("грузовиков - " + (trucks) + " шт.");
        System.out.println("контейнеров - " + (containers) + " шт.");
    }
}