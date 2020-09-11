package net.xdclass.online_class.dao;

import net.xdclass.online_class.domain.Video;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface VideoMapper {

    /**
     * 根据视频id查找视频对象
     * @param videoId
     * @return
     */
    Video selectById(@Param("video_id") int videoId); //@Param（）起别名 多个参数必须使用 不然会出错

    /**
     *查询全部视频列表 xml
     */
    List<Video> selectListByXml();
    /**
     * 查询全部视频列表  注解
     */
    @Select("select * from video")
    List<Video> selectList();

    /**
     * 根据评分和标题模糊查询
     * @param point
     * @param title
     * @return
     */
    List<Video>selectByPointAndTitleLike(@Param("point") double point,@Param("title") String title);

    /**
     * 新增一条视频记录
     * @param video
     * @return
     */
    int add(Video video);

    /**
     * 批量插入
     * @param
     * @return
     */
    int addBatch(List<Video> list);

    /**
     * 更新一条记录
     * @param video
     * @return
     */
    int updateVideo(Video video);

    /**
     * 动态选择更新
     * @return
     */
    int updateVideoSelective(Video video);

    /**
     * 根据时间和价格删除
     * @param map
     * @return
     */
    int deleteByCreateTimeAndPrice(Map<String,Object> map);

    /**
     * 根据id查询视频
     * @param videoId
     * @return
     */
    Video selectBaseFieldByIdWithResultMap(@Param("video_id") int videoId);
}
