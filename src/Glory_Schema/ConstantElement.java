package Glory_Schema;
/**
 *
 * @author Thanzeel
 */
public class ConstantElement extends GloryElement{

    private double _value;
    
    public ConstantElement(double value){
        this._value=value;
    }          
    
    public double getValue()
    {
        return this._value;
    }
    
}
