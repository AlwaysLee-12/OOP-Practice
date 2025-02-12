package hello.oop.reuse.inherit.polymophism;

public class Professor {

    private String name;
    private Lecture lecture; //다형성 : 해당 객체 및 자손 객체 타입 받을 수 있음(업캐스팅과 동적 바인딩)

    public Professor(String name, Lecture lecture) {
        this.name = name;
        this.lecture = lecture;
    }

    public String compileStatistics() {
        return String.format("[%s] %s - Avg : %.1f", name, lecture.evaluate(), lecture.average());
    }
}
