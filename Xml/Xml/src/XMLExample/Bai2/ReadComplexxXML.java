package XMLExample.Bai2;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ReadComplexxXML {
    private static final String FILE_NAME = "company.xml";

    public static void main(String[] args) {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                System.out.println("⚠ File không tồn tại!");
                return;
            }

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();

            NodeList employeeList = document.getElementsByTagName("employee");

            System.out.println("\n=== DANH SÁCH NHÂN VIÊN ===");
            for (int i = 0; i < employeeList.getLength(); i++) {
                Element employee = (Element) employeeList.item(i);
                String id = employee.getAttribute("id");
                String name = employee.getElementsByTagName("name").item(0).getTextContent();

                Element contact = (Element) employee.getElementsByTagName("contact").item(0);
                String email = contact.getElementsByTagName("email").item(0).getTextContent();
                String phone = contact.getElementsByTagName("phone").item(0).getTextContent();

                Element department = (Element) employee.getElementsByTagName("department").item(0);
                String deptName = department.getElementsByTagName("name").item(0).getTextContent();
                String location = department.getElementsByTagName("location").item(0).getTextContent();

                // Hiển thị dữ liệu
                System.out.println("📌 ID: " + id);
                System.out.println("   - Họ tên: " + name);
                System.out.println("   - 📧 Email: " + email);
                System.out.println("   - 📞 SĐT: " + phone);
                System.out.println("   - Phòng ban: " + deptName + " (Vị trí: " + location + ")");
                System.out.println("----------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
