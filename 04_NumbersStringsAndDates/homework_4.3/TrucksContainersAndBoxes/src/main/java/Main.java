import java.util.Scanner;

public class Main {

    static int boxesInContainer = 27;
    static int containersInTruck = 12;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String boxesString = scanner.nextLine();

        int boxesCount = Integer.parseInt(boxesString);
        int boxes = 1;
        int trucks = 1;
        int containers = 1;

        for (; boxes <= boxesCount; trucks++) {
            System.out.println("Грузовик: " + trucks);
            for (int i = 0; i < containersInTruck; i++) {
                if (boxes > boxesCount)
                    break;
                System.out.println("\tКонтейнер: " + containers);
                for (int j = 0; j < boxesInContainer; j++) {
                    if (boxes > boxesCount)
                        break;
                    System.out.println("\t\tЯщик: " + boxes);
                    boxes++;
                }
                containers++;
            }
        }

        System.out.printf("Необходимо:\nгрузовиков - %d шт.\nконтейнеров - %d шт.",(trucks-1),(containers-1));
    }

}
