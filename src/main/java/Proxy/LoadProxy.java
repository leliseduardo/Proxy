package Proxy;

import java.util.List;

public class LoadProxy implements ILoad {

    private Load load;
    private Integer code;

    public LoadProxy(Integer code) {
        this.code = code;
    }

    @Override
    public List<String> getLoadData() {
        if (this.load == null) {
            this.load = new Load(this.code);
        }
        return this.load.getLoadData();
    }

    @Override
    public Float getLoadValue(Employee employee) {
        if (!employee.isAdmin()) {
            throw new IllegalArgumentException("Employee not authorized.");
        }
        if (this.load == null) {
            this.load = new Load(this.code);
        }
        return this.load.getLoadValue(employee);
    }
}

