package esprit.gestionzoo.entities;

public sealed class Animal permits Aquatic, Terrestrial {
    private String family;
    private String name;
    private int age;
    private boolean isMammal;

    public Animal() {}

    // Constructeur paramétré avec validation
    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        setAge(age); // ✅ utilise le setter pour la validation
        this.isMammal = isMammal;
    }

    // Getter & Setter pour family
    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    // Getter & Setter pour name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter & Setter pour age (validation ici)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("❌ Erreur : un animal ne peut pas avoir un âge négatif !");
            this.age = 0; // valeur par défaut
        } else {
            this.age = age;
        }
    }

    // Getter & Setter pour isMammal
    public boolean isMammal() {
        return isMammal;
    }

    public void setMammal(boolean isMammal) {
        this.isMammal = isMammal;
    }

    @Override
    public String toString() {
        return "Animal [Famille=" + family + ", Nom=" + name + ", Âge=" + age + ", Mammifère=" + isMammal + "]";
    }
}
