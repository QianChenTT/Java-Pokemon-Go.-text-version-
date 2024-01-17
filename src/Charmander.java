public class Charmander extends Pokemon {
    
    public Charmander(String name){
        super(name, 100, 20, 40, 10, Type.FIRE);
        moves[0] = new Ember();
        moves[1] = new QuickAttack();
        moves[2] = new Willowisp();
    }

}
