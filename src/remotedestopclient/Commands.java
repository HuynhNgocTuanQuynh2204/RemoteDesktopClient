/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package remotedestopclient;

/**
 *
 * @author TUẤN QUỲNH CODER
 */
public enum Commands {
    PRESS_MOUSE(-1),
    REALEASE_MOUSE(-2),
    PRESS_KEY(-3),
    REALEASE_KEY(-4),
    MOVE_MOUSE(-5);
    
    private int abbrev;

    Commands(int abbrev) {
        this.abbrev=abbrev;
    }
    public int getAbbrev(){
        return abbrev;
    }
    
}
