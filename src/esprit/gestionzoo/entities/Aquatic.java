package esprit.gestionzoo.entities;

public abstract sealed class Aquatic extends Animal permits Dolphin, Penguin {
    protected String habitat;

    public Aquatic() {}

    public Aquatic(String family, String name, int age, boolean isMammal, String habitat) {
        super(family, name, age, isMammal);
        this.habitat = habitat;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    // Méthode abstraite : obligatoirement redéfinie dans les sous-classes
    public abstract void swim();
    @Override
    public boolean equals(Object obj) {
        // Vérifier si c'est le même objet
        if (this == obj) return true;

        // Vérifier si obj est null ou n'est pas de la même classe
        if (obj == null || getClass() != obj.getClass()) return false;

        // Convertir obj en Aquatic
        Aquatic other = (Aquatic) obj;

        // Comparer les attributs name, age et habitat
        return this.getName().equals(other.getName())
                && this.getAge() == other.getAge()
                && this.habitat.equals(other.habitat);
    }

}
