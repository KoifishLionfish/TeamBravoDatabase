package org.axe.view;

import org.axe.Controller.CustomerController;
import org.axe.entity.Car;
import org.axe.entity.Customer;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Menu {
    private CustomerController controller;

    public Menu(CustomerController controller) {
        this.controller = controller;
    }

    public void  showMenu(){
        System.out.println("Ange ett val: ");
        System.out.println("1.Lägg till kund");
        System.out.println("2.Uppdatera kund");
        System.out.println("3.Ta bort kund");
        System.out.println("4.Hämta alla kunder");
        System.out.println("5.Hämta kund utifrån id");
        System.out.println("6.Skapa bil");

        handleInput();
    }

    private void handleInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ange ditt val: ");
        int userChoice = Integer.parseInt(scanner.nextLine());
            switch (userChoice){
                case 1:
                    //Lägg till kund
                    System.out.println("Ange kundnamn: ");
                    String customerName = scanner.nextLine();
                    if (controller.save(new Customer(customerName))) {
                        System.out.println(customerName + " tillagad.");

                    } else {
                        System.out.println(customerName + " misslyckades.");
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    //Hämta alla kunder
                    System.out.println("Lista av samtliga kunder:");
                    for (Customer customer : controller.getAll()) {
                        System.out.println(customer.getName());
                    }
                    break;
                case 5:
                    break;
                    case 6:
                        Car car = new Car();
                        Customer customer = new Customer("Micke");
                        customer.addCar(car);
                        if(controller.save(customer)) {
                            System.out.println("Tillagd customer");
                    } else {
                            System.out.println("Gick ej.");
                        }
                    break;
                default:
                    break;
            }
    }
}
