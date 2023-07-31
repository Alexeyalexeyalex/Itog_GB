import java.util.ArrayList;




public class main {
    public static void main(String[] args) {

        ArrayList<Animals> animals = new ArrayList<Animals>();
        ProgramMenu menu = new ProgramMenu();
        ArrayList<String> types = new ArrayList<>();
        types.add("cat");
        types.add("dog");
        types.add("hamster");
        types.add("horse");
        types.add("donkey");
        types.add("camel");


        Camel camel = new Camel( "Akakiy", "2010-03-13");
        Donkey donkey = new Donkey( "Vasya", "2020-09-23");
        Horse horse = new Horse( "Gennadiy", "2017-11-19");

        Cat cat = new Cat( "Artem", "2007-12-19");
        Dog dog = new Dog( "Gera", "2013-06-19");
        Hamster hamster = new Hamster( "Zarg", "2014-03-09");




        animals.add(camel);
        animals.add(cat);

        menu.mainMenu(); 
        menu.CheckMainMenu(animals, types);
        // System.out.println(animals.get(0).name);


    }

}
