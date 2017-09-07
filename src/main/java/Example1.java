/**
 * Created by edutilos on 07.09.17.
 */
public class Example1 {
    public static void main(String[] args) {
         Person p1 , p2 ;
         p1 = new Person(1L, "foo", 10);
         p2 = new Person(2L, "bar", 20);
        System.out.println(p1);
        System.out.println(p2);
    }


    static class Person {
        private long id;
        private String name;
        private int age;

        public Person(long id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public Person() {

        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}