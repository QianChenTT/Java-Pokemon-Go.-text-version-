import java.util.Scanner;
public class Player {
    String name;
    Pokemon[] pokemons;
    int activePokemonIndex, numberOfPokemons;
    private Scanner scanner;
    public Player(String name){
        pokemons = new Pokemon[6];
        this.name = name;
        scanner = new Scanner(System.in);
        activePokemonIndex = -1;
    }
    public void addPokemon(Pokemon p){
        if (numberOfPokemons == 6){
            return;
        }
        pokemons[numberOfPokemons] = p;
        numberOfPokemons++;
    }
    public boolean switchPokemon(){
        displayTeam();
        System.out.println(name + " Choose Pokemon");
        int chosenPokemon = scanner.nextInt() - 1;
        if(chosenPokemon == activePokemonIndex){
            return false;
        }else {
            activePokemonIndex = chosenPokemon;
            System.out.println("Your active pokemon is " + pokemons[activePokemonIndex]);
            return true;
        }
    }
    public int chooseMove(){
        System.out.println(name + " Choose a move");
        return scanner.nextInt() - 1;
    }
    public Pokemon getActivePokemon(){
        return pokemons[activePokemonIndex];
    }
    public boolean checkAlive(){
        for(int i = 0; i < numberOfPokemons; i++){
            if(pokemons[i].status != Pokemon.FAINTED){
                return true;
            }
        }
        return false;
    }
    public void displayActivePokemon(Boolean b){
        System.out.println(pokemons[activePokemonIndex]);
        if(!b){
            return;
        }
        for(int i = 0; i < pokemons[activePokemonIndex].moves.length; i++){
            System.out.println((i + 1) + ". " + pokemons[activePokemonIndex].moves[i]);
        }
    }
    public void displayTeam(){
        for(int i = 0; i < numberOfPokemons; i++){
            System.out.println((i + 1) + ". " + pokemons[i]);
        }
    }
}
