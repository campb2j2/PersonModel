public class Main {



    public static void main(String[] args) {


        Person sally = new Person("Sally", "Williams", "123456", "Manager", 2005);
        System.out.println(sally);
        sally.setLastName("Smith");
        System.out.println(sally);
    }
}
