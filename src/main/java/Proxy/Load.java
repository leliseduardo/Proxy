package Proxy;

import java.util.Arrays;
import java.util.List;

public class Load implements ILoad {

    private int code;
    private String cargoType;
    private String origin;
    private String destination;
    private Float totalValue;

    public Load(int code){
        this.code = code;
        Load object = BD.getLoad(code);
        this.cargoType = object.cargoType;
        this.origin = object.origin;
        this.destination = object.destination;
        this.totalValue = object.totalValue;
    }

    public Load(int code, String cargoType, String origin, String destination, Float totalValue) {
        this.code = code;
        this.cargoType = cargoType;
        this.origin = origin;
        this.destination = destination;
        this.totalValue = totalValue;
    }

    public Integer getCode(){
        return this.code;
    }

    @Override
    public List<String> getLoadData() {
        return Arrays.asList(this.cargoType, this.origin, this.destination);
    }

    @Override
    public Float getLoadValue(Employee employee) {
        return this.totalValue;
    }
}

