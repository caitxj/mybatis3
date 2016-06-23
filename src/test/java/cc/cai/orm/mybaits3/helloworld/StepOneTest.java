package cc.cai.orm.mybaits3.helloworld;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cc.cai.orm.mybaits3.helloworld.entity.CustomerHelloWorld;
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
		
		//通过将xml中的各种类型的sql(select,insert,update,delete) 映射到接口上对应的方法,然后通过代理该接口,实现通过过接口可以进行增删改查操作
		HelloWorldMapper hm=sqlSession.getMapper(HelloWorldMapper.class);
		
//		HelloWorld hw=hm.selectBlog("1");
		CustomerHelloWorld hw=hm.selectBlog("1");
		System.out.println("id:"+hw.getId()+"|name:"+hw.getName()+"|pid:"+hw.getPid());
	}
}
