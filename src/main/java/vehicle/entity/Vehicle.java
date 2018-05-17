package vehicle.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * create by tan on 2018/5/15
 * 车辆数据报文实体类
 **/
@Entity
public class Vehicle {
    @Id
    private int id; // 编号
    private String vin; // 车架号
    private String servertime; // 服务器接收时间
    private String codetime; // 报文时间戳
    private String codetype; // 报文类型
    private String codecheck; // 报文校验
    private String codelength; // 报文长度
    private String origincode; // 原始报文

    public Vehicle() {
    }

    public Vehicle(int id, String vin, String servertime, String codetime, String codetype, String codecheck, String codelength, String origincode) {
        this.id = id;
        this.vin = vin;
        this.servertime = servertime;
        this.codetime = codetime;
        this.codetype = codetype;
        this.codecheck = codecheck;
        this.codelength = codelength;
        this.origincode = origincode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getServertime() {
        return servertime;
    }

    public void setServertime(String servertime) {
        this.servertime = servertime;
    }

    public String getCodetime() {
        return codetime;
    }

    public void setCodetime(String codetime) {
        this.codetime = codetime;
    }

    public String getCodetype() {
        return codetype;
    }

    public void setCodetype(String codetype) {
        this.codetype = codetype;
    }

    public String getCodecheck() {
        return codecheck;
    }

    public void setCodecheck(String codecheck) {
        this.codecheck = codecheck;
    }

    public String getCodelength() {
        return codelength;
    }

    public void setCodelength(String codelength) {
        this.codelength = codelength;
    }

    public String getOrigincode() {
        return origincode;
    }

    public void setOrigincode(String origincode) {
        this.origincode = origincode;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
               "vin='" + vin + '\'' +
                ", servertime='" + servertime + '\'' +
                ", codetime='" + codetime + '\'' +
                ", codetype='" + codetype + '\'' +
                ", codecheck='" + codecheck + '\'' +
                ", codelength='" + codelength + '\'' +
                ", origincode='" + origincode + '\'' +
                '}';
    }
}
