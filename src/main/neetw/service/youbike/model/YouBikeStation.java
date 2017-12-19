package neetw.service.youbike.model;

public class YouBikeStation {
	private String zoneName;
    private String stationName;
    private int availNum;
    private int emptyNum;
    
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
    
    @Override
    public String toString() {
    		return  zoneName + " " +  stationName + " " + availNum + " " + emptyNum; 
    }
}
