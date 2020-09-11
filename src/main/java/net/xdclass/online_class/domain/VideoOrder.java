package net.xdclass.online_class.domain;


import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.Date;

/**
 * 视频订单类
 */
public class VideoOrder {

    /**
     * `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
     *   `out_trade_no` varchar(64) DEFAULT NULL COMMENT '订单唯一标识',
     *             `state` int(11) DEFAULT NULL COMMENT '0表示未支付，1表示已支付',
     *             `create_time` datetime DEFAULT NULL COMMENT '订单生成时间',
     *             `total_fee` int(11) DEFAULT NULL COMMENT '支付金额，单位分',
     *             `video_id` int(11) DEFAULT NULL COMMENT '视频主键',
     *             `video_title` varchar(256) DEFAULT NULL COMMENT '视频标题',
     *             `video_img` varchar(256) DEFAULT NULL COMMENT '视频图片',
     *             `user_id` int(12) DEFAULT NULL COMMENT '用户id',
     */

    private int id;

    private String outTradeNo;

    private int state;

    private Date createTime;

    private int totalFee;

    private int videoId;

    private String videoTitle;

    private String videoImg;

    private int userId;

    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoImg() {
        return videoImg;
    }

    public void setVideoImg(String videoImg) {
        this.videoImg = videoImg;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "VideoOrder{" +
                "id=" + id +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", state=" + state +
                ", createTime=" + createTime +
                ", totalFee=" + totalFee +
                ", videoId=" + videoId +
                ", videoTitle='" + videoTitle + '\'' +
                ", videoImg='" + videoImg + '\'' +
                ", userId=" + userId +
                ", user=" + user +
                '}';
    }
}
