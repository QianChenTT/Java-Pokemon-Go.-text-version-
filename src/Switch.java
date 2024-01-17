class Switch extends Move{
    public Switch(){
        super("Switch", Type.NO_TYPE, Integer.MAX_VALUE, 0);
        priority = 6;
    }
    public int resolve(Pokemon user, Pokemon target){
        return Pokemon.SWITCHED;
    }
    public String toString(){
        return "Switch";
    }
}