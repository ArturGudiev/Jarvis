import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by Artur on 26.04.2017.
 */
public class Jarvis {

    public static void greeting(){
        System.out.println("Hello, my friend. How are you?");

        try {
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            if(s.toLowerCase().contains("fine")){
                System.out.println("I am glad you are fine");
            }else{
                System.out.println("not fine?");
            }
        }catch (Exception ignore){}
    }

    public static void cmdLineQuery(String... args){
        try {
            Runtime.getRuntime().exec(args);
        }catch (Exception e){
            System.err.println(e);
        }
    }

    public static void main(String[] args)  {
        //greeting();
        if(args.length > 0){
            if(args[0].equals("youtube")){
                System.out.println("connecting to youtube");
                String query = "https://www.youtube.com/results?search_query=" + args[1];
                cmdLineQuery(new String[]{"cmd", "/c", "start Browser " + query});
            }
            if(args[0].equals("gs") || args[0].equals("google")){
                System.out.println("connecting to google");
                String query = "http://www.google.com/search?q=" + args[1];
                System.out.println(query);
                cmdLineQuery(new String[]{"cmd", "/c", "start Browser " + query});
            }
            if(args[0].equals("soccer")){
                cmdLineQuery(new String[]{"cmd", "/c", "start Browser soccer.ru"});
            }
            if(args[0].equals("vk")){
                cmdLineQuery(new String[]{"cmd", "/c", "start Browser vk.com/im"});
            }
            if(args[0].equals("mail")){
                cmdLineQuery(new String[]{"cmd", "/c", "start Browser gmail.com"});
            }
            if(args[0].equals("later")){
                cmdLineQuery(new String[]{"cmd", "/c",
                        "start Browser https://docs.google.com/spreadsheets/d/1X7d75G8DFzHrYs6lMzlPZyDFUJCVUy3OnHfcv3vjlHo/edit#gid=0"});
            }
        }

    }
}
