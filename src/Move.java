public class Move {
    String name;
    int type, uses, damage, totalUses, priority;
    public Move(String name, int type, int uses, int damage) {
        this.name = name;
        this.type = type;
        this.uses = uses;
        this.damage = damage;
        this.totalUses = uses;
        this.priority = 0;
    }
    public int resolve(Pokemon user, Pokemon target) {
        if(user.status == Pokemon.FAINTED || target.status == Pokemon.FAINTED){
            return Pokemon.FAINTED;
        }
        if(user.status == Pokemon.SLEEP){
            return Pokemon.SLEEP;
        }
        System.out.println(user.name + " used " + name + " on " + target.name);
        target.takeDamage((int)(Type.effectiveness[type][target.type] * damage * user.attack/target.defense/1.0));
        uses--;
        return Pokemon.NO_STATUS;
    }
    public String toString(){
        return name + " (" + Type.toString[type] + ") " + uses + "/" + totalUses;
    }
}
