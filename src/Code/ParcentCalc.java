/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

/**
 *
 * @author Zunaid
 */
public class ParcentCalc {
    private double totalItem;
    private double perCent;

    public void setPerCent(int totalItem) {
        
        this.totalItem = totalItem;
    }

    public double getPerCent(int runingIndex) {
        perCent = (double)runingIndex/totalItem;
        return perCent*100;
    }
    
    
}
