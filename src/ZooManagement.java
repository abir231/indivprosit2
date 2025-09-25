import java.util.Scanner;

public class ZooManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nom du zoo : ");
        String zooName = sc.nextLine();

        int nbrCages;
        do {
            System.out.print("Nombre de cages (max 25) : ");
            nbrCages = sc.nextInt();
        } while (nbrCages <= 0);

        Zoo myZoo = new Zoo(zooName, "Tunis", nbrCages);

        // Création d'animaux
        Animal lion = new Animal("Félidé", "Lion", 5, true);
        Animal tiger = new Animal("Félidé", "Tiger", 4, true);
        Animal bear = new Animal("Ursidé", "Bear", 6, true);
        Animal elephant = new Animal("Éléphantidé", "Elephant", 10, true);

        // Ajouter les animaux
        myZoo.addAnimal(lion);
        myZoo.addAnimal(tiger);
        myZoo.addAnimal(bear);
        myZoo.addAnimal(elephant);

        // Tenter d'ajouter un animal déjà présent
        myZoo.addAnimal(lion);

        // Afficher les animaux
        myZoo.displayAnimals();

        // Chercher un animal
        int idx = myZoo.searchAnimal(tiger);
        System.out.println("Indice du Tiger : " + idx);

        // Supprimer un animal
        myZoo.removeAnimal(bear);
        myZoo.displayAnimals();

        // Vérifier si le zoo est plein
        System.out.println("Zoo plein ? " + myZoo.isZooFull());

        // Comparer deux zoos
        Zoo zoo2 = new Zoo("Mini Zoo", "Sfax", 10);
        zoo2.addAnimal(new Animal("Félidé", "Panther", 3, true));
        Zoo biggerZoo = Zoo.comparerZoo(myZoo, zoo2);
        System.out.println("Zoo avec le plus d'animaux : " + biggerZoo);
    }
}
