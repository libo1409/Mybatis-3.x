package net.xdclass.online_class;

import net.xdclass.online_class.dao.VideoMapper;
import net.xdclass.online_class.dao.VideoOrderMapper;
import net.xdclass.online_class.domain.Video;
import net.xdclass.online_class.domain.VideoOrder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class SqlSessionDemo {

    public static void main(String[] args) throws IOException {

        String source = "config/mybatis-config.xml";

        //读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(source);
        //构建Session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取Session
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){

            //VideoMapper.class 操作
            VideoMapper videoMapper = sqlSession.getMapper(VideoMapper.class);



            //通过xml读取
//            Video video = videoMapper.selectById(44);
//            System.out.println(video);
            //通过注解读取全部
//            List<Video> videoList = videoMapper.selectList();
//            System.out.println(videoList.toString());
            //通过xml读取全部
//            List<Video> videoList1 = videoMapper.selectListByXml();
//            System.out.println(videoList1.toString());

//            System.out.println(videoList1.get(1).getTitle());
            //参数别名使用 查询
//            List<Video> videoList2 = videoMapper.selectByPointAndTitleLike(8.7,"HTML");
//            System.out.println(videoList2);

            //新增一条记录
//            Video video1 = new Video();
//            video1.setTitle("小弟课堂面试1111");
//            video1.setSummary("面试专题11");
//            video1.setCoverImg("ne.class111");
//            video1.setCreateTime(new Date());
//            video1.setPoint(9.1);
//            video1.setPrice(9901);
//
//            Video video2 = new Video();
//            video2.setTitle("小弟课堂面试222");
//            video2.setSummary("面试专题22");
//            video2.setCoverImg("ne.class222");
//            video2.setCreateTime(new Date());
//            video2.setPoint(9.2);
//            video2.setPrice(9902);
//
//            List<Video> videoList = new ArrayList<>();
//            videoList.add(video1);
//            videoList.add(video2);
//            System.out.println(videoList);
//            int rows = videoMapper.addBatch(videoList);
//
//            System.out.println(rows);

            //更新一条记录
//            Video video = new Video();
//            video.setId(54);
//            video.setTitle("小弟课堂面试8888888888");
//            video.setCoverImg("net.jpg");
//            videoMapper.updateVideoSelective(video);


            //根据时间和价格删除

//            Map<String,Object>  map = new HashMap<>();
//            map.put("createTime","2020-09-10 09:33:33");
//            map.put("price",9000);
//            int rows = videoMapper.deleteByCreateTimeAndPrice(map);
//            System.out.println(rows);

//           int rows = videoMapper.add(video);
//
//            System.out.println(rows);
//            System.out.println(video.toString());

            //根据id 查询视频
//            Video video = videoMapper.selectBaseFieldByIdWithResultMap(44);
//            System.out.println(video);




            //resultMap association关联查询
            VideoOrderMapper videoOrderMapper = sqlSession.getMapper(VideoOrderMapper.class);
            List<VideoOrder> videoOrderList = videoOrderMapper.queryVideoOrderList();
            System.out.println(videoOrderList);

        }

    }
}
