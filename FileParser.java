import java.awt.FileDialog;
import java.awt.Frame;

public class FileParser{
  //Todo: FixME- it doesnt seem that this function in getting the file extension, rather it seems to be getting the name of the file
    public String parseExtension() throws WrongFieTypeException {
        String extension = new String();
        FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
        
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        String file = dialog.getFile();
        
        extension = file.substring(file.lastIndexOf("."));
        if(extension.equals("java")== true|| extension.equals ("txt")== true)
        {
          System.out.println(file + " chosen.");
          
        }
        else{
          throw new WrongFieTypeException("Unsuported file type");
        }
        System.out.println(file);
        
        return file;
      }
      
      public String getFileName(){
        String file = new String("");
        try{
          file= parseExtension();
        }
  catch (WrongFieTypeException e){
    e.printStackTrace();
  }
  if (file.substring(file.lastIndexOf(".")).equals("java")== true || file.substring(file.lastIndexOf(".")).equals("txt")==true){

  }
  return "";
}
}