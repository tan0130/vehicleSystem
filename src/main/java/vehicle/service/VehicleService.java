package vehicle.service;

import vehicle.entity.Vehicle;

import java.util.List;
import java.util.Map;

/**
 * create by tan on 2018/5/15
 * 报文查询操作业务逻辑层接口
 **/
public interface VehicleService {
    public List<Vehicle> getData(); // 获取所有报文数据
    public List<Vehicle> getDataByVin(String vin); // 根据车架号获取报文信息
}
