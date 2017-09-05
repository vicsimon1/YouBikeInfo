package neetw.service.youbike.service;

import neetw.service.youbike.dataretrieve.YouBikeDataGetter;
import neetw.service.youbike.model.YouBikeStation;

import javax.json.JsonArray;
import java.util.Hashtable;
import java.util.Observable;
import java.util.Set;

public class YouBikeInfoEmitter extends Observable {

    Hashtable<String, YouBikeStation> youBikeStationData = new Hashtable();
    YouBikeDataGetter youBikeDataGetter = new YouBikeDataGetter();

    /**
     * Provide Observer pattern utils, other Object can be auto update while this method
     * is called
     * @param url
     */
    public void updateData(String url) {
        this.youBikeStationData = youBikeDataGetter.getYouBikeData(url);
        setChanged();
        notifyObservers();
    }

    /**
     * Returns the Hashtable of YouBikeStation that contains all info of the
     * stations
     * @param inputUrl
     * @return Hashtable<String, YouBikeStation>
     * @see YouBikeStation
     */
    public Hashtable<String, YouBikeStation> getYouBikeStations() {
        return this.youBikeStationData;
    }

    /**
     * Returns the Hashtable of YouBike station's available number for renting
     * bikes
     *
     * @param inputUrl
     * @return Hashtable<String, Integer>
     */
    public Hashtable<String, Integer> getYouBikeAvailNum() {

        Hashtable<String, Integer> temp_table = new Hashtable<String, Integer>();
        Set<String> keys = youBikeStationData.keySet();
        for (String key : keys) {
            temp_table.put(key, youBikeStationData.get(key).getAvailNum());
        }
        return temp_table;
    }

    /**
     * Returns the Hashtable of YouBike station's empty number for returning
     * bikes
     *
     * @param inputUrl
     * @return Hashtable<String, Integer>
     */
    public Hashtable<String, Integer> getYouBikeEmptyNum() {

        Hashtable<String, Integer> temp_table = new Hashtable<String, Integer>();
        Set<String> keys = youBikeStationData.keySet();
        for (String key : keys) {
            temp_table.put(key, youBikeStationData.get(key).getEmptyNum());
        }
        return temp_table;
    }

    /**
     * Returns the Hashtable of YouBike station's zone name
     *
     * @param inputUrl
     * @return Hashtable<String, String>
     */
    public Hashtable<String, String> getYouBikeZoneName() {

        Hashtable<String, String> temp_table = new Hashtable<String, String>();
        Set<String> keys = youBikeStationData.keySet();
        for (String key : keys) {
            temp_table.put(key, youBikeStationData.get(key).getZoneName());
        }
        return temp_table;
    }

    /**
     * Returns the JsonArray of YouBike station
     *
     * @param inputUrl
     * @return JsonArray
     */
    public JsonArray getYouBikeJsonArray(String inputUrl) {
        return youBikeDataGetter.getYouBikeJsonArray(inputUrl);
    }


}
