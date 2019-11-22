package ma.sqli.test.itevent;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ma.sqli.entities.Event;
import ma.sqli.entities.Hotel;

/**
 * This exercise is about organizing an IT event. If you attended the Devoxx Morocco event that was organized this week, the problem we are trying to solve will sound familiar to you ;)
 * Our objective is to provide event organizers a small tool to help them manage hotel reservations for attendees, speakers and staff.
 * Here are some important information and some rules to follow :
 *  - The event last 3 days, the first day for 2 hours sessions (called deep dive), while the second and third days are for sessions of 50 minutes at most.
 *  - All attendees can buy one of these 3 offers :
 *       -- Conference days : they can only attend the second and third days
 *       -- Deep Dive : they can only attend the first day
 *       -- Tringa : they can attend the entire three days
 *  - All reservations are done in the same Hotel.
 *  - All rooms are individual; The hotel capacity is as such:
 *       -- Standard room, (room numbers between 1 and 100)
 *       -- Suites, (room numbers between 101 and 200)
 *       -- Apartments, (room numbers between 201 and 300)
 *  - All attendees and staff members book standard rooms by default; If there are no more standard room, they book apartments instead.
 *  - Suites are for Speakers only.
 */
public class EventTest {

    private Event event;
    private Hotel hotel;

    @Before
    public void initialize_test_data() {
        int standardRooms = 12;
        int suites = 5;
        int apparts = 15;
        hotel = new Hotel(standardRooms, suites, apparts);
        event = new Event(hotel);
    }

     
    
    @Test
    public void can_register_a_tringa_attendee_in_event() {

        Assert.assertEquals(true, event.register("TRINGA", "Mohammed"));

    }

    @Test
    public void can_not_register_same_name_twice() {
        event.register("TRINGA", "Mohammed");
        Assert.assertEquals(false, event.register("TRINGA", "Mohammed"));
    }

    @Test
    public void can_check_hotel_status() {
        Assert.assertEquals("Standard rooms: 12|Suites: 5|Aparts: 15", hotel.checkAvailibility());

        event.register("TRINGA", "Mohammed");
        Assert.assertEquals("Standard rooms: 11|Suites: 5|Aparts: 15", hotel.checkAvailibility());
    }

    @Test
    public void a_tringa_attendee_gets_a_standard_room() {
        event.register("TRINGA", "Mohammed");
        Assert.assertEquals("Standard room N°1", hotel.getRoomFor("Mohammed"));
    }

    @Test
    public void a_registered_staff_member_gets_standard_room() {
        event.register("TRINGA", "Mohammed");

        Assert.assertEquals(true, event.register("STAFF", "Meriem"));
        Assert.assertEquals("Standard room N°2", hotel.getRoomFor("Meriem"));
        Assert.assertEquals("Standard rooms: 10|Suites: 5|Aparts: 15", hotel.checkAvailibility());
    }

    @Test
    public void a_registered_speaker_gets_a_suite() {
        event.register("TRINGA", "Mohammed");
        event.register("STAFF", "Meriem");

        Assert.assertEquals(true, event.register("SPEAKER", "Adil"));

        Assert.assertEquals("Suite N°101", hotel.getRoomFor("Adil"));
        Assert.assertEquals("Standard rooms: 10|Suites: 4|Aparts: 15", hotel.checkAvailibility());
    }

    @Test
    public void should_use_apparts_when_no_standard_room_left() {
        fillStandardRooms(12);

        Assert.assertEquals(true, event.register("TRINGA", "Mohammed"));
        Assert.assertEquals("Apart N°201", hotel.getRoomFor("Mohammed"));
        Assert.assertEquals("Standard rooms: 0|Suites: 5|Aparts: 14", hotel.checkAvailibility());
    }

    @Test
    public void can_register_a_conference_or_deepdive_attendee_in_event() {
        event.register("TRINGA", "Mohammed");

        Assert.assertEquals(true, event.register("CONF", "Karim"));
        Assert.assertEquals(true, event.register("DEEP DIVE", "Nadia"));
    }

    @Test
    public void a_registered_conf_and_deepdive_should_use_the_same_standard_room() {
        event.register("TRINGA", "Mohammed");
        event.register("CONF", "Karim");
        event.register("DEEP DIVE", "Nadia");
        
        System.out.println(hotel.getRoomFor("Karim"));
        System.out.println(hotel.getRoomFor("Nadia"));

        Assert.assertEquals("Standard room N°2", hotel.getRoomFor("Karim"));
        Assert.assertEquals("Standard room N°2", hotel.getRoomFor("Nadia"));
        Assert.assertEquals("Standard rooms: 10|Suites: 5|Aparts: 15", hotel.checkAvailibility());
    }

    @Test
    public void can_register_group_of_attendees() {
        Assert.assertEquals(true, event.register("TRINGA", "Mohammed", "Karim"));

        Assert.assertEquals("Standard room N°1", hotel.getRoomFor("Mohammed"));
        Assert.assertEquals("Standard room N°2", hotel.getRoomFor("Karim"));
        Assert.assertEquals("Standard rooms: 10|Suites: 5|Aparts: 15", hotel.checkAvailibility());
    }

    /**
     * When a group of attendees register together, its members should stay at the same room's type:
     * All of them in Standard rooms, or all of them in Apartments.
     */
    @Test
    public void group_of_attendees_should_always_be_together() {
        fillStandardRooms(10);
        
        Assert.assertEquals(true, event.register("TRINGA", "Mohammed", "Karim", "Nadia"));


        Assert.assertEquals("Apart N°201", hotel.getRoomFor("Mohammed"));
        Assert.assertEquals("Apart N°202", hotel.getRoomFor("Karim"));
        Assert.assertEquals("Apart N°203", hotel.getRoomFor("Nadia"));
        Assert.assertEquals("Standard rooms: 2|Suites: 5|Aparts: 12", hotel.checkAvailibility());
    }

    private void fillStandardRooms(int standardRooms) {
        for (int i = 0; i < standardRooms; i++) {
            String name = "Name" + i;
            event.register("TRINGA", name);
        }
    }

}
