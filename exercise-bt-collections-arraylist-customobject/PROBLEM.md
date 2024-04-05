## Problem Statement: Write a program to create a car catalog using Arrraylist with custom class Object

**Given car details like Model Name,Manufacturer Name,Engine Capacity,Car Type create a
Arraylist of car details with a custom object as List datatype**

**This exercise contains a class named CarDetailsListCreation with the following methods:**

     +getCarDetails() : String  
         - Should return a string as result
     +setCarDetails(String, String, int, String)  
         - Should take three String and a integer as input
         - Should validate the inputs against specific conditions     
         - Should throw exception when validation fails          

## Example
    Sample Input:
    "Vitara Brezza","MarutiSuzuki",1000,"suv"       
    
    Expected Output:
    [{modelName: 'Vitara Brezza', manufacturerName: 'MarutiSuzuki', engineCapacity: 1000, carType: 'suv'}]
--------------------------------------------------------
    Sample Input:
    null,"MarutiSuzuki",1200,"HatchBack"
        
    Expected Output:
    WrongInputException: Input might contain a null or empty or blank space value

## Instructions

- Avoid printing unnecessary values other than expected output as given in sample
- Take care of whitespace/trailing whitespace
- Do not change the provided class/method names unless instructed
- Follow best practices while coding