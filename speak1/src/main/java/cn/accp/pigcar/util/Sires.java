package cn.accp.pigcar.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sires {

   private Integer  minPointSize=10;

   private String innerSize="20%";

    public Integer getMinPointSize() {
        return minPointSize;
    }

    public void setMinPointSize(Integer minPointSize) {
        this.minPointSize = minPointSize;
    }

    public String getInnerSize() {
        return innerSize;
    }

    public void setInnerSize(String innerSize) {
        this.innerSize = innerSize;
    }

    public Integer getzMin() {
        return zMin;
    }

    public void setzMin(Integer zMin) {
        this.zMin = zMin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Map<String, Object>> getData() {
        return data;
    }

    public void setData(List<Map<String, Object>> data) {
        this.data = data;
    }

    private Integer zMin =0;

   private String name="countries";

   List<Map<String,Object>> data;


}
