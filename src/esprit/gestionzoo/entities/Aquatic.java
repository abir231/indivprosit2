package esprit.gestionzoo.entities;

public sealed class Aquatic extends Animal permits Dolphin, Penguin {
    protected String habitat; // ex. "mer", "océan", "bassin"

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
}
