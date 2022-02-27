package neetw.service.youbike.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class YouBikeStation {
    //    "sno": "0002",
    //    "sna": "捷運國父紀念館站(2號出口)",
    //    "tot": "32",
    //    "sbi": "0",
    //    "sarea": "大安區",
    //    "mday": "20220226234926",
    //    "lat": "25.041254",
    //    "lng": "121.55742",
    //    "ar": "忠孝東路四段/光復南路口(西南側)",
    //    "sareaen": "Daan Dist.",
    //    "snaen": "MRT S.Y.S Memorial Hall Stataion(Exit 2.)",
    //    "aren": "Sec,4. Zhongxiao E.Rd/GuangFu S. Rd",
    //    "bemp": "32",
    //    "act": "1"

    String sno;
    String sna;
    int tot;
    int sbi; // 可借
    String sarea;
    String mday;
    float lat;
    float lng;
    String ar;
    String sareaen;
    String snaen;
    String aren;
    int bemp; //可還
    int act;
}
