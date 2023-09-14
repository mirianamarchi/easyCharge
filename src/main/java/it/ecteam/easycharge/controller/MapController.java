package it.ecteam.easycharge.controller;

import it.ecteam.easycharge.exceptions.LocationNotFoundException;
import it.ecteam.easycharge.viewcontroller.MapBoundary;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapController {

    public static List<Double> getCoordinates(String string) throws IOException, ParseException, LocationNotFoundException {
        List<Double> coord = new ArrayList<>();

        coord = MapBoundary.getCoordinates(string);

        return coord;
    }
}
