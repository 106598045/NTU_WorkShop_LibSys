import bean.Book;
import model.InputHandler;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by gunch on 2018/3/24.
 */
public class Main {
    static Queue<String> commandList = new LinkedList<String>();
    public static void main(String[] args) {
        String path = "";
        path = ""+ InputHandler.class.getClassLoader().getResource("");
        path = path.substring(6)+"sampleInput";
        InputHandler inputHandler = new InputHandler(path);
        String content = inputHandler.getInputByFile();

        final String[] splittedStr = content.split("\n");
        for (String s : splittedStr) {
            commandList.add(s);

        }
        getBookByCommand();
        getUserByCommand();
        getBehaviorByCommand();
    }

    public static void getBookByCommand(){
        for(int i= 0;i<commandList.size();i++){
            String currentCmd = commandList.poll();
            if(currentCmd.matches("\\d")){
                int bookNum = Integer.parseInt(currentCmd);
                for(int j=0;j<bookNum;j++){
                    String[] s = commandList.poll().split(" ");
                    String bookAuthor = s[0];
                    String bookSubject = s[1];
                    System.out.println(bookAuthor+","+bookSubject);
                }
                return;
            }
        }
    }

    public static void getUserByCommand(){
        for(int i= 0;i<commandList.size();i++){
            String currentCmd = commandList.poll();
            if(currentCmd.matches("\\d")){
                int userNum = Integer.parseInt(currentCmd);
                for(int j=0;j<userNum;j++){
                    String[] s = commandList.poll().split(" ");
                    String userType = s[0];
                    String userName = s[1];
                    if(userType == "Borrower"){
                        String limit = s[2];
                    }
                    System.out.println(userType+","+userName);
                }
                return;
            }
        }
    }

    public static void getBehaviorByCommand(){
        while (!commandList.isEmpty()){
            String currentCmd = commandList.poll();
            if(currentCmd.contains("addBook")){
                System.out.println("addBook");
            }else if(currentCmd.contains("removeBook")){
                System.out.println("removeBook");
            }else if(currentCmd.contains("checkout")){
                System.out.println("checkout");
            }else if(currentCmd.contains("return")){
                System.out.println("return");
            }else if(currentCmd.contains("listAuthor")){
                System.out.println("listAuthor");
            }else if(currentCmd.contains("listSubject")){
                System.out.println("listSubject");
            }else if(currentCmd.contains("findChecked")){
                System.out.println("findChecked");
            }else if(currentCmd.contains("findBorrower")){
                System.out.println("findBorrower");
            }
        }
    }
}
