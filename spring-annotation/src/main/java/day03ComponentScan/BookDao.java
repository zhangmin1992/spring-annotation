package day03ComponentScan;

import org.springframework.stereotype.Service;

/**
 * 默认的名字是驼峰式的bookDao
 * @author yp-tc-m-7129
 *
 */
@Service
public class BookDao {

	public void test() {
		System.out.println("------test()----");
	}
}
