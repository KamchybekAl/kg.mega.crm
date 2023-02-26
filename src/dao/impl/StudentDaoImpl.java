package dao.impl;

import model.Mentor;
import model.Student;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class StudentDaoImpl implements StudentDao {

    private final String PATH_FILE = "D:\\Users\\kalzhanbaev\\JavaPractice\\WorkSpace\\kg.mega.crm\\lib\\Student.txt";
    private final File STUDENT_FILE = new File(PATH_FILE);

    public StudentDaoImpl() {
        boolean isCreated = false;
        if (!STUDENT_FILE.exists()) {
            try {
                isCreated = STUDENT_FILE.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (isCreated) {
            System.out.println("Новый файл student.тхт создан");
        }
    }
    @Override
    public void save(Student student) {
        try {
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(PATH_FILE, true));
            printWriter.print(student.getId() + " ");
            printWriter.print(student.getName() + " ");
            printWriter.print(student.getSurName() + " ");
            printWriter.print(student.getEmail() + " ");
            printWriter.print(student.getPhone() + " ");
            printWriter.print(student.getDateOfBirth() + " ");
            printWriter.print(student.getDateTimeCreated().toString().substring(0, 22));
            printWriter.println();

            printWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Student[] findAll() {
        Student[] students = new Student[100];

        try {
            Scanner scanner = new Scanner(STUDENT_FILE);
            for (int i = 0; scanner.hasNextLine(); i++) {
                Student student = new Student();

                student.setId(scanner.nextLong());
                student.setName(scanner.next());
                student.setSurName(scanner.next());
                student.setEmail(scanner.next());
                student.setPhone(scanner.next());
                student.setDateOfBirth(scanner.next());
                student.setDateTimeCreated(LocalDateTime.parse(scanner.nextLine().substring(1)));

                students[i] = student;
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return students;
    }

}
