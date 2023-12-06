package org.axe;

import org.axe.Controller.CustomerController;
import org.axe.view.Menu;

public class Main {
    public static void main(String[] args) {
        CustomerController controller = new CustomerController();
        Menu menu = new Menu(controller);

        menu.showMenu();

        System.out.println("Exiting app!");
    }
}