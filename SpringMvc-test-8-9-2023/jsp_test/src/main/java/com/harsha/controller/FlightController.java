package com.harsha.controller;

import com.harsha.dao.FlightsDao;
import com.harsha.entity.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class FlightController {


        @Autowired
        FlightsDao flightsDao;


        @GetMapping("/Search")
        public String getMoneyTransferForm(){
            return "Search";
        }

        @GetMapping("searchFlight")
        public String getFlights(@RequestParam String source,@RequestParam String destination, Model model) throws ClassNotFoundException {
            String message = "Money Transfer Failed";

            List<Flight> flights = flightsDao.getFlightsBySourceAndDestination(source,destination);


            System.out.println(flights.get(0).getSource());



            model.addAttribute("flights",flights);

            return "FlightBooking";


        }
}


