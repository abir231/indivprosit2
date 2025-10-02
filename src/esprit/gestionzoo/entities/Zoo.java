package esprit.gestionzoo.entities;

public class Zoo {
    private static final int MAX_ANIMALS = 25;
    private Animal[] animals = new Animal[MAX_ANIMALS];
    private int animalCount = 0;
    private String name;
    private String city;
    private final int nbrCages;

    public Zoo(String name, String city, int nbrCages) {
        setName(name); // ✅ validation
        this.city = city;
        if (nbrCages > MAX_ANIMALS) {
            this.nbrCages = MAX_ANIMALS;
        } else {
            this.nbrCages = nbrCages;
        }
    }

    // Getter & Setter pour name (avec validation)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("❌ Erreur : le nom du zoo ne doit pas être vide !");
            this.name = "ZooSansNom"; // valeur par défaut
        } else {
            this.name = name;
        }
    }

    // Getter & Setter pour city
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // Getter pour nbrCages (pas de setter car c’est final)
    public int getNbrCages() {
        return nbrCages;
    }

    // Getter pour animalCount
    public int getAnimalCount() {
        return animalCount;
    }
    public boolean isZooFull() {
        return animalCount >= nbrCages;
    }

    public boolean addAnimal(Animal animal) {
        if (isZooFull()) {
            System.out.println("Impossible d'ajouter " + animal.getName() + " : Zoo plein !");
            return false;
        }
        // Vérifier unicité
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].getName().equals(animal.getName())) {
                System.out.println(animal.getName() + " est déjà dans le zoo !");
                return false;
            }
        }
        animals[animalCount++] = animal;
        System.out.println(animal.getName() + " ajouté au zoo !");
        return true;
    }

}

