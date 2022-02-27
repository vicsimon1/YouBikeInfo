# YouBikeInfo
Help you to retrieve YouBike stations realtime data in Taipei/New Taipei. 

## Usage

```java
YouBikeDataGetter youBikeDataGetter = new YouBikeDataGetter();

Map<String, YouBikeStation> result =  youBikeDataGetter.getAllYouBikeStations();

System.out.println("station 0003: " + result.get("0003").toString());

// output: 
// station 0003: YouBikeStation(sno=0003, sna=台北市政府, tot=40, sbi=0, 
// sarea=信義區, mday=20220208083416, lat=25.037798, lng=121.56517, 
// ar=台北市政府東門(松智路) (鄰近信義商圈/台北探索館), sareaen=Xinyi Dist., 
// snaen=Taipei City Hall, aren=Taipei City Government Eastgate (Song Zhi Road), 
// bemp=0, act=1)

```

##Authors
* **MH Tsai** - [linkedin](https://www.linkedin.com/in/ming-han-tsai-5919b57b?trk=nav_responsive_tab_profile_pic)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
