package lee.sub.test.print.equal;

class Person {
    private String name;
    private String idStr;

    public Person(String name, String idStr) {
        this.name = name;
        this.idStr = idStr;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == Person.class) {
            var personObj = (Person) obj;
            return this.getIdStr().equals(personObj.getIdStr());
        }
        return false;
    }
}

public class OverrideEqualsRight {
    public static void main(String[] args) {
        var p1 = new Person("孙悟空", "12343433433");
        var p2 = new Person("孙行者", "12343433433");
        var p3 = new Person("孙悟饭", "99933433");
        System.out.println("p1和p2是否相等？" + p1.equals(p2));
        System.out.println("p2和p3是否相等？" + p2.equals(p3));
    }
}
