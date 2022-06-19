package Lab_1.Example;

import Lab_1.DoubleLists.DoubleEndedQueue;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example2 {

    /**** Check of number ****/
    public static boolean isNumber(Character ch) {
        if(ch >= '0' && ch <= '9') {
            return true;
        } else {
            return false;
        }
    }

    /**** Regex ****/
    public static void regex(DoubleEndedQueue<String> doubleEndedQueue, String line) {
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(line);
        while(matcher.find()) {
            doubleEndedQueue.pushBack(line.substring(matcher.start(), matcher.end()));
        }
    }

    public static void main(String[] args){

        DoubleEndedQueue<String> doubleEndedQueue = new DoubleEndedQueue<>();
        int count = 0;

        try {
            File fileIN = new File("C:\\Users\\Dima\\IdeaProjects\\SAOD\\src\\Lab_1\\Example\\TextInput.txt");
            File fileOUT = new File("C:\\Users\\Dima\\IdeaProjects\\SAOD\\src\\Lab_1\\Example\\TextOutput.txt");
            // Создание объекта FileRiader для объекта File
            FileReader fr = new FileReader(fileIN);
            // Построчное считывание
            BufferedReader reader = new BufferedReader(fr);
            // Считанем строки

            String line;
            PrintWriter fileWriter = new PrintWriter(fileOUT);

            while ((line = reader.readLine()) != null) {

                regex(doubleEndedQueue, line);

                String newLine = "";

                for (int i = 0; i < line.length(); i++) {
                    Character ch = line.charAt(i);

                    if(isNumber(ch)) { // Check of number
                        continue;
                    }

                    newLine += ch.toString();
                }

                System.out.println("Logger: " + (++count));
                System.out.println("\tLine: " + newLine);
                System.out.println("\tStack: " + doubleEndedQueue.toString());


                while (doubleEndedQueue.empty()) {
                    newLine += doubleEndedQueue.popFront();
                }

                fileWriter.write(newLine + '\n');
            }

            fr.close();
            fileWriter.close();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
