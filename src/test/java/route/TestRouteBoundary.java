package route;

import it.ecteam.easycharge.viewcontroller.RouteBoundary;
import it.ecteam.easycharge.exceptions.LocationNotFoundException;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
//Author: Miriana Marchi
public class TestRouteBoundary {
    @Test
    public void testGetOnRoute() {

        RouteBoundary rc;
        String output;
        String attended;
        List<Double> start = new ArrayList<> (); ;
        List<Double> end = new ArrayList<>();;

        rc = RouteBoundary.getInstance();
        output="";
        attended="";
        start.add(0,12.493321);
        start.add(1,12.493321);
        end.add(0,37.828789);
        end.add(1,-122.485964);

        try {
            rc.getOnRoute(start,end);
        } catch (LocationNotFoundException | IOException | ParseException e) {
            output=e.getMessage();
        } finally {
            assertEquals(attended,output);
        }
    }
}
