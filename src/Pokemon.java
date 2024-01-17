
public class Pokemon {
    public static final int NO_STATUS = 0;
    public static final int FAINTED = 1;
    public static final int SLEEP = 2;
    public static final int BURNED = 3;
    public static final int POISONED = 4;
    public static final int SWITCHED = 5;
    public static final String[] statusString = {" ", "Fainted", "Sleep", "Burned", "Poisoned","Switched"};
    String name;
    int maxHealth, attack, defense, speed, type, currentHealth, status, sleepCounter;

    Move[] moves;
    public Pokemon(String name, int maxHealth, int attack, int defense, int speed, int type){
        this.name = name;
        this.maxHealth = maxHealth;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.type = type;
        this.currentHealth = maxHealth;
        this.sleepCounter = 0;
        status = NO_STATUS;
        moves = new Move[5];
        moves[4] = new Switch();
    }
    public void setStatus(int status){
        if(status != NO_STATUS && status != SLEEP && status != FAINTED && this.status != NO_STATUS){
            return;
        }
        if(this.status == status){
            return;
        }
        this.status = status;
        if(status == BURNED){
            attack = attack/2;
        }else if(status == SLEEP){
            sleepCounter = 2;
        }
    }
    public void takeDamage(int damage){
        currentHealth = currentHealth - damage;
        if(currentHealth <= 0){
            currentHealth = 0;
            status = FAINTED;
        }
    }
    public void onRoundEnd(){
        if(status == BURNED){
            takeDamage(maxHealth/16);
        }
        if(sleepCounter > 0){
            sleepCounter--;
            if(sleepCounter == 0){
                status = NO_STATUS;
            }
        }
    }
    public String toString(){
        return name + " (" + statusString[status] + ") " + currentHealth + "/" + maxHealth;
    }
}


