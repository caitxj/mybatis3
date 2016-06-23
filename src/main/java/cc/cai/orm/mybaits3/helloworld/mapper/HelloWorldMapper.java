package cc.cai.orm.mybaits3.helloworld.mapper;

import cc.cai.orm.mybaits3.helloworld.entity.CustomerHelloWorld;
import cc.cai.orm.mybaits3.helloworld.entity.HelloWorld;

public interface HelloWorldMapper {

//	HelloWorld selectBlog(String id);
	/*
	 * 定义与xml中相应进行对应
	 * id="selectBlog" resultType="CustomerHelloWorld"
	 * id:interface methodName
	 * resultType:interface returnType;
	 * sql中定义的#{param},表示方法的参数
	 */
	CustomerHelloWorld selectBlog(String id);
}
