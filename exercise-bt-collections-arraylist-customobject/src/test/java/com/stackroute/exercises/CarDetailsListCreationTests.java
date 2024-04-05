package com.stackroute.exercises;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarDetailsListCreationTests {

    private CarDetailsListCreation carDetailsListCreation;
    private String expectedErrorMessage = "Input might contain a null or empty or blank space value";
    private String errorMessage = "The input function should throw WrongInputException when either of the input is ";


    @BeforeEach
    public void setUp() throws OutOfRangeException, WrongInputException {
        carDetailsListCreation = new CarDetailsListCreation();
        carDetailsListCreation.setCarDetails("Vitara Brezza", "MarutiSuzuki", 1000, "suv");
        carDetailsListCreation.setCarDetails("Innova", "Toyota", 2200, "SUV");
        carDetailsListCreation.setCarDetails("Rapid", "Skoda", 1500, "Sedan");
        carDetailsListCreation.setCarDetails("M3Competition", "BMW", 3500, "sedan");
        carDetailsListCreation.setCarDetails("Micra", "Nissan", 1200, "hatchback");
    }

    @AfterEach
    public void tearDown() {
        carDetailsListCreation = null;
    }

    @Test
    public void givenStringAndIntegerThenReturnAStringResult() throws OutOfRangeException, WrongInputException {
        carDetailsListCreation.setCarDetails("F-150", "Ford", 5800, "Pickuptruck");
        String expectedResult = "[{modelName: 'Vitara Brezza', manufacturerName: 'MarutiSuzuki', engineCapacity: 1000, carType: 'suv'}," +
                " {modelName: 'Innova', manufacturerName: 'Toyota', engineCapacity: 2200, carType: 'SUV'}," +
                " {modelName: 'Rapid', manufacturerName: 'Skoda', engineCapacity: 1500, carType: 'Sedan'}," +
                " {modelName: 'M3Competition', manufacturerName: 'BMW', engineCapacity: 3500, carType: 'sedan'}," +
                " {modelName: 'Micra', manufacturerName: 'Nissan', engineCapacity: 1200, carType: 'hatchback'}," +
                " {modelName: 'F-150', manufacturerName: 'Ford', engineCapacity: 5800, carType: 'Pickuptruck'}]";
        assertEquals(expectedResult, carDetailsListCreation.getCarDetails(), "Check the logic in method getCarDetails");
    }

    @Test
    public void givenWrongIntegerInputThenThrowException() {
        assertEquals("EngineCapacity is out of range(1000 to 10000)",
                assertThrows(OutOfRangeException.class, () -> carDetailsListCreation.setCarDetails("alto", "MarutiSuzuki", 900, "HatchBack")).getMessage(),
                "the input function should throw OutOfRangeException when engineCapacity is less than 1000cc or carType is not HatchBack,SUV,Sedan");
        assertEquals("EngineCapacity is out of range(1000 to 10000)",
                assertThrows(OutOfRangeException.class, () -> carDetailsListCreation.setCarDetails("F-350", "Ford", 12000, "pickuptruck")).getMessage(),
                "the input function should throw OutOfRangeException when engineCapacity is less than 1000cc or carType is not HatchBack,SUV,Sedan");
    }

    @Test
    public void givenWrongStringInputThenThrowException() {
        assertEquals("CarType 'estate' is not present in the enumeration",
                assertThrows(WrongInputException.class, () -> carDetailsListCreation.setCarDetails("alto", "MarutiSuzuki", 1200, "estate")).getMessage(),
                "The input function should throw WrongInputException when carType is not present in enum class");
    }

    @Test
    public void givenNullStringInputThenThrowException() {
        assertEquals(expectedErrorMessage,
                assertThrows(WrongInputException.class, () -> carDetailsListCreation.setCarDetails(null, "MarutiSuzuki", 1200, "HatchBack")).getMessage(),
                errorMessage + "null");
        assertEquals(expectedErrorMessage,
                assertThrows(WrongInputException.class, () -> carDetailsListCreation.setCarDetails("alto", null, 1200, "HatchBack")).getMessage(),
                errorMessage + "null");
        assertEquals(expectedErrorMessage,
                assertThrows(WrongInputException.class, () -> carDetailsListCreation.setCarDetails("alto", "MarutiSuzuki", 1200, null)).getMessage(),
                errorMessage + "null");
    }

    @Test
    public void givenEmptyStringInputThenThrowException() {
        assertEquals(expectedErrorMessage,
                assertThrows(WrongInputException.class, () -> carDetailsListCreation.setCarDetails("", "MarutiSuzuki", 1200, "HatchBack")).getMessage(),
                errorMessage + "empty");
        assertEquals(expectedErrorMessage,
                assertThrows(WrongInputException.class, () -> carDetailsListCreation.setCarDetails("alto", "", 1200, "HatchBack")).getMessage(),
                errorMessage + "empty");
        assertEquals(expectedErrorMessage,
                assertThrows(WrongInputException.class, () -> carDetailsListCreation.setCarDetails("alto", "MarutiSuzuki", 1200, "")).getMessage(),
                errorMessage + "empty");
    }

    @Test
    public void givenBlankSpaceStringInputThenThrowException() {
        assertEquals(expectedErrorMessage,
                assertThrows(WrongInputException.class, () -> carDetailsListCreation.setCarDetails(" ", "MarutiSuzuki", 1200, "HatchBack")).getMessage(),
                errorMessage + "blank space");
        assertEquals(expectedErrorMessage,
                assertThrows(WrongInputException.class, () -> carDetailsListCreation.setCarDetails("alto", " ", 1200, "HatchBack")).getMessage(),
                errorMessage + "blank space");
        assertEquals(expectedErrorMessage,
                assertThrows(WrongInputException.class, () -> carDetailsListCreation.setCarDetails("alto", "MarutiSuzuki", 1200, " ")).getMessage(),
                errorMessage + "blank space");
    }


}
