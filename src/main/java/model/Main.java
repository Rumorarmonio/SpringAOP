package model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BusTable busTable = context.getBean("busTable", BusTable.class);
        Bus bus = context.getBean("bus", Bus.class);
        List<Bus> buses = busTable.fillTheTable("input.txt");
        System.out.println("Список всех автобусов: ");
        System.out.println(bus.getTableCaption());
        busTable.printTheTable(buses);
        System.out.println("\nСписок автобусов для заданного номера маршрута: ");
        System.out.println(bus.getTableCaption());
        busTable.sortByRouteNumber(buses, 80);
        System.out.println("\nСписок автобусов, которые эксплуатируются больше заданного количества лет (вводится текущий год и количество лет): ");
        System.out.println(bus.getTableCaption());
        busTable.sortByNumberOfYears(buses, 2020, 13);
        System.out.println("\nСписок автобусов заданной модели, пробег у которых больше заданного количества км: ");
        System.out.println(bus.getTableCaption());
        busTable.sortModelByMileage(buses, "ПАЗ-32054", 310000);
        System.out.println("\nСписок всех записей, отсортированный по модели: ");
        System.out.println(bus.getTableCaption());
        busTable.sortByModel(buses);
    }
}