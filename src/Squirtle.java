public class Squirtle extends Pokemon{
    public Squirtle (String name){
        super(name, 80, 40, 40, 30, Type.WATER);
        moves[0] = new WaterGun();
        moves[1] = new QuickAttack();
    }
}
