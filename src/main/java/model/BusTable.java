package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BusTable {

    public List<Bus> fillTheTable(String pathname) throws FileNotFoundException {
        File file = new File(pathname);
        int id, busNumber, routeNumber, yearOfBeginning, mileage;
        String surname, model;
        Scanner input = new Scanner(file);
        int n = input.nextInt();
        List<Bus> buses = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            id = input.nextInt();
            routeNumber = input.nextInt();
            busNumber = input.nextInt();
            input.nextLine();
            surname = input.nextLine();
            model = input.nextLine();
            yearOfBeginning = input.nextInt();
            mileage = input.nextInt();
            buses.add(new Bus(id, routeNumber, busNumber, surname, model, yearOfBeginning, mileage));
        }
        return buses;
    }

    public void printTheTable(List<Bus> buses) {
        for (Bus bus : buses)
            System.out.println(bus);
    }

    public int sortByRouteNumber(List<Bus> buses, int routeNumber) {
        int counter = 0;
        for (Bus bus : buses)
            if (bus.getRouteNumber() == routeNumber) {
                counter++;
                System.out.println(bus);
            }
        return counter;
    }

    public int sortByNumberOfYears(List<Bus> buses, int currentYear, int numberOfYears) {
        int counter = 0;
        for (Bus bus : buses)
            if (currentYear - bus.getYearOfBeginning() > numberOfYears) {
                counter++;
                System.out.println(bus);
            }
        return counter;
    }

    public int sortModelByMileage(List<Bus> buses, String model, int mileage) {
        int counter = 0;
        for (Bus bus : buses)
            if (bus.getModel().equals(model) && bus.getMileage() > mileage) {
                counter++;
                System.out.println(bus);
            }
        return counter;
    }

    public int sortByModel(List<Bus> buses) {
        int i, j, n = buses.size(), counter = 0;
        Bus temp;
        for (i = 0; i <= n; i++)
            for (j = n - 2; j >= i; j--)
                if (buses.get(j).getModel().compareToIgnoreCase(buses.get(j + 1).getModel()) > 0) {
                    temp = buses.get(j);
                    buses.set(j, buses.get(j + 1));
                    buses.set(j + 1, temp);
                }
        for (Bus bus : buses) {
            System.out.println(bus);
            counter++;
        }
        return counter;
    }
}