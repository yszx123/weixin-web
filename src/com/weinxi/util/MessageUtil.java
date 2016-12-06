package com.weinxi.util;

import java.io.Writer;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.weinxi.entity.TextMessage;

public class MessageUtil {

	/**
	 * 解析微信发来的请求（XML）
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	// @SuppressWarnings("unchecked")
	// public static Map<String, String> parseXml(HttpServletRequest request)
	// throws Exception {
	// // 将解析结果存储在HashMap中
	// Map<String, String> map = new HashMap<String, String>();
	// // 从request中取得输入流
	// InputStream inputStream = request.getInputStream();
	// try {
	// // 读取输入流
	// SAXReader reader = new SAXReader();
	// Document document = reader.read(inputStream);
	// // 得到xml根元素
	// Element root = document.getRootElement();
	// // 得到根元素的所有子节点
	// List<Element> elementList = root.elements();
	// // 遍历所有子节点
	// for (Element e : elementList){
	// map.put(e.getName(), e.getText());
	// System.out.println(e.getName()+":"+e.getText());
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }finally{
	// // 释放资源
	// inputStream.close();
	// }
	// return map;
	// }

	/**
	 * 文本消息对象转换成xml
	 * 
	 * @param textMessage
	 *            文本消息对象
	 * @return xml
	 */
	public static String textMessageToXml(TextMessage textMessage) {
		xstream.alias("xml", textMessage.getClass());

		return xstream.toXML(textMessage);
	}

	/**
	 * 扩展xstream，使其支持CDATA块
	 * 
	 */
	private static XStream xstream = new XStream(new XppDriver() {
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				// 对所有xml节点的转换都增加CDATA标记
				boolean cdata = true;

				@SuppressWarnings("rawtypes")
				public void startNode(String name, Class clazz) {
					super.startNode(name, clazz);
					// super.startNode(name);
				}

				protected void writeText(QuickWriter writer, String text) {
					if (cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					} else {
						writer.write(text);
					}
				}
			};
		}
	});
}
