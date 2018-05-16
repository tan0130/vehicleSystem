package vehicle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vehicle.dao.VehicleDAO;
import vehicle.entity.Vehicle;

import java.util.List;

/**
 * create by tan on 2018/5/15
 * 报文查询操作业务逻辑层接口实现
 **/
@Service("VehicleService")
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    private VehicleDAO vehicleDAO;

    @Override
    public List<Vehicle> getData() {
        return vehicleDAO.getData();
    }

    @Override
    public List<Vehicle> getDataByVin(String vin) {
        return vehicleDAO.getDataByVin(vin);
    }
}
