/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.io.IOException;

/**
 *
 * @author pkm30
 */
public class Start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
       Check check = new Check();
       Change change = new Change();
       //check.Checker();
       change.Changer();
    }
    
}
