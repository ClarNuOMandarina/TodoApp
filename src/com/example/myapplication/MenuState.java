package com.example.myapplication;

public enum MenuState {
    CHOOSING(-1),
    CLOSE(0),
    ADD(1),
    REMOVE(2),
    UPDATE(3),
    SHOW(4);

    private final int value;
    MenuState(int value) {
        this.value=value;

    }
    public int getValue(){
        return this.value;
    }
    public static MenuState fromValue(int value) throws IllegalAccessException {
        for(MenuState i:values()){
            if(i.getValue()==value){
                return i;
            }
        }
        throw new IllegalAccessException("error");
    }

}
