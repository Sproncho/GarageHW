package telran.cars.interfaces;

import telran.cars.model.Car;

public interface IGarage {
    public boolean addCar(Car car);
    public Car removeCar(String regNumber);
    public Car findCarByRegNumber(String regNumber);
    public Car[] findCarsByModel(String model);
    public Car[] findCarsByCompany(String company);
    public Car[] findCarsByEngine(double min, double max);
    public Car[] findCarsByColor(String color);
}
