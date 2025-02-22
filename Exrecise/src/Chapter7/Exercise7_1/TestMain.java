package Chapter7.Exercise7_1;

import Chapter1.Exercise1_7.Date;

public class TestMain {
    public static void main(String[] args) {
        Customer customer1 = new Customer("John");
        customer1.setMember(true);
        customer1.setMemberType("Gold");

        Visit visit1 = new Visit(customer1.getName(), new Date());
        visit1.setServiceExpense(100);
        visit1.setProductExpense(50);

        System.out.println(visit1);
        System.out.println("Total expense after discount: " + visit1.getTotalExpense());
    }
}
