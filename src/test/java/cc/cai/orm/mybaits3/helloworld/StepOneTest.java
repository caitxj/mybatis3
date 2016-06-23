package cc.cai.orm.mybaits3.helloworld;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cc.cai.orm.mybaits3.helloworld.entity.HelloWorld;
import cc.cai.orm.mybaits3.helloworld.mapper.HelloWorldMapper;

public class StepOneTest {

	@Test
	public void helloWorldTest() throws IOException{
		
		String resource = "helloworld/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//		System.out.println(sqlSessionFactory.getConfiguration().getEnvironment().getDataSource().getConnection());
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		HelloWorldMapper hm=sqlSession.getMapper(HelloWorldMapper.class);
		
		HelloWorld hw=hm.selectBlog("1");
		System.out.println("id:"+hw.getId()+"|name:"+hw.getName());
	}
}
