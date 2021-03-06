package chapter3.item13;

public class A implements Cloneable {
    private String name;
    private int age;

    public A(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof A)) {
            return false;
        }

        A a = (A) o;
        return this.name.equals(a.name) && this.age == a.age;
    }

    // final class 인 경우 new A() 로 선언해도 되지만,
    // final class가 아닌 경우 하위 클래스에서 이슈가 될 수 있어서 supser.clone() 으로 해야한다.
    // 하지만 final class에서 super.clone을 호출 하지 않을꺼면 Cloneable을 사용할 필요도 없다.
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class B extends A {
    public B(String name, int age) {
        super(name, age);
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        B b = new B("심준보", 33);
        B b2 = (B) b.clone();

        // x.clone() != x
        if (b2 != b) {
            System.out.println("b2와 b의 주소값은 다르다");
        }

        // x.clone().getClass() == x.getClass()
        if (b2.getClass() == b.getClass()) {
            System.out.println("b2와 b는 동일 클래스다");
        }

        // x.clone().equals(x) 필수값은 아니다.
        if (b2.equals(b)) {
            System.out.println("b2와 b는 같다");
        }
    }
}