package com.wdm.cls;

/**
 * Created by wdmyong on 2017/10/14.
 */
public class Test {

    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.setBook(new Book("math", "first"));
        teacher.setUser(new User("cj", 18));
        teacher.setNum(1);
        teacher.setLevel(1);
        teacher.setSchool("YZ");
        System.out.println(teacher);
        Book book = teacher.getBook();
        book.setEdition("second");
        User user = teacher.getUser();  // user和teacher里面的成员变量this.user指向同一块内存，修改有效
        user.setAge(20);
        System.out.println(teacher);
        user.setName("chenjuan");
        System.out.println(teacher);
        book.setName("english");
        String school = teacher.getSchool();
        school = "EZ"; // 只是改了引用school的指向，修改对teacher无效
        int num = teacher.getNum();
        num = 10; // 显然修改对teacher无效
        Integer level = teacher.getLevel();
        level = 10; // 同上
        System.out.println(teacher);
    }
}
