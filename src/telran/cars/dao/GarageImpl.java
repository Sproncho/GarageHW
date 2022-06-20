package telran.cars.dao;

import telran.cars.interfaces.IGarage;
import telran.cars.model.Car;

import java.util.function.Predicate;

public class GarageImpl implements IGarage {

    private Car[] cars;
    private int size = 0;
    private int capacity;

    public GarageImpl(int capacity) {
        this.capacity = capacity;
        cars = new Car[capacity];
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean addCar(Car car) {
        if(findCarByRegNumber(car.getRegNumber()) != null)
            return false;
        cars[size] = car;
        size++;
        return true;
    }

    @Override
    public Car removeCar(String regNumber) {
        for (int i = 0; i < size; i++) {
            if(cars[i].getRegNumber() == regNumber){
                Car car = cars[i];
                cars[i] = cars[size-1];
                cars[size - 1] = null;
                size--;
                return car;
            }
        }
        return null;
    }

    @Override
    public Car findCarByRegNumber(String regNumber) {
        Car[] res =findCarsByPredicate(car -> car.getRegNumber().equals(regNumber));
        return res.length == 0? null : res[0];
    }

    @Override
    public Car[] findCarsByModel(String model) {
        return findCarsByPredicate(car -> car.getModel().equals(model));
    }

    @Override
    public Car[] findCarsByCompany(String company) {

        return findCarsByPredicate(car -> car.getCompany().equals(company));
    }

    @Override
    public Car[] findCarsByEngine(double min, double max) {
        return findCarsByPredicate(car -> car.getEngine()>min && car.getEngine()<max);
    }

    @Override
    public Car[] findCarsByColor(String color) {

        return findCarsByPredicate(car -> car.getColor().equals(color));
    }

    public int size(){
        return size;
    }
    private Car[] findCarsByPredicate(Predicate<Car> predicate) {
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (predicate.test(cars[i])){
                counter++;
            }
        }
        Car[] result = new Car[counter];
        int ind = 0;
        for (int i = 0; i < size; i++) {
            if (predicate.test(cars[i])){
                result[ind++] = cars[i];
            }
        }
        return result;
    }
}
