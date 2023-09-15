package it.ecteam.easycharge.controller;

import it.ecteam.easycharge.bean.CarBean;
import it.ecteam.easycharge.bean.ChargingStationBean;
import it.ecteam.easycharge.dao.CarDao;
import it.ecteam.easycharge.dao.UserDao;
import it.ecteam.easycharge.entity.Car;
import it.ecteam.easycharge.entity.ChargingStation;
import it.ecteam.easycharge.exceptions.ChargingStationNotFoundException;
import it.ecteam.easycharge.exceptions.LocationNotFoundException;
import it.ecteam.easycharge.viewcontroller.MapBoundary;
import it.ecteam.easycharge.viewcontroller.RouteBoundary;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserController {

    public CarBean getCar(String name) {
        CarController cc = new CarController();

        Car result = cc.getCar(name);
        if (result == null)	{
            return null;
        } else {
            CarBean c = new CarBean();
            c.setName(result.getName());
            c.setCapacity(result.getCapacity());
            c.setRange(result.getRange());
            c.setConnectorType(result.getConnectorType());
            return c;
        }
    }

    public void changeCar(String username, String model){
        UserDao userDao = new UserDao();

        userDao.changeUserCar(username, model);
    }

    public void setFavorite(String username, String csid){
        UserDao userDao = new UserDao();

        userDao.addFavorite(username, csid);
    }

    public void deleteFavorite(String username, String csid){
        UserDao userDao = new UserDao();

        userDao.removeFavorite(username, csid);
    }

    public static List<ChargingStationBean> getFavorite(String username){
        UserDao ud = new UserDao();

        List<ChargingStation> result = ud.getFavorite(username);
        List<ChargingStationBean> rbl = new ArrayList<>();
        if(result == null){
            return Collections.emptyList();
        }else{
            int i;
            for(i=0; i < result.size(); i++) {
                ChargingStationBean csb = new ChargingStationBean();
                ChargingStation r = result.get(i);

                csb.setId(r.getId());
                rbl.add(csb);
            }
            return rbl;
        }
    }

    public static List<Double> getCoordinates(String string) throws IOException, ParseException, LocationNotFoundException {
        List<Double> coord = new ArrayList<>();

        coord = MapController.getCoordinates(string);

        return coord;
    }

    public static List<ChargingStationBean> getPerfectRoute(List<Double> start, List<Double> end, String capacity) throws IOException, ParseException, LocationNotFoundException, ChargingStationNotFoundException {
        List<ChargingStationBean> csb = new ArrayList<>();

        csb = RouteController.getPerfectRoute(start,end,capacity);

        return csb;
    }

    public static List<ChargingStationBean> getOnRoute(List<Double> start, List<Double> end) throws IOException, org.json.simple.parser.ParseException, LocationNotFoundException {
        List<ChargingStationBean> chargingStationList = new ArrayList<>();

        chargingStationList = RouteController.getOnRoute(start,end);

        return chargingStationList;
    }
}
