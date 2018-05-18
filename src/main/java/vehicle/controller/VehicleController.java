package vehicle.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import vehicle.entity.Vehicle;
import vehicle.service.VehicleService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create by tan on 2018/5/14
 * 监控系统的控制层实现，实现页面跳转及输入校验
 **/
@Controller
@Transactional
@RequestMapping("/map")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    /*@RequestMapping(value = "/toMain")
    public String toMain() {
        return "html/main";
    }*/

    @RequestMapping(value = "/toMainPage")
    public String toMainPage() {
        return "html/map";
    }

    @RequestMapping(value = "/toMenuPage")
    public String toMenuPage() {
        return "html/menu";
    }

    @RequestMapping(value = "/toSearchPage")
    public String toSearchPage() {
        return "html/search";
    }

    @RequestMapping(value = "/toAlertPage")
    public String toAlertPage() {
        return "page/alertData";
    }

    @RequestMapping(value = "/toVehiclePage")
    public String toVehiclePage() {
        return "page/vehicleData";
    }

    @RequestMapping(value = "/toExtremePage")
    public String toExtremePage() {
        return "page/extremeData";
    }

    @RequestMapping(value = "/toLocationPage")
    public String toLocationPage() {
        return "page/locationData";
    }

    @RequestMapping(value = "/toStatePage")
    public String toStatePage() {
        return "page/stateData";
    }

    @RequestMapping(value = "/toMotorPage")
    public String toMotorPage() {
        return "page/motorData";
    }
    // 报文信息查询
    @RequestMapping(value = "/searchData", produces = "application/json; charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    public String searchData(String vin) {
        try {
            List<Vehicle> vehicle = vehicleService.getDataByVin(vin);
            Map<String, Object> jsonMap = new HashMap<String, Object>();
            jsonMap.put("total", vehicle.size());
            jsonMap.put("rows", vehicle);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(vehicle);
            return json;
        } catch(Exception e) {
            return "";
        }
    }
}
