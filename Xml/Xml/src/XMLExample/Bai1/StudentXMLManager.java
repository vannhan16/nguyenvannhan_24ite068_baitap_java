package XMLExample.Bai1;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;

public class StudentXMLManager {
    private static final String FILE_NAME = "students.xml";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== QUẢN LÝ SINH VIÊN ===");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Hiển thị danh sách sinh viên");
            System.out.println("3. Xóa sinh viên theo ID");
            System.out.println("4. Cập nhật sinh viên theo ID");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    deleteStudent(scanner);
                    break;
                case 4:
                    updateStudent(scanner);
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    // Thêm sinh viên vào file XML
    public static void addStudent(Scanner scanner) {
        try {
            File file = new File(FILE_NAME);
            Document document;
            Element root;
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            if (file.exists()) {
                document = builder.parse(file);
                root = document.getDocumentElement();
            } else {
                document = builder.newDocument();
                root = document.createElement("students");
                document.appendChild(root);
            }

            System.out.print("Nhập ID: ");
            String id = scanner.nextLine();
            System.out.print("Nhập tên: ");
            String name = scanner.nextLine();
            System.out.print("Nhập tuổi: ");
            String age = scanner.nextLine();
            System.out.print("Nhập chuyên ngành: ");
            String major = scanner.nextLine();

            Element student = document.createElement("student");
            student.setAttribute("id", id);

            Element nameElement = document.createElement("name");
            nameElement.setTextContent(name);
            student.appendChild(nameElement);

            Element ageElement = document.createElement("age");
            ageElement.setTextContent(age);
            student.appendChild(ageElement);

            Element majorElement = document.createElement("major");
            majorElement.setTextContent(major);
            student.appendChild(majorElement);

            root.appendChild(student);
            saveXML(document);
            System.out.println("✅ Thêm sinh viên thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Hiển thị danh sách sinh viên từ file XML
    public static void displayStudents() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                System.out.println("⚠ Không có dữ liệu!");
                return;
            }

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();

            NodeList studentList = document.getElementsByTagName("student");
            if (studentList.getLength() == 0) {
                System.out.println("⚠ Không có sinh viên trong danh sách.");
                return;
            }

            System.out.println("\n=== DANH SÁCH SINH VIÊN ===");
            for (int i = 0; i < studentList.getLength(); i++) {
                Element student = (Element) studentList.item(i);
                System.out.println("📌 ID: " + student.getAttribute("id"));
                System.out.println("   - Tên: " + student.getElementsByTagName("name").item(0).getTextContent());
                System.out.println("   - Tuổi: " + student.getElementsByTagName("age").item(0).getTextContent());
                System.out.println("   - Chuyên ngành: " + student.getElementsByTagName("major").item(0).getTextContent());
                System.out.println("----------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Xóa sinh viên theo ID
    public static void deleteStudent(Scanner scanner) {
        try {
            System.out.print("Nhập ID sinh viên cần xóa: ");
            String idToDelete = scanner.nextLine();

            File file = new File(FILE_NAME);
            if (!file.exists()) {
                System.out.println("⚠ File không tồn tại!");
                return;
            }

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            NodeList students = document.getElementsByTagName("student");
            boolean found = false;

            for (int i = 0; i < students.getLength(); i++) {
                Element student = (Element) students.item(i);
                if (student.getAttribute("id").equals(idToDelete)) {
                    student.getParentNode().removeChild(student);
                    found = true;
                    break;
                }
            }

            if (found) {
                saveXML(document);
                System.out.println("✅ Sinh viên có ID " + idToDelete + " đã bị xóa.");
            } else {
                System.out.println("⚠ Không tìm thấy sinh viên có ID " + idToDelete);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Cập nhật sinh viên theo ID
    public static void updateStudent(Scanner scanner) {
        try {
            System.out.print("Nhập ID sinh viên cần cập nhật: ");
            String idToUpdate = scanner.nextLine();

            File file = new File(FILE_NAME);
            if (!file.exists()) {
                System.out.println("⚠ File không tồn tại!");
                return;
            }

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            NodeList students = document.getElementsByTagName("student");
            boolean found = false;

            for (int i = 0; i < students.getLength(); i++) {
                Element student = (Element) students.item(i);
                if (student.getAttribute("id").equals(idToUpdate)) {
                    System.out.print("Nhập tên mới: ");
                    student.getElementsByTagName("name").item(0).setTextContent(scanner.nextLine());

                    System.out.print("Nhập tuổi mới: ");
                    student.getElementsByTagName("age").item(0).setTextContent(scanner.nextLine());

                    System.out.print("Nhập chuyên ngành mới: ");
                    student.getElementsByTagName("major").item(0).setTextContent(scanner.nextLine());

                    found = true;
                    break;
                }
            }

            if (found) {
                saveXML(document);
                System.out.println("✅ Cập nhật sinh viên thành công!");
            } else {
                System.out.println("⚠ Không tìm thấy sinh viên có ID " + idToUpdate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Lưu dữ liệu vào file XML
    private static void saveXML(Document document) throws TransformerException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(document), new StreamResult(new File(FILE_NAME)));
    }
}
