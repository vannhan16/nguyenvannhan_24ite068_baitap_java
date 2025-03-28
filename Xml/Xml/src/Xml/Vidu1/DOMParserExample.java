package Xml.Vidu1;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DOMParserExample {
    public static void main(String[] args){
        try{
            // tạo DocumentBuilderFactory
            DocumentBuilderFactory Factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder =Factory.newDocumentBuilder();
            // phân tích tài liệu XML thành đối tượng Document
            Document document = builder.parse("products.xml");

            // Lầy danh sách các phần tử product
            NodeList productList = document.getElementsByTagName("product");

            //duyệt qua các phần tử products
            for (int i = 0; i < productList.getLength();i++){
                Element product = (Element) productList.item(i);
                String name = product.getElementsByTagName("name").item(0).getTextContent();
                String price = product.getElementsByTagName("price").item(0).getTextContent();
                System.out.println("product: "+ name +", price: "+ price);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
