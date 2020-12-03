import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String boxes = scanner.nextLine();

        int boxesCount = Integer.parseInt(boxes);
        int boxNumber = 1;
        int trucks = 1;
        int containers = 1;

        int boxesInContainer = 27;
        int containersInTruck = 12;

        for (; boxNumber <= boxesCount; trucks++) {
            System.out.print("Грузовик: " + trucks + System.lineSeparator());
            for (int i = 0; i < containersInTruck; i++) {
                if (boxNumber > boxesCount)
                    break;
                System.out.print("\tКонтейнер: " + containers + System.lineSeparator());
                for (int j = 0; j < boxesInContainer; j++) {
                    if (boxNumber > boxesCount)
                        break;
                    System.out.print("\t\tЯщик: " + boxNumber + System.lineSeparator());
                    boxNumber++;
                }
                containers++;
            }
        }
        System.out.println("Необходимо:");
        System.out.println("грузовиков - " + (trucks-1) + " шт.");
        System.out.println("контейнеров - " + (containers-1) + " шт.");
    }
}