package net.xdclass.online_class;

import net.xdclass.online_class.dao.VideoMapper;
import net.xdclass.online_class.dao.VideoOrderMapper;
import net.xdclass.online_class.domain.User;
import net.xdclass.online_class.domain.Video;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SqlSessionCacheDemo {

    public static void main(String[] args) throws IOException {

        String source = "config/mybatis-config.xml";

        //读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(source);
        //构建Session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取Session
        try {

            SqlSession sqlSession1= sqlSessionFactory.openSession();
            VideoMapper videoMapper1 = sqlSession1.getMapper(VideoMapper.class);
            Video video1 = videoMapper1.selectById(40);
            System.out.println(video1);
            sqlSession1.commit();
//            sqlSession1.close();

            SqlSession sqlSession2= sqlSessionFactory.openSession();
            VideoMapper videoMapper2 = sqlSession2.getMapper(VideoMapper.class);
            Video video2 = videoMapper2.selectById(40);
            System.out.println(video2);
            sqlSession2.commit();
//            sqlSession2.close();

        }catch (Exception e){
            e.printStackTrace();
        }





    }
}
