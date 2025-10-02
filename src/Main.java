package esprit.gestionzoo.main;

import esprit.gestionzoo.entities.Animal;
import esprit.gestionzoo.entities.Zoo;


public class Main {
    public static void main(String[] args) {
        // Création d’un zoo
        Zoo zoo = new Zoo("Zoo de Tunis", "Tunis", 5);


        // Création d’un animal
        Animal lion = new Animal("Lion", "Carnivore", 5, true);


        // Utilisation d’un setter pour changer un attribut
        lion.setName("Lion d’Afrique");

        // Utilisation d’un getter pour lire un attribut
        System.out.println("Nom de l’animal : " + lion.getName());

        // Ajouter l’animal au zoo
        zoo.addAnimal(lion);

        // Vérifier avec un getter
        System.out.println("Nombre d’animaux : " + zoo.getAnimalCount());
    }
}
