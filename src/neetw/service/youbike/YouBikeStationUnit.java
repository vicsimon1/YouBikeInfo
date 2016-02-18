package neetw.service.youbike;

public class YouBikeStationUnit {
	String zoneName;
	String stationName; 
    int availNum;
    int emptyNum; 
    
    public String getZoneName() {
        return zoneName;
    }
    
    public String getStationName() {
        return stationName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }
    
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public int getAvailNum() {
        return availNum;
    }

    public void setAvailNum(int availNum) {
        this.availNum = availNum;
    }

    public int getEmptyNum() {
        return emptyNum;
    }

    public void setEmptyNum(int emptyNum) {
        this.emptyNum = emptyNum;
    }
}
