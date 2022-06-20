package telran.cars.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.cars.model.Car;

import static org.junit.jupiter.api.Assertions.*;

class GarageImplTest {
    GarageImpl garage;
    Car[] cars;
    @BeforeEach
    void setUp() {
        garage = new GarageImpl(10);
        cars = new Car[3];
        cars[0] = new Car("112","sl500","mercedes",450,"black");
        cars[1] = new Car("110","solaris","hyundai",300,"white");
        cars[2] = new Car("100","granta","lada",550,"brown");
        for (int i = 0; i < cars.length; i++) {
            garage.addCar(cars[i]);
        }
    }

    @Test
    void addCar() {
        Car bmw = new Car("111","m5","bmw",250,"black");
        garage.addCar(bmw);
        assertEquals(4,garage.size());
        assertEquals(bmw,garage.findCarByRegNumber("111"));
    }

    @Test
    void removeCar() {
        Car car = garage.removeCar("112");
        assertEquals(cars[0],car);
        assertEquals(2,garage.size());
    }

    @Test
    void findCarByRegNumber() {
        Car car =garage.findCarByRegNumber("112");
        assertEquals(cars[0],car);
    }

    @Test
    void findCarsByModel() {
        Car[] expected = {cars[2]};
        Car[] actual = garage.findCarsByModel("granta");
        assertArrayEquals(expected,actual);
    }

    @Test
    void findCarsByCompany() {
        Car[] expected = {cars[2]};
        Car[] actual = garage.findCarsByCompany("lada");
        assertArrayEquals(expected,actual);
    }

    @Test
    void findCarsByEngine() {
        Car[] expected = {cars[2]};
        Car[] actual = garage.findCarsByEngine(500,1000);
        assertArrayEquals(expected,actual);
    }

    @Test
    void findCarsByColor() {
        Car[] expected = {cars[2]};
        Car[] actual = garage.findCarsByColor("brown");
        assertArrayEquals(expected,actual);
    }
}