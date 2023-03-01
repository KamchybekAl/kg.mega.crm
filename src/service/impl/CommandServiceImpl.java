package service.impl;

import dao.*;
import dao.impl.*;
import enums.Command;
import enums.exception.WrongCommandException;
import model.*;
import service.CommandService;

import java.util.Arrays;
import java.util.Scanner;

public class CommandServiceImpl implements CommandService {
    @Override
    public void run() {

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
        //Manager[]managers = managerDao.findAll();
        //System.out.println(Arrays.toString(managers));

        MentorDao mentorDao = new MentorDaoImpl();
        Mentor mentor = new Mentor();
        mentor.setId(1);
        mentor.setName("Shaibek");
        mentor.setSurName("Abduerimov");
        mentor.setEmail("abduaiba@gmail.com");
        mentor.setPhone("0999800002");
        mentor.setExperience(4.0);
        mentor.setSalaryForLesson(1200.0);
//        mentorDao.save(mentor);
//        Mentor[]mentors= mentorDao.findAll();
//        System.out.println(Arrays.toString(mentors));


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




        GroupDao groupDao = new GroupDaoImpl();
        Group group = new Group();

        group.setId(1);
        group.setName("Java");
        group.setRoom("8");
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



        Scanner scanner =new Scanner(System.in);
        loop:
        while (true){
            System.out.println("--------------------------");
            System.out.println("Do next action");
            System.out.println("SAVE to downlod object to tetDB");
            System.out.println("FINDALL to print table ");

            Command command = null;

            try {

                command = Command.valueOf(scanner.nextLine());
            } catch (Exception e){
                throw  new WrongCommandException("WRONG COMMAD !!") ;
            }

            if (command != null) {

                switch (command) {
                    case SAVE: {
                        managerDao.save(manager);
                        mentorDao.save(mentor);
                        studentDao.save(student);
                        groupDao.save(group);
                        courseFormatDao.save(courseFormat);
                        System.out.println("Data saved");
                        break loop;
                    }
                    case FINDALL: {
                        Manager[] managers = managerDao.findAll();
                        System.out.println(Arrays.toString(managers));
                        Mentor[] mentors = mentorDao.findAll();
                        System.out.println(Arrays.toString(mentors));
                        Student[] students = studentDao.findAll();
                        System.out.println(Arrays.toString(students));
                        Group[] groups1 = groupDao.findAll();
                        System.out.println(Arrays.toString(groups1));
                        CourseFormat[]courseFormats1 = courseFormatDao.findAll();
                        System.out.println(Arrays.toString(courseFormats1));


                        System.out.println("all table showed");
                        break loop;
                    }
                }

            }
        }

    }
}