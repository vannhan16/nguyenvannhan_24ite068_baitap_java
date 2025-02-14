package Chapter1.Exercise1_4;

public class TestMain {
    public static void main(String[] args) {
        Employee e1 = new Employee (8,"peter", "tan", 2500);
        System.out.println(e1);
        e1.setSalary(999);
        System.out.println(e1);
        System.out.println("id is:"+e1.getId());
        System.out.println("first name is:"+e1.getFirstName());
        System.out.println("last name is:"+e1.getLastName());
        System.out.println("salary is: " + e1.getSalary());

        System.out.println("id is: " + e1.getId());
        System.out.println("annual salary is: " + e1.getAnnualSalary());

        System.out.println(e1.raiseSalary(10));
        System.out.println(e1);
    }
}
