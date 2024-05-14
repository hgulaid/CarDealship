package com.pluralsight.Models;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Scanner;

public class FileReaderManager {

    // takes all the info from the csv file
//only cars about dealership file

        //reads through inventory file
        public static Dealership csvReader(String filename){
            File file = new File(filename);
            try (Scanner scanner = new Scanner(file)){
                String line = scanner.nextLine();
                String [] parts = line.split("\\|");
                Dealership dealership = new Dealership(parts[0], parts[1],parts[2]);


                while (scanner.hasNextLine()){
                    line = scanner.nextLine();
                    parts = line.split("\\|");
                    int vin = Integer.parseInt(parts[0]);
                    int year = Integer.parseInt(parts[1]);
                    String make = parts[2].trim();
                    String model = parts[3].trim();
                    String vehicleType = parts[4];
                    String color = parts[5].trim();
                    int odometer = Integer.parseInt(parts[6]);
                    double price = Double.parseDouble(parts[7].trim());
                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                    dealership.addVehicle(vehicle);

                }
                return dealership;
            }catch (IOException | ArrayIndexOutOfBoundsException | NumberFormatException exception){
                System.out.println("Sorry there was a problem: " + exception.getMessage());
            }

            return null;
        }

        // writes new things into csv file and saves






    // writes new things into csv file and saves

    public static void WriteDealToCsv(String filename, Dealership dealership)  {
        File file = new File(filename);


        try (FileWriter write = new FileWriter(filename);
             PrintWriter writer = new PrintWriter(write))
        {
            // print the first line as dealer info
            //writer.println();
            String dealerInfo = String.format("%s|%s|%s", dealership.getName(), dealership.getAddress(), dealership.getPhone());
            writer.println(dealerInfo);


            for(Vehicle vehicle: dealership.getAllVehicles())
            {
                String vehicleData = String.format("%d|%d|%s|%s|%s|%s|%d|%.2f%n",
                        vehicle.getVin(), vehicle.getYear(), vehicle.getMake(),
                        vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(),
                        vehicle.getOdometer(), vehicle.getPrice());
                writer.print(vehicleData);

            }


        } catch (IOException e) {
            throw new RuntimeException("Error writing to CSV file: " + e.getMessage());
        }
    }

}
