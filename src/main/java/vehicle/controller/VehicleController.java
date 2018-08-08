package vehicle.controller;


//import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.stage.FileChooser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import vehicle.entity.Vehicle;
import vehicle.service.VehicleService;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * create by tan on 2018/5/14
 * 监控系统的控制层实现，实现页面跳转及输入校验
 **/
@Controller
@RequestMapping("/map")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    /*@RequestMapping(value = "/toMain")
    public String toMain() {
        return "html/main";
    }*/

    @RequestMapping(value = "toErrorPage")
    public String toErrorPage() {
        return "/error/error";
    }

    @RequestMapping(value = "/toMainPage")
    public String toMainPage() {
        return "html/main";
    }

    @RequestMapping(value = "/toMapPage")
    public String toMapPage() {
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

    @RequestMapping(value = "/toControlPage")
    public String toVoltagePage() {
        return "page/remoteControl";
    }

    @RequestMapping(value = "/toUpdatePage")
    public String toTemperaturePage() {
        return "page/remoteUpdate";
    }

    // test 远程控制发送指令
    @RequestMapping(value = "/sendCommandCode")
    @ResponseBody
    public String sendCommandCode() {
        try {
            Thread.currentThread().sleep(5000);
//            System.out.print("返回 true");
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fail";
    }

    // 保存历史记录信息到本地文档中
    @RequestMapping(value = "/saveHistoryText")
    @ResponseBody
    public String saveHistoryText(String historyText) {
        // 获取当前系统时间
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        String current_time = df.format(new Date());
        try {
            JFileChooser jfileChooser = new JFileChooser();
            jfileChooser.setMultiSelectionEnabled(false); // 不支持多选
            jfileChooser.setFileSelectionMode(JFileChooser.SAVE_DIALOG | JFileChooser.DIRECTORIES_ONLY);
            jfileChooser.setDialogTitle("选择目标文件夹");
            if (jfileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                File file = jfileChooser.getSelectedFile();
                String filePath = file.getPath();
                PrintWriter printWriter = new PrintWriter(filePath + "\\" + current_time + "history_text.txt");
                printWriter.println(historyText);
                printWriter.close();
            } else {
                return "fail";
            }

            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "false";

    }

    // 上传文件
    @RequestMapping(value = "/upload")
    @ResponseBody
    public String upload(HttpServletRequest request, MultipartFile upload_file) throws Exception {
        String json = null;
        Map<String, String> map = new HashMap<>();
        System.out.println("upload_file:" + upload_file);
        ObjectMapper mapper = new ObjectMapper();
        if(!upload_file.isEmpty()) {
            //上传文件路径
            String path = request.getServletContext().getRealPath("/img/");
            //上传文件名
            String filename = upload_file.getOriginalFilename();
            File filepath = new File(path,filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            upload_file.transferTo(new File(path + File.separator + filename));
            //System.out.print("文件上传成功");

            map.put("result", "success");
            json = mapper.writeValueAsString(map);
           // System.out.println("返回json 数据为：" + json);
            return json;
        } else {
            map.put("result","fail");
            json = mapper.writeValueAsString(map);
            return json;
        }
    }

    @RequestMapping(value = "/remoteUpdate")
    @ResponseBody
    public String remoteUpdate() {
        try {
            Thread.currentThread().sleep(5000);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            //return "error";
        }
        return "fail";
    }


        // 报文信息查询
    /*@RequestMapping(value = "/searchData", produces = "application/json; charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    public String searchData(String vin) {
        try {
            List<Vehicle> vehicle = vehicleService.getDataByVin(vin);
            Map<String, Object> jsonMap = new HashMap<String, Object>();
            jsonMap.put("total", vehicle.size());
            jsonMap.put("rows", vehicle);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(jsonMap);
            return json;
        } catch(Exception e) {
            return "";
        }
    }*/
}
