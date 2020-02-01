import java.io.File; // Import the File class
import java.io.IOException; // Import the IOException class to handle errors
import java.io.FileWriter;
public class gui {

public static void main(String[] args) {

    final String[] languages = {"Java", "Python", "Quit"};
    final String[] javaOptions = {"Class", "Main", "Method Header", "Create Java File"};
    final String[] pythonOptions = {"Class", "Definition Header", "Python File"};
    final String [] forward = {"Continue", "Quit"};
    String className = new String();
    int answer;
    int language;
    int proceed=0;
    String file_Name = new String();
    FileParser parser = new FileParser();

proceed = GetInfo.getOption("Welcome to the CodeBrew Code Generator GUI", forward);

while (proceed !=1) {
    
    //**Method Header: int-2 */
    //**Class: int-0 */
    //**Main: int-1 */
    language = GetInfo.getOption("Choose a language", languages);

    if (language==0) {
        
        answer= GetInfo.getOption("What do you want to generate", javaOptions);
        
        System.out.println("Your choice:"+ answer);
        
        if(answer ==0 && language==0 /*The language is java*/ )
        {
          try{

            file_Name = parser.parseExtension();
            System.out.println(file_Name);
          }catch(WrongFieTypeException e){
              e.printStackTrace();
          }
            //  try {
            //      FileWriter myWriter = new FileWriter(language+".txt");
            //      myWriter.write("Files in Java might be tricky, but it is fun enough!");
            //      myWriter.close();
            //      System.out.println("Successfully wrote to the file.");
            //    } catch (IOException e) {
            //      System.out.println("An error occurred.");
            //      e.printStackTrace();
            //    }
        }
        if(answer ==1 && language==0 /*The language is java*/ )
        {
            //TODO: Main method string writting to file through file selction

            GetInfo.showMessage("Under Construction");
        }
        if(answer ==0 && language==1 )
        {
            className = GetInfo.getString("What is the name of the method ?");
        }
        if (answer==3 && language ==0){
            String fileName = GetInfo.getString("What do you want to name the file?"); 
            
            while (fileName==null || fileName.isEmpty()== true) {
              GetInfo.showMessage("Invalid Name");
              fileName = GetInfo.getString("What do you want to name the file?");
            }

            try {
                File myObj = new File(fileName +".java");
                if (myObj.createNewFile()) {
                  System.out.println("File created: " + myObj.getName());
                } else {
                  GetInfo.showMessage("File already exists.");
                }
              } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
              }
        }
    }
    //*Python
    if (language==1) {
        
        answer= GetInfo.getOption("What do you want to generate", pythonOptions);
        
        System.out.println("Your choice:"+ answer);
        
        if(answer ==0 && language==1 )
        {
            className = GetInfo.getString("What is the name of the class");
        }
        if(answer ==1&& language==1 )
        {
            className = GetInfo.getString("What is the name of the class");
        }
        if (answer==2 && language ==1){
            String fileName = GetInfo.getString("What do you want to name the file?");
            try {
                File myObj = new File(fileName +".py");
                if (myObj.createNewFile()) {
                  System.out.println("File created: " + myObj.getName());
                } else {
                  System.out.println("File already exists.");
                }
              } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
              } 
        }
    }
    if (language==2){
        return;
        
    }


}

}
}