

import java.util.ArrayList;

public abstract class  Animals {
    public ArrayList<String> commands;
    public String name;
    public String birthday;
    public String title;

    public Animals(ArrayList<String> commands, String name, String birthday, String title){
        this.commands = commands;
        this.name = name;
        this.birthday = birthday;
        this.title = title;
    }
}
