
import java.util.ArrayList;

public abstract class DomesticAnimals  extends Animals{
        
    public DomesticAnimals(ArrayList<String> commands, String name, String birthday){
        super(commands, name, birthday, "Домашние");
    }
    
}