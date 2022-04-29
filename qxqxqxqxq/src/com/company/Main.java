package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String input;
        Scanner in = new Scanner(System.in);
        Function y = new Function();
        System.out.println("Введите значения");
        int ss = 1;
        while (true) {
            input = in.nextLine();
            try {
                double x = Double.parseDouble(input);
                y.solvation(x);
                if(ss == 1){
                    System.out.println("Вы можете ввести одну из следующих комманда: save, obnova, provero4ka ");
                    ss++;
                }
            } catch (Exception IOex) {
                if (input.equalsIgnoreCase("save")) {
                    try (ObjectOutputStream qq = new ObjectOutputStream(new FileOutputStream("file.txt"))) {
                        qq.writeObject(y);
                        System.out.println("Сохраненo");
                    } catch (IOException ex) {
                        ex.getMessage();
                    }
                } else if (input.equalsIgnoreCase("obnova")) {
                    try (ObjectInputStream zxc = new ObjectInputStream(new FileInputStream("file.txt"))) {
                        y = (Function) zxc.readObject();
                        System.out.println("все норм");
                    } catch (Exception ex) {
                        ex.getMessage();
                    }
                } else if (input.equalsIgnoreCase("provero4ka")) {
                    System.out.println("x: " + y.x + "\n y: " + y.y);
                } else {
                    System.out.println("такой команды нема");
                }
                System.out.println("Вы можете ввести одну из следующих комманда: save, obnova, provero4ka ");
            }
        }
    }
}

    class Function implements Serializable {
        double x;
        double y;
        Function() {
            x = 0;
            y = 0;
        }

        void solvation(double x) {
            this.x = x;
            y = this.x - Math.sin(this.x);
            System.out.println(y);
        }
    }