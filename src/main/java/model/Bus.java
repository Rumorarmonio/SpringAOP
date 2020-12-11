package model;

import java.util.Objects;

public class Bus {

    private int id, routeNumber, busNumber, yearOfBeginning, mileage;
    private String surname, model;

    public Bus(int id, int routeNumber, int busNumber, String surname, String model, int yearOfBeginning, int mileage) {
        this.id = id;
        this.routeNumber = routeNumber;
        this.busNumber = busNumber;
        this.surname = surname;
        this.model = model;
        this.yearOfBeginning = yearOfBeginning;
        this.mileage = mileage;
    }

    public Bus() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(int routeNumber) {
        this.routeNumber = routeNumber;
    }

    public int getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(int busNumber) {
        this.busNumber = busNumber;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfBeginning() {
        return yearOfBeginning;
    }

    public void setYearOfBeginning(int yearOfBeginning) {
        this.yearOfBeginning = yearOfBeginning;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return String.format("|%-3d|%-15d|%-15d|%-17s|%-17s|%-24d|%-7d|", this.id, this.routeNumber, this.busNumber, this.surname, this.model, this.yearOfBeginning, this.mileage);
    }

    public static String getTableCaption() {
        return String.format("|%-3s|%-15s|%-15s|%-17s|%-17s|%-24s|%-7s|", "id", "Номер маршрута", "Номер автобуса", "Фамилия водителя", "Модель", "Год начала эксплуатации", "Пробег");
    }

    public String getLine() {
        return String.format("+%-3s+%-15s+%-15s+%-17s+%-17s+%-24s+%-7s+", "id", "", "", "", "", "", "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;
        return id == bus.id &&
                routeNumber == bus.routeNumber &&
                busNumber == bus.busNumber &&
                surname == bus.surname &&
                model == bus.model &&
                yearOfBeginning == bus.yearOfBeginning &&
                mileage == bus.mileage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, routeNumber, busNumber, surname, model, yearOfBeginning, mileage);
    }
}