package day51mybatis.yuanma.xmlToBean;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Test {

	public static void main(String[] args) {
		try {
			SAXReader reader = new SAXReader(); 
			File file = new File("src/main/resources/cc.xml");
			Document document = reader.read(file);
			Element root = document.getRootElement(); // 获取根节点
			System.out.println(root.getName() + "--" + root.getData());
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
