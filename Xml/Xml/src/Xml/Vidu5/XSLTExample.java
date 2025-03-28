package Xml.Vidu5;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
public class XSLTExample {
    public static void main(String[] args) {
        try {
            // Tạo TransformerFactory
            TransformerFactory factory = TransformerFactory.newInstance();

            // Tạo Transformer từ XSLT
            Source xslt = new StreamSource(new File("products.xsl"));
            Transformer transformer = factory.newTransformer(xslt);

            // Chuyển đổi XML thành HTML
            Source xml = new StreamSource(new File("products.xml"));
            transformer.transform(xml, new StreamResult(new File("output.html")));
            System.out.println("Transformation completed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
