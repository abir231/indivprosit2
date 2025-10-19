package esprit.gestionzoo.entities;

public final class Penguin extends Aquatic {
    private float maxDepth;

    public Penguin(String family, String name, int age, boolean isMammal, String habitat, float maxDepth) {
        super(family, name, age, isMammal, habitat);
        this.maxDepth = maxDepth;
    }

    public float getMaxDepth() {
        return maxDepth;
    }

    public void setMaxDepth(float maxDepth) {
        this.maxDepth = maxDepth;
    }

    @Override
    public void swim() {
        System.out.println(name + " the penguin is swimming!");
    }
}
