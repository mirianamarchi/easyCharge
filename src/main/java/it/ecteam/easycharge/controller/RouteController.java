package it.ecteam.easycharge.controller;

import it.ecteam.easycharge.bean.ChargingStationBean;
import it.ecteam.easycharge.exceptions.ChargingStationNotFoundException;
import it.ecteam.easycharge.exceptions.LocationNotFoundException;
import it.ecteam.easycharge.viewcontroller.RouteBoundary;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RouteController {

    private RouteController(){}
    public static List<ChargingStationBean> getPerfectRoute(List<Double> start, List<Double> end, String capacity) throws IOException, ParseException, LocationNotFoundException, ChargingStationNotFoundException {
        List<ChargingStationBean> csb = new ArrayList<>();

        csb = RouteBoundary.getPerfectRoute(start,end,capacity);

        return csb;
    }

    public static List<ChargingStationBean> getOnRoute(List<Double> start, List<Double> end) throws IOException, org.json.simple.parser.ParseException, LocationNotFoundException {
        List<ChargingStationBean> chargingStationList = new ArrayList<>();

        chargingStationList = RouteBoundary.getOnRoute(start,end);

        return chargingStationList;
    }

    }
