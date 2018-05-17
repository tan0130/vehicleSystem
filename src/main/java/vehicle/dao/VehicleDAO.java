package vehicle.dao;

import vehicle.entity.Vehicle;

import java.util.List;
import java.util.Map;

/**
 * create by tan on 2018/5/14
 * 报文查询操作接口
 **/
public interface VehicleDAO {
    public List<Vehicle> getData(); // 获取所有报文信息
    public List<Vehicle> getDataByVin(String vin); // 根据车架号获取报文信息
}
