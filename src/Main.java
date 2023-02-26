import dao.*;
import dao.impl.*;
import model.*;

import javax.swing.plaf.basic.BasicGraphicsUtils;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

      /*  Course course = new Course();
        course.setId(1);
        course.setName("Java");
        course.setPrice(15000);

        CourseFormat bootcamp = new CourseFormat();
        bootcamp.setId(1);
        bootcamp.setFormat("Bootcamp");
        bootcamp.setDurationInWeek(18);
        bootcamp.setOnline(true);
        bootcamp.setLessonCountPerWeek(5);
        bootcamp.setLessonDuration(3);
        //bootcamp.setDateTimeCreated();

        course.setCourseFormat(bootcamp);

        System.out.println(course.toString()); */

        ManagerDao managerDao = new ManagerDaoImpl();
        Manager manager = new Manager();
        manager.setId(2); // make set whith Scaner !!
        manager.setName("Aibek");
        manager.setSurName("Kerimov");
        manager.setEmail("aiba@gmail.com");
        manager.setPhone("0777900002");
        manager.setSalary(78000.0);  // Как сделать, чтобы пердовлась запятая вместо точки ?
        //managerDao.save(manager);
        Manager[]managers = managerDao.findAll();
        System.out.println(Arrays.toString(managers));

        MentorDao mentorDao = new MentorDaoImpl();
        Mentor mentor = new Mentor();
        mentor.setId(1);
        mentor.setName("Shaibek");
        mentor.setSurName("Abduerimov");
        mentor.setEmail("abduaiba@gmail.com");
        mentor.setPhone("0999800002");
        mentor.setExperience(4.0);
        mentor.setSalaryForLesson(1200.0);
        mentorDao.save(mentor);
        Mentor[]mentors= mentorDao.findAll();
        System.out.println(Arrays.toString(mentors));




        GroupDao groupDao = new GroupDaoImpl();
        Group group = new Group();

        group.setId(1);
        group.setName("Java");
        group.setStartTime("45.54.45");

        groupDao.save(group);
        Group[]groups = groupDao.findAll();
        System.out.println(Arrays.toString(groups));


        CourseFormatDao courseFormatDao = new CourseFormatDaoImpl();
        CourseFormat courseFormat = new CourseFormat();

        courseFormat.setId(1);
        courseFormat.setFormat("Bootcamp");
        courseFormat.setDurationInWeek(18);
        courseFormat.setOnline(true);
        courseFormat.setLessonCountPerWeek(5);
        courseFormat.setLessonDuration(3);

        courseFormatDao.save(courseFormat);
        CourseFormat[]courseFormats = courseFormatDao.findAll();
        System.out.println(Arrays.toString(courseFormats));


        StudentDao studentDao = new StudentDaoImpl();
        Student student = new Student();

        student.setId(1);
        student.setName("Bek");
        student.setSurName("Nazarpv");
        student.setEmail("neknazarov@gmail.com");
        student.setPhone("0111800002");
        student.setDateOfBirth("1986-05-12");
//        studentDao.save(student);
//        Student[]students = studentDao.findAll();
//        System.out.println(Arrays.toString(students));












    }
}