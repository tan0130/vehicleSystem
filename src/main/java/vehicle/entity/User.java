package vehicle.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * create by tan on 2018/5/18
 * 用户实体类
 **/
@Entity
public class User {
    @Id
    private int id; // 用户编号
    private String nickname; // 用户名
    private String password; // 用户登录密码

    public User() {
    }

    public User(int id, String nickname, String password) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
