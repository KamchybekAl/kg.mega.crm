package dao.impl;

import dao.CourseFormatDao;
import model.CourseFormat;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class CourseFormatDaoImpl implements CourseFormatDao {

    private final String PATH_FILE = "D:\\Users\\kalzhanbaev\\JavaPractice\\WorkSpace\\kg.mega.crm\\lib\\CourceForme.txt";
    private final File COURSE_FOR_FILE = new File(PATH_FILE);

    private int count =0;

    public CourseFormatDaoImpl() {
        boolean isCreated = false;
        if (!COURSE_FOR_FILE.exists()) {
            try {
                isCreated = COURSE_FOR_FILE.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (isCreated) {
            System.out.println("Новый файл COURSE_FOR.тхт создан");
        }
    }
    @Override
    public void save(CourseFormat courseFormat) throws IOException {
        count = getCount();
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new FileOutputStream(PATH_FILE, true));
            printWriter.print(++ count + " ");
            printWriter.print(courseFormat.getFormat() + " ");
            printWriter.print(courseFormat.getDurationInWeek() + " ");
            printWriter.print(courseFormat.getisOnline() + " ");
            printWriter.print(courseFormat.getLessonCountPerWeek() + " ");
            printWriter.print(courseFormat.getLessonDuration() + " ");
            printWriter.print(courseFormat.getDateTimeCreated().toString().substring(0, 22));
            printWriter.println();

            printWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            close(printWriter);
        }

    }

    @Override
    public CourseFormat[] findAll() throws IOException {

        CourseFormat[] courseFormats = new CourseFormat[count];
        Scanner scanner = null;
        try {
            scanner = new Scanner(COURSE_FOR_FILE);
            for (int i = 0; scanner.hasNextLine(); i++) {
                CourseFormat courseFormat = new CourseFormat();

                courseFormat.setId(scanner.nextLong());
                courseFormat.setFormat(scanner.next());
                courseFormat.setDurationInWeek(scanner.nextInt());
                courseFormat.setOnline(scanner.nextBoolean());
                courseFormat.setLessonCountPerWeek(scanner.nextInt());
                courseFormat.setLessonDuration(scanner.nextInt());
                courseFormat.setDateTimeCreated(LocalDateTime.parse(scanner.nextLine().substring(1)));

                courseFormats[i] = courseFormat;
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            close(scanner);
        }


        return courseFormats;
    }

    private int getCount() {

        int count = 0;
        try {
            Scanner scan = new Scanner(COURSE_FOR_FILE);
            while (scan.hasNextLine()){
                count ++;

                scan.nextLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return count;
    }


}
