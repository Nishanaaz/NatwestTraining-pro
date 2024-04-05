package com.stackroute.exercises;


import java.util.ArrayList;
import java.util.List;

public class CarDetailsListCreation {
    private List<Car> carList;

    public CarDetailsListCreation() {
        carList = new ArrayList<>();
    }

    public String getCarDetails() {
        return carList.toString();
    }

    //Write here logic to add value to global list variable
    public void setCarDetails(String modelName, String manufacturerName, int engineCapacity, String carType) throws WrongInputException,OutOfRangeException {
        if (modelName == null || modelName.trim().isEmpty() ||
                manufacturerName == null || manufacturerName.trim().isEmpty() ||
                carType == null) {
            throw new WrongInputException("Input might contain a null or empty or blank space value");
        }
        else if (engineCapacity <1000  || engineCapacity >10000) {
            throw new OutOfRangeException("EngineCapacity is out of range(1000 to 10000)");
        } else if (carType==null || carType.equals("") || carType.equals(" ")) {
            throw new WrongInputException("Input might contain a null or empty or blank space value");

        } else if (!carType.equalsIgnoreCase("SUV") && !carType.equalsIgnoreCase("SEDAN") && !carType.equalsIgnoreCase("PICKUPTRUCK") && !carType.equalsIgnoreCase("HatchBack")) {
            throw new WrongInputException("CarType '"+carType+"' is not present in the enumeration");
        }
        carList.add(new Car(modelName, manufacturerName, engineCapacity, carType));
    }
}
