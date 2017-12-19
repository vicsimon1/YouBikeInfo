package neetw.service.youbike.test;

import neetw.service.youbike.service.YouBikeInfoEmitter;

import java.util.Observable;
import java.util.Observer;

public class DaoExample implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        // Do some DAO, refresh screen, etc.
        YouBikeInfoEmitter mySubject = (YouBikeInfoEmitter) o;
        System.out.println("Observer get YouBike data refreshed: " + mySubject.getYouBikeAvailNum());
    }
}
