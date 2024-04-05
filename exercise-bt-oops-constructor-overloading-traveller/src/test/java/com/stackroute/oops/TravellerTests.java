package com.stackroute.oops;


import com.stackroute.oops.Traveller;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TravellerTests {

    private static final String INITIALIZE_OBJECT_MESSAGE = "use the default constructor for initialization of object with default values of properties";
    private static final String OVERLOADED_CONSTRUCTOR_ONE_PARAM = "check the overloading of constructor with one argument and rest of the params set to default values";
    private static final String OVERLOADED_CONSTRUCTOR_TWO_PARAMS = "check the overloading of constructor with two arguments and rest of the params set to default values";
    private static final String OVERLOADED_CONSTRUCTOR_THREE_PARAMS = "check the overloading of constructor with three arguments and rest of the params set to default values";
    private static final String OVERLOADED_CONSTRUCTOR_FOUR_PARAMS = "check the overloading of constructor with all arguments set to proper values";
    private static final String TRAVELLER_DETAILS_MESSAGE = "details returned by getTravellerDetails method is not correct or not as per required format";
    private Traveller traveller;

    @BeforeEach
    public void setUp() {

        traveller = new Traveller();
    }

    @AfterEach
    public void tearDown() {

        traveller = null;
    }

    @Test
    public void givenTravellerObjectWhenDefaultConstructorUsedThenPropertiesAreInitializedToDefaultValues() {

        assertEquals(0, traveller.getId(), INITIALIZE_OBJECT_MESSAGE);
        assertEquals(0.0, traveller.getPrice(), INITIALIZE_OBJECT_MESSAGE);
        assertNull(traveller.getTravelType(), INITIALIZE_OBJECT_MESSAGE);
        assertNull(traveller.getLocations(), INITIALIZE_OBJECT_MESSAGE);

    }

    @Test
    public void givenOneTravellerObjectPropertyWhenTravellerObjectCreatedThenOnePropertyInitialised() {

        traveller = new Traveller(1);
        assertEquals(1, traveller.getId(), OVERLOADED_CONSTRUCTOR_ONE_PARAM);
        assertEquals(0.0, traveller.getPrice(), OVERLOADED_CONSTRUCTOR_ONE_PARAM);
        assertNull(traveller.getTravelType(), OVERLOADED_CONSTRUCTOR_ONE_PARAM);
        assertNull(traveller.getLocations(), OVERLOADED_CONSTRUCTOR_ONE_PARAM);

    }

    @Test
    public void givenTwoTravellerObjectPropertiesWhenTravellerObjectCreatedThenTwoPropertiesInitialised() {

        traveller = new Traveller(1, "Marine");
        assertEquals(1, traveller.getId(), OVERLOADED_CONSTRUCTOR_TWO_PARAMS);
        assertEquals(0.0, traveller.getPrice(), OVERLOADED_CONSTRUCTOR_TWO_PARAMS);
        assertEquals("Marine", traveller.getTravelType(), OVERLOADED_CONSTRUCTOR_TWO_PARAMS);
        assertNull(traveller.getLocations(), OVERLOADED_CONSTRUCTOR_TWO_PARAMS);

    }

    @Test
    public void givenThreeTravellerObjectPropertiesWhenTravellerObjectCreatedThenThreePropertiesInitialised() {

        traveller = new Traveller(1, "Land", 2000.0);
        assertEquals(1, traveller.getId(), OVERLOADED_CONSTRUCTOR_THREE_PARAMS);
        assertEquals(2000.0, traveller.getPrice(), OVERLOADED_CONSTRUCTOR_THREE_PARAMS);
        assertEquals("Land", traveller.getTravelType(), OVERLOADED_CONSTRUCTOR_THREE_PARAMS);
        assertNull(traveller.getLocations(), OVERLOADED_CONSTRUCTOR_THREE_PARAMS);

    }

    @Test
    public void givenFourTravellerObjectPropertyWhenTravellerObjectCreatedThenFourPropertiesInitialised() {

        List<String> locations = new ArrayList<>();

        locations.add("GOA");
        locations.add("VIZAG");
        locations.add("CENNAI");
        traveller = new Traveller(1, "Air", 200000.0, locations);
        assertEquals(1, traveller.getId(), OVERLOADED_CONSTRUCTOR_FOUR_PARAMS);
        assertEquals(200000.0, traveller.getPrice(), OVERLOADED_CONSTRUCTOR_FOUR_PARAMS);
        assertEquals("Air", traveller.getTravelType(), OVERLOADED_CONSTRUCTOR_FOUR_PARAMS);
        assertNotNull(traveller.getLocations(), OVERLOADED_CONSTRUCTOR_FOUR_PARAMS);
    }


    @Test
    public void givenTravellerObjectThenGetTravellerDetails() {
        List<String> locations = new ArrayList<>();

        locations.add("GOA");
        locations.add("VIZAG");
        locations.add("CHENNAI");
        traveller = new Traveller(1, "Land", 200000.0, locations);
        var travellerDetails = traveller.getTravellerDetails();
        String expectedDetails = "Traveller{Id=1, price=200000.0, travelType='Land', locations=[goa, vizag, chennai]}";
        final var regex = "//s+";
        assertEquals(expectedDetails.toLowerCase().replaceAll(regex, " "), travellerDetails.toLowerCase().replaceAll(regex, " "), TRAVELLER_DETAILS_MESSAGE);
    }
}