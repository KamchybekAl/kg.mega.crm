package dao.impl;

import dao.ManagerDao;
import model.Manager;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ManagerDaoImpl implements ManagerDao {

    private final String PATH_FILE = "D:\\Users\\kalzhanbaev\\JavaPractice\\WorkSpace\\kg.mega.crm\\lib\\Manager.txt";
    private final File MANAGER_FILE = new File(PATH_FILE);

    public ManagerDaoImpl() {
        boolean isCreated = false;
        if (!MANAGER_FILE.exists()) {
            try {
                isCreated = MANAGER_FILE.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (isCreated) {
            System.out.println("Новый файл менежер.тхт создан");
        }
    }

    @Override
    public void save(Manager manager)  {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new FileOutputStream(PATH_FILE, true));
            printWriter.print(manager.getId() + " ");
            printWriter.print(manager.getName() + " ");
            printWriter.print(manager.getSurName() + " ");
            printWriter.print(manager.getEmail() + " ");
            printWriter.print(manager.getPhone() + " ");
            printWriter.print(manager.getSalary() + " ");
            printWriter.print(manager.getDateTimeCreated().toString().substring(0, 22));
            printWriter.println();

            printWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            close(printWriter);
        }

    }

    @Override
    public Manager[] findAll()  {

        //int count = getCount();
        int count = getCount();
        Manager[] managers = new Manager[count];
        Scanner  scanner = null;
        try {
            scanner = new Scanner(MANAGER_FILE);
            for (int i = 0; scanner.hasNextLine(); i++) {
                Manager manager = new Manager();

                manager.setId(scanner.nextLong());
                manager.setName(scanner.next());
                manager.setSurName(scanner.next());
                manager.setEmail(scanner.next());
                manager.setPhone(scanner.next());
                manager.setSalary(Double.parseDouble(scanner.next()));
                manager.setDateTimeCreated(LocalDateTime.parse(scanner.nextLine().substring(1)));

                managers[i] = manager;
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            close(scanner);
        }


        return managers;
    }

    private int getCount() {
        int count = 0;
        try {
            Scanner scan = new Scanner(MANAGER_FILE);

            while (scan.hasNextLine()) {
                count++;
                scan.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return count;
    }

}

