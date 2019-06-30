package utils;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XMLUtils {
	
	public static final String RESOURCE_PATH="beans.xml"; 

	/**
	 * 根据bean标签的id值获取bean标签的class值（类的全路径）
	 * @param beanName
	 * @return
	 */
	public static String readXML(String beanName){
		String clazzName = "";
		try {
			//创建SaxReader对象
			SAXReader reader = new SAXReader();
			//读取XML配置文件，返回Document对象
			Document document = reader.read(XMLUtils.class.getClassLoader().getResourceAsStream(RESOURCE_PATH));
			//通过xpath语句，解析XML获取指定id的bean标签的class值
			//xpath语法：//bean[@id='customerDao']
			List<Element> selectNodes = document.selectNodes("//bean[@id='"+beanName+"']");
			
			for (Element element : selectNodes) {

				clazzName = element.attributeValue("class");
				if (clazzName != null && !"".equals(clazzName)) {
					return clazzName;
				}
			} 
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}
}
