package dao.impl;

import dao.GroupDao;
import model.Group;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;


public class GroupDaoImpl implements GroupDao {

    private final String PATH_FILE = "D:\\Users\\kalzhanbaev\\JavaPractice\\WorkSpace\\kg.mega.crm\\lib\\Group.txt";
    private final File GROUP_FILE = new File(PATH_FILE);

    public GroupDaoImpl() {
        boolean isCreated = false;
        if (!GROUP_FILE.exists()) {
            try {
                isCreated = GROUP_FILE.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (isCreated) {
            System.out.println("Новый файл group.тхт создан");
        }
    }
    @Override
    public void save(Group group) throws IOException {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new FileOutputStream(PATH_FILE, true));
            printWriter.print(group.getId() + " ");
            printWriter.print(group.getName() + " ");
            printWriter.print(group.getRoom() + " ");
            printWriter.print(group.getStartTime() + " ");

            printWriter.print(group.getDateTimeCreated().toString().substring(0, 22));
            printWriter.println();

            printWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            close(printWriter);
        }

    }

    @Override
    public Group[] findAll() throws IOException {
        int count = getCount();

        Group[] groups = new Group[count];
        Scanner scanner = null;
        try {
            scanner = new Scanner(GROUP_FILE);
            for (int i = 0; scanner.hasNextLine(); i++) {
                Group group = new Group();

                group.setId(scanner.nextLong());
                group.setName(scanner.next());
                group.setRoom(scanner.next());
                group.setStartTime(scanner.next());

                group.setDateTimeCreated(LocalDateTime.parse(scanner.nextLine().substring(1)));

                groups[i] = group;
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            close(scanner);
        }


        return groups;
    }

    private int getCount() {
        int count =0;
        try {
            Scanner scan = new Scanner(GROUP_FILE);
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

