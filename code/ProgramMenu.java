

import java.util.ArrayList;
import java.util.Scanner;

public class ProgramMenu {
    
    // печать меню
    public void mainMenu(){
        System.out.println("""
Выберите что хотите сделать:
1. Завести новое животное
2. Посмотреть животное
3. Команды
                """);
    }

    // проверка на правильность ввода
    public String CheckMenu(ArrayList<String> values){
        String value = this.enterString();
        
        while (!values.contains(value)) {
            this.mainMenu();
            value = this.enterString();
        }
        return value;
    }

    // переход по нужной вкладке
    public void CheckMainMenu(ArrayList<Animals> animals, ArrayList<String> types){
        ArrayList<String> values = new ArrayList<>();
        values.add("1"); 
        values.add("2");
        values.add("3");

        String value = this.CheckMenu(values);
            switch (value) {
                case "1":
                    this.AddAnimal(animals,types);
                    this.mainMenu();
                    this.CheckMainMenu(animals,types);
                    break;
                case "2":
                    this.animalsMenu(animals,types);

                    break;

            }
        
    }

    // печать животных
    public void animalsMenu(ArrayList<Animals> animals, ArrayList<String> types){
        ArrayList<Integer> values = new ArrayList<>();
        System.out.println();

        for (int i = 0; i < animals.size(); i++) {
            System.out.println(i+1+". "+ animals.get(i).name);
            values.add(i);
        }
        System.out.println();
        System.out.println("Выберите животное: ");
        Integer animal = Integer.parseInt(this.enterString());
        
        while (!values.contains((animal)-1)) {
            System.out.println("Выберите животное: ");
            animal = Integer.parseInt(this.enterString());
        }
        animal --;
        this.animalMenu(animals.get(animal));
        String value = this.enterString();

        while (!value.equals("1")) {
            this.animalMenu(animals.get(animal));
            value = this.enterString();
        }
        
        System.out.println("Введите команду: ");
        value = this.enterString();
        animals.get(animal).commands.add(value);
        
        this.mainMenu();
        this.CheckMainMenu(animals,types);
    }
    
    // печать меню
    public void animalMenu(Animals animal){
        System.out.println("""
Выберите что хотите сделать:
Доступные команды: """+ animal.commands + """ 

1. Обучить команде
                """);
    }
    


    // считывание вводимой строки
    public String enterString(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        return str;
    }

    // Добавление животного
    public void AddAnimal(ArrayList<Animals> animals, ArrayList<String> types){
        System.out.println("Введите имя");
        String name = enterString();

        System.out.println("Введите дату рождения");
        String birshday = enterString();

        System.out.println("Введите тип животного (cat, dog, hamster, donkey, camel, horse): ");
        String type = enterString();

        while (!types.contains(type)) {
            System.out.println("Введите тип животного (cat, dog, hamster, donkey, camel, horse): ");
            type = enterString();
        }


        switch (type) {
            case "cat":
                Cat cat = new Cat( name, birshday);
                animals.add(cat);
                break;

            case "dog":
                Dog dog = new Dog( name, birshday);
                animals.add(dog);
                break;

            case "hamster":
                Hamster hamster = new Hamster( name, birshday);
                animals.add(hamster);
                break;


            case "donkey":
                Donkey donkey = new Donkey( name, birshday);
                animals.add(donkey);
                break;

            case "camel":
                Camel camel = new Camel( name, birshday);
                animals.add(camel);
                break;

            case "horse":
                Horse horse = new Horse( name, birshday);
                animals.add(horse);
                break;

        }
    }

}
