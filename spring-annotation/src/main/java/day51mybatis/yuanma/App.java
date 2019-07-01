package day51mybatis.yuanma;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *  纯mybatis源码
 *  1.mybatisConfig.yuanma.xml
 *  2.实体
 *  3.dao
 *  4.xml
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Jun 27, 2019 11:16:35 AM
 */
public class App {

	public static void main(String[] args) throws IOException {
		String resource = "mybatisConfig.yuanma.xml";
		/**
		 *  InputStream inputStream = Resources.getResourceAsStream(resource);的这句话的解释：
		 *  InputStream in = classLoaderWrapper.getResourceAsStream(resource, loader);
		    if (in == null) {
		      throw new IOException("Could not find resource " + resource);
		    }
		    return in;
		 */
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
         
        AccTable2 cs = session.selectOne("selectByPrimaryKey", 10);
        System.out.println(cs.getActivityName());
        session.commit();
        session.close();
	}
}
