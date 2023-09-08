package com.harsha.controller;


import com.harsha.dao.FlightsDao;
import com.harsha.entity.Flight;
import com.harsha.entity.Passengers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FlightBookingController {


    @Autowired
    FlightsDao flightsDao;


    @PostMapping("/booking")
    public String book(@RequestParam("flightId")String flightId, @RequestParam("passengerId") String passengerId, @RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName, @RequestParam("mobile") long mobile, @RequestParam("email") String email, @RequestParam("traveldate") String travelDate, Model model) {
        Passengers p = new Passengers(passengerId, firstName, lastName, mobile, email);

        if(flightsDao.bookFlight(flightId,p,travelDate))
        {
            Flight f = flightsDao.getFlightById(flightId);
            model.addAttribute("FlightObj",f);
            model.addAttribute("PassengerObj",p);
            model.addAttribute("message","Successful;");
            return "Display";
        }


        model.addAttribute("message","Not Succesful");
        return "Display";



    }




}
