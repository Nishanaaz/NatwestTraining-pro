## Problem Statement: Implementing Constructor Overloading 

A constructor is a special method which is used to initialize a newly created object and is called 
just after the memory is allocated for the object. It can be used to initialize the objects to 
desired values or default values at the time of object creation. 

   Important points:
   
- If no user-defined constructor is provided for a class, 
compiler initializes member variables to its default values:
    Numeric data types are set to 0
    Char data types are set to null character(‘\0’)
    Reference variables are set to null
- Constructor has the same name as the class
- Constructor should not return a value not even void

Complete the class Traveller as per the below requirement

**class Traveller**


Define the following properties. properties should be private:

        -id             : int 
        -travelType     : String 
        -price          : double
        -locations      : List

- Define Getters and setters for all properties 

- Define the following constructors:

            +Default constructor
            +Parameterised constructor with one property - id
            +Parameterised constructor with two properties- id,travelType
            +Parameterised constructor with three properties- id,travelType,price
            +Parameterised constructor with four properties- id,travelType,price,locations
            
- Define the below methods:

        +getTravellerDetails() : String       
           -Should return the Traveller details as per the below format
             Traveller{id=xx, price=xx.x, travelType='xxxxx', locations=xxx}

## Instructions
- Do not change the provided class/method names unless instructed
- Ensure your code compiles without any errors/warning/deprecations 
- Follow best practices while coding
