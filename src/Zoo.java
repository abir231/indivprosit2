package esprit.gestionzoo.entities;

import esprit.gestionzoo.entities.Animal;
import esprit.gestionzoo.entities.Aquatic;

public class Zoo {
    private static final int MAX_ANIMALS = 25; // constante pour le nombre maximal d'animaux
    private Animal[] animals = new Animal[MAX_ANIMALS]; // tableau d'animaux
    private int animalCount = 0; // compteur d'animaux
    private String name;
    private String city;
    private final int nbrCages; // nombre de cages constant

    private Aquatic[] aquaticAnimals = new Aquatic[10];
    private int aquaticCount = 0;

    public boolean addAquaticAnimal(Aquatic aquatic) {
        if (aquaticCount >= aquaticAnimals.length) {
            System.out.println("Impossible d'ajouter " + aquatic.getName() + " : Aquarium plein !");
            return false;
        }
        aquaticAnimals[aquaticCount++] = aquatic;
        System.out.println(aquatic.getName() + " ajouté à l'aquarium !");
        return true;
    }

    public Zoo(String name, String city, int nbrCages) {
        this.name = name;
        this.city = city;
        if (nbrCages > MAX_ANIMALS) {
            this.nbrCages = MAX_ANIMALS;
        } else {
            this.nbrCages = nbrCages;
        }
    }

    // Méthode pour afficher le zoo
    public void displayZoo() {
        System.out.println("Zoo : " + name + ", Ville : " + city + ", Cages : " + nbrCages);
    }

    @Override
    public String toString() {
        return "Zoo [Nom=" + name + ", Ville=" + city + ", Cages=" + nbrCages + ", Animaux=" + animalCount + "]";
    }

    // Instruction 10 : Ajouter un animal
    public boolean addAnimal(Animal animal) {
        if (animalCount >= nbrCages) {
            System.out.println("Impossible d'ajouter " + animal.name + " : Zoo plein !");
            return false;
        }
        // Vérifier unicité
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].name.equals(animal.name)) {
                System.out.println(animal.name + " est déjà dans le zoo !");
                return false;
            }
        }
        animals[animalCount++] = animal;
        System.out.println(animal.name + " ajouté au zoo !");
        return true;
    }

    // Instruction 11 : Afficher tous les animaux
    public void displayAnimals() {
        System.out.println("Animaux dans le zoo :");
        for (int i = 0; i < animalCount; i++) {
            System.out.println(animals[i]);
        }
    }

    // Instruction 11 : Chercher un animal par nom
    public int searchAnimal(Animal animal) {
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].name.equals(animal.name)) {
                return i;
            }
        }
        return -1;
    }

    // Instruction 13 : Supprimer un animal
    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1) {
            System.out.println(animal.name + " non trouvé dans le zoo.");
            return false;
        }
        // Décaler les éléments pour combler le trou
        for (int i = index; i < animalCount - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[--animalCount] = null;
        System.out.println(animal.name + " supprimé du zoo.");
        return true;
    }

    // Instruction 15 : Vérifier si le zoo est plein
    public boolean isZooFull() {
        return animalCount >= nbrCages;
    }

    // Instruction 16 : Comparer deux zoos et retourner celui avec le plus d'animaux
    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        return (z1.animalCount >= z2.animalCount) ? z1 : z2;
    }

    public void makeAquaticAnimalsSwim() {
        for (int i = 0; i < aquaticCount; i++) {
            aquaticAnimals[i].swim();
        }
    }

    public float maxPenguinSwimmingDepth() {
        float maxDepth = 0;

        for (int i = 0; i < aquaticCount; i++) {
            if (aquaticAnimals[i] instanceof Penguin penguin) {
                if (penguin.getMaxDepth() > maxDepth) {
                    maxDepth = penguin.getMaxDepth();
                }
            }
        }

        return maxDepth;
    }

    public void displayNumberOfAquaticsByType() {
        int dolphinCount = 0;
        int penguinCount = 0;

        // Parcourir tous les animaux aquatiques
        for (int i = 0; i < aquaticCount; i++) {
            if (aquaticAnimals[i] instanceof Dolphin) {
                dolphinCount++;
            } else if (aquaticAnimals[i] instanceof Penguin) {
                penguinCount++;
            }
        }

        System.out.println("Nombre de dauphins : " + dolphinCount);
        System.out.println("Nombre de pingouins : " + penguinCount);
    }

}
