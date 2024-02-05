import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @org.junit.jupiter.api.Test
    void setFirstName() {
        Person sally = new Person("Sally", "Williams", "123456", "Manager", 2005);
        sally.setFirstName("Sue");
        assertEquals("Sue", sally.getFirstName());
    }

    @org.junit.jupiter.api.Test
    void setLastName() {
        Person sally = new Person("Sally", "Williams", "123456", "Manager", 2005);
        sally.setLastName("Smith");
        assertEquals("Smith", sally.getLastName());
    }

    @org.junit.jupiter.api.Test
    void setTitle() {
        Person sally = new Person("Sally", "Williams", "123456", "Manager", 2005);
        sally.setTitle("Assistant Manager");
        assertEquals("Assistant Manager", sally.getTitle());
    }

    @org.junit.jupiter.api.Test
    void setYOB() {
        Person sally = new Person("Sally", "Williams", "123456", "Manager", 2005);
        sally.setYOB(2006);
        assertEquals(2006, sally.getYOB());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        Person sally = new Person("Sally", "Williams", "123456", "Manager", 2005);
        assertEquals("Person{firstName='Sally', lastName='Williams', ID='123456', title='Manager', YOB=2005}", sally.toString());
    }

    @org.junit.jupiter.api.Test
    void fullName() {
        Person sally = new Person("Sally", "Williams", "123456", "Manager", 2005);
        assertEquals("Sally Williams", sally.fullName());
    }

    @org.junit.jupiter.api.Test
    void formalName() {
        Person sally = new Person("Sally", "Williams", "123456", "Manager", 2005);
        assertEquals("Manager Sally Williams", sally.formalName());
    }

    @org.junit.jupiter.api.Test
    void toCSVDataRecord() {
        Person sally = new Person("Sally", "Williams", "123456", "Manager", 2005);
        assertEquals("Sally,Williams,123456,Manager,2005", sally.toCSVDataRecord());
    }

    @org.junit.jupiter.api.Test
    void toJSONDataRecord() {
        Person sally = new Person("Sally", "Williams", "123456", "Manager", 2005);
        assertEquals("\"firstName\":\"Sally\",\"lastName\":\"Williams\",\"ID\":\"123456\",\"title\":\"Manager\",\"YOB\":2005", sally.toJSONDataRecord());
    }
}