# YouBikeInfo
A library to help you retrieve YouBike(Taiwan) stations info from the official YouBike website.

## Usage

```java
YouBikeStationViewer youbikeViewer = new YouBikeStationViewer();

Hashtable<String, Integer> table1 = youbikeViewer.getYouBikeAvailNum(YouBikeConstent.YOUBIKE_TAICHUNG);
System.out.println("AvailNum: " + table1);
 
Hashtable<String, Integer> table2 = youbikeViewer.getYouBikeEmptyNum(YouBikeConstent.YOUBIKE_TAICHUNG);
System.out.println("EmptyNum: " + table2);
 
Hashtable<String, String> table3 = youbikeViewer.getYouBikeZoneName(YouBikeConstent.YOUBIKE_TAICHUNG);
System.out.println("ZoneName: " + table3);
 
JsonArray array1 = youbikeViewer.getYouBikeJsonArray(YouBikeConstent.YOUBIKE_TAICHUNG);
System.out.println("JsonArray: " + array1);
 
```

##Authors
* **MH Tsai** - [linkedin](https://www.linkedin.com/in/ming-han-tsai-5919b57b?trk=nav_responsive_tab_profile_pic)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
