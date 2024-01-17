public class StatusMove extends Move {
    int status, chanceOfStatus;
    public StatusMove(String name, int type, int uses, int damage, int status, int chanceOfStatus) {
        super(name, type, uses, damage);
        this.status = status;
        this.chanceOfStatus = chanceOfStatus;
    }
    public int resolve(Pokemon user, Pokemon target){
        int result = super.resolve(user, target);
        if(result != Pokemon.NO_STATUS){
            return result;
        }
        if(Math.random() < chanceOfStatus/100.0){
            target.setStatus(status);
        }
        return Pokemon.NO_STATUS;
    }
}
