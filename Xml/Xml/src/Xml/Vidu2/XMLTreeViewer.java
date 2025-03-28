package Xml.Vidu2;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.File;
import java.io.FileInputStream;


public class XMLTreeViewer {
    public static void main(String[] args) {
        try {
            // Tạo DocumentBuilder và phân tích tài liệu XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("products.xml");

            // Tạo cây từ tài liệu XML
            DefaultMutableTreeNode root = createTree(document.getDocumentElement());

            // Hiển thị JTree
            JTree tree = new JTree(root);
            JFrame frame = new JFrame("XML Tree Viewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new JScrollPane(tree));
            frame.setSize(300, 400);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Hàm đệ quy tạo cây từ nút XML
    public static DefaultMutableTreeNode createTree(Node node) {
        DefaultMutableTreeNode treeNode = new DefaultMutableTreeNode(node.getNodeName());
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node childNode = nodeList.item(i);
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                treeNode.add(createTree(childNode));
            }
        }
        return treeNode;
    }
    // Read XML using StAX
    public static void readXMLWithStAX(String filePath) {
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader reader = factory.createXMLEventReader(new FileInputStream(filePath));
            while (reader.hasNext()) {
                XMLEvent event = reader.nextEvent();
                if (event.isStartElement()) {
                    System.out.println("Start Element: " + event.asStartElement().getName());
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

