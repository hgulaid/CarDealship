package com.pluralsight;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Scanner;
import com.pluralsight.Models.Dealership;
import com.pluralsight.Models.FileReaderManager;
import com.pluralsight.Models.Vehicle;


import java.util.*;

public class UserInterface {


    public static Scanner userInput = new Scanner(System.in);
    private Dealership dealership;


    public UserInterface()
    {
        // when you start your app
        // you load all dealership info
        dealership = FileReaderManager.csvReader("files/inventory.csv");
    }



    public void run()
    {
        // display the home screen
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 99) {
            try {
                // Welcome the user to the program
                System.out.println("Welcome to Our Dealership!");
                System.out.println("-".repeat(70));

                System.out.println();
                System.out.println("1.) Find vehicles within a price range");
                System.out.println("2.) Find vehicles by make/model");
                System.out.println("3.) Find vehicles by price range");
                System.out.println("4.) Find vehicles by color");
                System.out.println("5.) Find vehicles by mileage range");
                System.out.println("6.) Find vehicles by type (car, truck, SUV, van)");
                System.out.println("7.) List all vehicles");
                System.out.println("8.) Add a vehicle");
                System.out.println("9.) Remove a vehicle");
                System.out.println("99.) Quit");
                System.out.print("Enter your choice: ");





                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        displayVehicleByPrice();
                        break;

                    case 2:
                        displayVehiclesByMakeModel();
                        System.out.println("sdfsdf");
                        break;

                    case 3:
                        displayVehicleByYear();
                        break;

                    case 4:
                        displayVehiclesByColor();
                        break;

                    case 5:

                        displayVehiclesByMileage();
                        System.out.println();
                        break;

                    case 6:
                        displayAllVehicles();
                        System.out.println("");
                        break;

                    case 7:
                        displayAllVehicles();
                        break;

                    case 8:
                        addVehicles();
                        break;

                    case 9:
                        removeVehicle();

                        break;

                    case 99:
                        FileReaderManager.WriteDealToCsv("files/inventory.csv", dealership);
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid input, Press Enter to try again.");
                        System.out.println();
                        break;
                }
                System.out.println();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input please enter a number.");
                System.out.println();
                System.out.println();

            }catch (Exception exception)
            {
                System.out.println();
                System.out.println("Sorry, we encountered a problem.");
                System.out.println();
                System.out.println();

            }
        }




    }

    private void removeVehicle() {
        System.out.println("Remove a vehicle");
        System.out.println("-".repeat(60));

        System.out.println("Please enter the vin of the vehicle you'd like to remove from the inventory:");

        int carVin = userInput.nextInt();
        boolean removed = false;

        for (Vehicle vehicle: dealership.getAllVehicles()){
            if (vehicle.getVin() == carVin){
                dealership.removeVehicle(vehicle);
                removed = true;
                break;
            }
            }
        if (!removed) {
            System.out.println("There is no vehicle that matches " + carVin);

        }





    }

    private void addVehicles() {

        // get vehicle info
        //Vehicle vehicle = new Vehicle();
        //dealership.addVehicle(vehicle);
        System.out.println("Add a vehicle");
        System.out.println("-".repeat(60));
        System.out.print("Please enter the vin of the vehicle: ");
        int vin = userInput.nextInt();
        System.out.print("Please enter the year of the vehicle: ");
        int year = userInput.nextInt();
        System.out.print("Please enter the make of the vehicle: ");
        String make = userInput.next();
        System.out.println();
        System.out.println("Please enter the model of the vehicle: ");
        String model = userInput.next();
        System.out.print("Please enter the type of the vehicle: ");
        String vehicleType = userInput.next();
        System.out.print("Please enter the color of the vehicle: ");
        String color = userInput.next();
        System.out.print("Please enter the odometer number of the vehicle: ");
        int odometer = userInput.nextInt();
        System.out.print("Please enter the price of the vehicle: ");
        double price = userInput.nextDouble();

        Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(newVehicle);
        System.out.println("Vehicle added successfully.");


    }

    private void displayAllVehicles() {
        System.out.println("Here is all of our vehicles");
        System.out.println("-".repeat(60));


        for(Vehicle vehicle: dealership.getAllVehicles())
        {
            //System.out.println(vehicle.getMake());
            printVehicleInfo(vehicle);

        }


    }

    private void displayVehiclesByMileage() {
    }

    private void displayVehiclesByColor() {
    }

    private void displayVehicleByYear() {
    }

    private void displayVehiclesByMakeModel() {
    }

    private void displayVehicleByPrice() {
        // get the price search range
        for(Vehicle vehicle: dealership.getAllVehicles())
        {

        }
    }


    private void printVehicleInfo(Vehicle vehicle)
    {
        String vehicleInfo = String.format("VIN:%-10d  Year:%-10d  Make:%-10s  Model:%-10s  Type:%-10s  Color:%-10s  Odometer:%-10d miles  Price:$%-10.2f", vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());

        System.out.println(vehicleInfo);
    }



}




