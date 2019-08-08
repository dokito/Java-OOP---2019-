import core.ManagerControllerImpl;
import core.interfaces.ManagerController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ManagerController managerController = new ManagerControllerImpl();

        String input = scanner.nextLine();

        while (!input.equals("Exit")) {
            String[] tokensInput = input.split("\\s+");
            String command = tokensInput[0];
            if (command.equals("AddPlayer")){
                String[] tokens = input.split("\\s+");
                String type = tokens[1];
                String username = tokens[2];

                System.out.println(managerController.addPlayer(type, username));
            } else if (command.equals("AddCard")) {
                String[] tokens = input.split("\\s+");
                String type = tokens[1];
                String username = tokens[2];

                System.out.println(managerController.addCard(type, username));
            } else if (command.equals("AddPlayerCard")) {
                String[] tokens = input.split("\\s+");
                String username = tokens[1];
                String cardName = tokens[2];

                System.out.println(managerController.addPlayerCard(username, cardName));
            } else if (command.equals("Fight")) {
                String[] tokens = input.split("\\s+");

                String attackPlayer = tokens[1];
                String enemyPlayer = tokens[2];

                System.out.println(managerController.fight(attackPlayer, enemyPlayer));
            } else if (command.equals("Report")) {

                System.out.println(managerController.report());
            }

            input = scanner.nextLine();
        }
    }
}
