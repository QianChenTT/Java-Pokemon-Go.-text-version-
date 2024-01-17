public class Game {
    Player[] players;
    public Game() {
        players = new Player[2];
        players[0] = new Player("Ms.Chew");
        players[1] = new Player("Mr.Sherman");
        players[0].addPokemon(new Bulbasaur("b"));
        players[0].addPokemon(new Charmander("c1"));
        players[0].addPokemon(new Charmander("c2"));
        players[1].addPokemon(new Bulbasaur("b2"));
        players[1].addPokemon(new Charmander("c3"));
        players[1].addPokemon(new Charmander("c4"));
        players[0].addPokemon(new Squirtle("s1"));
        players[1].addPokemon(new Squirtle("s2"));
    }
    public void start() {
        players[0].switchPokemon();
        players[1].switchPokemon();
        while(true){
            players[0].displayActivePokemon(true);
            int playerOneMove = players[0].chooseMove();
            System.out.println("");

            players[1].displayActivePokemon(true);
            int playerTwoMove = players[1].chooseMove();
            System.out.println("");

            resolveMoves(players[0].getActivePokemon(), players[1].getActivePokemon(), players[0].getActivePokemon().moves[playerOneMove], players[1].getActivePokemon().moves[playerTwoMove]);
           
            players[0].getActivePokemon().onRoundEnd();
            players[1].getActivePokemon().onRoundEnd();
            players[0].displayActivePokemon(false);
            players[1].displayActivePokemon(false);
            System.out.println("");

            if(!players[0].checkAlive() && !players[1].checkAlive()){
                System.out.println("Tie");
                return;
            }else if(!players[0].checkAlive()){
                System.out.println(players[1].name + " wins");
                return;
            }else if(!players[1].checkAlive()){
                System.out.println(players[0].name + " wins");
                return;
            }

            if(players[1].getActivePokemon().status == Pokemon.FAINTED){
                players[1].switchPokemon();
            }
            if(players[0].getActivePokemon().status == Pokemon.FAINTED){
                players[0].switchPokemon();
            }
            System.out.println("");
        }
    }

    public void resolveMoves(Pokemon p, Pokemon p2, Move move, Move move2) {
        if(move.priority < move2.priority || (move.priority == move2.priority && (p.speed < p2.speed || p.speed == p2.speed && Math.random() < 0.5))){
            int result = move.resolve(p2,p);
            if(result == Pokemon.SWITCHED){
                players[1].switchPokemon();
            }
            result = move2.resolve(p, players[1].getActivePokemon());
            if(result == Pokemon.SWITCHED){
                players[0].switchPokemon();
            }
        }else{
            int result = move.resolve(p,p2);
            if(result == Pokemon.SWITCHED){
                players[0].switchPokemon();
            }
            result = move2.resolve(p2, players[0].getActivePokemon());
            if(result == Pokemon.SWITCHED){
                players[1].switchPokemon();
            }
        }
    }
}