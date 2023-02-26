package dao.impl;
import dao.ManagerDao;
import dao.MentorDao;
import model.Manager;
import model.Mentor;
import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class MentorDaoImpl implements MentorDao {
    private final String PATH_FILE = "D:\\Users\\kalzhanbaev\\JavaPractice\\WorkSpace\\kg.mega.crm\\lib\\Mentor.txt";
    private final File MENTOR_FILE = new File(PATH_FILE);

    public MentorDaoImpl() {
        boolean isCreated = false;
        if (!MENTOR_FILE.exists()) {
            try {
                isCreated = MENTOR_FILE.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (isCreated) {
            System.out.println("Новый файл mentor.тхт создан");
        }
    }

    @Override
    public void save(Mentor mentor) {
        try {
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(PATH_FILE, true));
            printWriter.print(mentor.getId() + " ");
            printWriter.print(mentor.getName() + " ");
            printWriter.print(mentor.getSurName() + " ");
            printWriter.print(mentor.getEmail() + " ");
            printWriter.print(mentor.getPhone() + " ");
            printWriter.print(mentor.getExperience() + " ");
            printWriter.print(mentor.getSalaryForLesson() + " ");
            printWriter.print(mentor.getDateTimeCreated().toString().substring(0, 22));
            printWriter.println();

            printWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Mentor[] findAll() {
        Mentor[] mentors = new Mentor[100];

        try {
            Scanner scanner = new Scanner(MENTOR_FILE);
            for (int i = 0; scanner.hasNextLine(); i++) {
                Mentor mentor = new Mentor();

                mentor.setId(scanner.nextLong());
                mentor.setName(scanner.next());
                mentor.setSurName(scanner.next());
                mentor.setEmail(scanner.next());
                mentor.setPhone(scanner.next());
                mentor.setExperience(Double.parseDouble(scanner.next()));
                mentor.setSalaryForLesson(Double.parseDouble(scanner.next()));
                mentor.setDateTimeCreated(LocalDateTime.parse(scanner.nextLine().substring(1)));

                mentors[i] = mentor;
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return mentors;
    }

}
