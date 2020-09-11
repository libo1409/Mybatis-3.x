package net.xdclass.online_class.domain;

import java.util.Date;

public class User {

    /**
     *  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
     *   `name` varchar(128) DEFAULT NULL COMMENT '昵称',
     *   `pwd` varchar(124) DEFAULT NULL COMMENT '密码',
     *   `head_img` varchar(524) DEFAULT NULL COMMENT '头像',
     *   `phone` varchar(64) DEFAULT '' COMMENT '手机号',
     *   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
     */

    private int id;

    private String name;

    private String pwd;

    private String headImg;

    private String phone;

    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", headImg='" + headImg + '\'' +
                ", phone='" + phone + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
