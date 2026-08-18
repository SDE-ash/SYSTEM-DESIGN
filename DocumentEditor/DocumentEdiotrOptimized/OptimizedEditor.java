package DocumentEditor.DocumentEdiotrOptimized;

import java.util.ArrayList;
import java.util.List;

interface DocumentElement {
    public String render();
}

class TextElement implements DocumentElement{
    String text;

    public TextElement(String text){
        this.text = text;
    }

    @Override
    public String render(){
        return text;
    }
} 

class ImageElement implements DocumentElement{
    String imgPath;

    public ImageElement(String imgPath){
        this.imgPath = imgPath;
    }

    public String render(){
        return "/n IMAGE PATH :"+imgPath;
    }
}

interface Persistence {
    public void save();
}


class SaveToFile implements Persistence{
    public void save(){
        System.out.print("File saved on current path :)");
    }
}

class SaveToDB implements Persistence {
     public void save(){
        System.out.print("File saved on DB :)");
    }
}


class Document {
    List<DocumentElement> documentElements = new ArrayList<>();

    void addElement(DocumentElement element){
       documentElements.add(element);
    }

    public String render(){
        String result = "";
        for(DocumentElement ele : documentElements){
            result+= ele.render();
        }
        return result;
    }

    
}

class DocEdit {
    private Document document;
    private Persistence persistence;
    String renderDocument  ="";

    public DocEdit(Document document, Persistence persistence  ){
        this.persistence = persistence;
        this.document = document;
    }

    void addText(String text){
        document.addElement(new TextElement(text));
    }

    void addImage(String imgPath){
        document.addElement(new ImageElement(imgPath));
    }

    String renderDocument(){
        if(renderDocument.isEmpty()){
            renderDocument = document.render();
        }
        return renderDocument;
    }


    void saveDocument() {
        persistence.save();
    }
}
public class OptimizedEditor {
       public static void main(String[] args) {
        Document doc = new Document();
        Persistence per = new SaveToFile();
        
        DocEdit editor = new DocEdit(doc, per);
        editor.addText("HI THIS IS AKASH");
        editor.addImage("c://ajan.jpg");
        editor.renderDocument();
        editor.saveDocument();

    }
        
}
