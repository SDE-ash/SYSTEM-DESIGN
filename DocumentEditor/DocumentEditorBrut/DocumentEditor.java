package DocumentEditor.DocumentEditorBrut;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DocumentEditor {
    private List<String> elements;
    private String renderedDocument ="";

    public DocumentEditor(List<String> elements) {
        this.elements = elements;
    }

    public void addText(String text){
        elements.add(text);
    }

    public void addImage(String imagePath){
        elements.add(imagePath);
    }

    public String renderDocument(){
        if(renderedDocument.isEmpty()){
            String result ="";
            for(String ele : elements){
                if(ele.contains(".jpg") || ele.contains(".png")){
                    result = result +" Image path:"+ele+"\n";
                }else{
                    result = result+" "+ele+"\n";
                }

                renderedDocument= result;
            }
        }
        return renderedDocument;
    }

    public void saveToFile(){
        try{
            FileWriter file = new FileWriter("DocumentEditor Brut.txt");
            file.write(renderedDocument);
            file.close();
            System.out.print("File saved successfully!");
        }catch(IOException io){
            io.printStackTrace();
        }
    }


    public static void main(String args[]){
       List<String> document = new ArrayList<>();
       

       DocumentEditor editor = new DocumentEditor(document);
       editor.addText("Akash is doing LLD");
       editor.addImage("c;//image1.jpg");
       editor.addText("closed :)");

       editor.renderDocument();
       editor.saveToFile();
    }


}



// The above LD machine code is violating the S,O principle, 
// becase the DocumentEditor class has multiple reasons to be getting changed, [S violates]
// to add more functionality we need to open the class, and edit the code [O violates]
    