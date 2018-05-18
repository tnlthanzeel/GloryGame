package Glory_Schema.Classes;
/**
 *
 * @author Thanzeel
 */
public class VariableElement extends GloryElement{
    
    private String _name;
    private int _nameValue;
    
    public VariableElement(String name){
    
        this._name=name;
    }
    
    public String getName(){
        
        return this._name;
    }
    
    public int getVariablValue(){
        return this._nameValue;
    }
    
    public void setVariablValue(int nameValue){
         this._nameValue=nameValue;
    }
}
