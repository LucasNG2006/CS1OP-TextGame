import java.util.Scanner;

public class TextUI {

    private static final Scanner scanner = new Scanner(System.in);

  
    public static void print(String text) {
        System.out.println(text);
    }

    
    public static void printSlow(String text) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            System.out.flush();
            try { Thread.sleep(18); } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }


    public static void divider() {
        System.out.println("\n" + "=".repeat(60) + "\n");
    }


    public static void pressEnter() {
        System.out.print("\n[Press Enter to continue...]");
        System.out.flush();
        scanner.nextLine();
    }

  
    public static int getChoice(int max) {
        while (true) {
            System.out.print("> ");
            System.out.flush();
            String input = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= max) return choice;
                System.out.println("Please enter a number between 1 and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

   
    public static void printTitle(String title) {
        divider();
        System.out.println("  " + title.toUpperCase());
        divider();
    }

    
    public static void printStatus(int health, int maxHealth) {
        System.out.println("[Health: " + health + "/" + maxHealth + "]");
    }
}
