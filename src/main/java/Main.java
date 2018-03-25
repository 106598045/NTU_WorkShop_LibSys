import bean.Book;
import model.InputHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gunch on 2018/3/24.
 */
public class Main {
    static int currentIndex = 0;
    static List<String> commandList = new ArrayList<String>();
    public static void main(String[] args) {
        String path = "";
        path = ""+ InputHandler.class.getClassLoader().getResource("");
        path = path.substring(6)+"sampleInput";
        InputHandler inputHandler = new InputHandler(path);
        String content = inputHandler.getInputByFile();

        final String[] splittedStr = content.split("\n");
        commandList = new ArrayList<String>();
        for (String s : splittedStr) {
            commandList.add(s);
        }
       // System.out.println(commandList);
        getBookByCommand();
        System.out.println(currentIndex);
        getUserByCommand();
        System.out.println(currentIndex);
    }

    public static void getBookByCommand(){
        for(int i= currentIndex;i<commandList.size();i++){
            if(commandList.get(currentIndex).matches("\\d")){
                //System.out.println(commandList.get(i));
                int bookNum = Integer.parseInt(commandList.get(i));
                for(int j=0;j<bookNum;j++){
                    String[] s = commandList.get(currentIndex).split("");
                    String bookAuthor = s[0];
                    String bookSubject = s[1];
                    currentIndex++;
                }
                currentIndex = currentIndex+1;
                return;
            }
            currentIndex++;
        }
    }

    public static void getUserByCommand(){
        for(int i= currentIndex;i<commandList.size();i++){
            if(commandList.get(currentIndex).matches("\\d")){
                //System.out.println(commandList.get(i));
                int UserNum = Integer.parseInt(commandList.get(i));
                for(int j=0;j<UserNum;j++){
                    //建User
                }
                currentIndex = i+UserNum+1;
                return;
            }
            currentIndex++;
        }
    }

    public static void getBehaviorByCommand(){
        for(int i= currentIndex;i<commandList.size();i++){
            if(commandList.get(currentIndex).matches("\\d")){
                //System.out.println(commandList.get(i));
                int UserNum = Integer.parseInt(commandList.get(i));
                for(int j=0;j<UserNum;j++){
                    //建User
                }
                currentIndex = i+UserNum+1;
                return;
            }
            currentIndex++;
        }
    }
}
