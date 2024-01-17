public class Bulbasaur extends Pokemon{

    public Bulbasaur (String name){
        super(name, 120, 20, 40, 1, Type.GRASS);
        moves[0] = new VineWhip();
        moves[1] = new SleepPowder();
        moves[2] = new QuickAttack();
    }
}
