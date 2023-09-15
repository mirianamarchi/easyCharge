package it.ecteam.easycharge.controller;


import it.ecteam.easycharge.dao.CarDao;
import it.ecteam.easycharge.entity.Car;

public class CarController {
    public Car getCar(String name) {
        CarDao cd = new CarDao();

        Car result = cd.getCar(name);
        if (result == null)	{
            return null;
        } else {
            return result;
        }
    }
}
