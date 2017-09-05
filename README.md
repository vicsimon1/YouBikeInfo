# YouBikeInfo
A library to help you retrieve YouBike(Taiwan) stations info from the official YouBike website. 
Implement Observer Pattern, can be used in DAO data update, screen data refresh, etc.

## Usage

```java
YouBikeInfoEmitter youBikeInfoEmitter = new YouBikeInfoEmitter();

// add any custom Observer 
DaoExample daoExample = new DaoExample();
youBikeInfoEmitter.addObserver(daoExample);

// call this to update data from official YouBike website
youBikeInfoEmitter.updateData(YouBikeConstant.YOUBIKE_TAICHUNG);

// Other data retrive utils
Hashtable<String, Integer> table = youBikeInfoEmitter.getYouBikeAvailNum();
System.out.println("AvailNum: " + table);

Hashtable<String, Integer> table2 = youBikeInfoEmitter.getYouBikeEmptyNum();
System.out.println("EmptyNum: " + table2);

Hashtable<String, String> table3 = youBikeInfoEmitter.getYouBikeZoneName();
System.out.println("ZoneName: " + table3);

JsonArray array1 = youBikeInfoEmitter.getYouBikeJsonArray(YouBikeConstant.YOUBIKE_TAICHUNG);
System.out.println("JsonArray: " + array1);
 
```

##Authors
* **MH Tsai** - [linkedin](https://www.linkedin.com/in/ming-han-tsai-5919b57b?trk=nav_responsive_tab_profile_pic)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
