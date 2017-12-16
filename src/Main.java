import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;

public class Main {

    public static BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {




        System.out.println("Please, enter password");
        String text = scan.readLine();
        //System.out.println("You write :\n"+ text);

        writeToFile(text);
        checkPass();


    }

    private static void checkPass() throws IOException {
        //FileReader reader = new FileReader("C:\\test\\test1.txt");
        //read from java
        InputStream inputj = Main.class.getResourceAsStream("/password.txt");
        //String contentj;
        byte[] buffer = new byte[inputj.available()];
        inputj.read(buffer);
        inputj.close();
        //contentj = new String(buffer).toString().split("\n");
        String contentj = new String(buffer);
        //System.out.println("This is text from password.txt :"+ contentj);


        //read from input txt
        BufferedReader reader = new BufferedReader(new FileReader("C:\\test\\test1.txt"));
        String content = null;
        if ((content = reader.readLine()) != null){
            //System.out.println(content);
            System.out.println(content.equals(contentj) ? "Пароли равны" : "Пароли не совпадают ");
        }
        reader.close();

    }

    private static void writeToFile(String text) throws IOException {
        FileWriter writer = new FileWriter("C:\\test\\test1.txt",false);
        //BufferedWriter bwriter = new BufferedWriter(writer);
        writer.write(text);
        writer.flush();
        writer.close();
        /*bwriter.write(text);
        bwriter.newLine();
        */
        //System.out.println("End of process");
        scan.close();
        writer.close();
    }
}

