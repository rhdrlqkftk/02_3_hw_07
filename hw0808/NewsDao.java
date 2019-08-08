package ws;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class NewsDao 
{
	private static NewsDao wdao= new NewsDao(); 
	
	public static NewsDao getInstance()
	{
			return wdao;
	}
	private List<News> NewList =new ArrayList<News>(); 
	public NewsDao()
	{
		NewList.clear(); 
	}
	public List<News> getNewsList()
	{
		connectXML();
		return NewList; 
	}
	public void connectXML()
	{
//		weatherList.clear(); 
		String murl ="http://rss.etnews.com/Section902.xml";
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
		try {
			DocumentBuilder parser = factory.newDocumentBuilder();
			try {
				Document doc=  parser.parse(new URL(murl).openConnection().getInputStream());
				Element root = doc.getDocumentElement();// root -> rss
				NodeList datas = root.getElementsByTagName("item");
				for (int i = 0; i < datas.getLength(); i++) 
				{
					Node data = datas.item(i);
					News we = new News();
					NodeList dataitems = data.getChildNodes();
					for (int j = 0; j < dataitems.getLength(); j++) 
					{
						Node node = dataitems.item(j);
						if(node.getNodeName().equals("title"))
						{
							we.setTitle(node.getFirstChild().getNodeValue().trim());
						}
						else if(node.getNodeName().equals("description")) 
						{
							we.setDesc(node.getFirstChild().getNodeValue().trim());
						}
						else if(node.getNodeName().equals("link"))
						{
							we.setLink(node.getFirstChild().getNodeValue().trim());
						}
						
					}
					NewList.add(we);
				}
			} catch (SAXException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
// <![CDATA[KT&G]>