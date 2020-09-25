// Karan Kumar
//
// RK1LBI
//
// Capitaly
//
// 2018/10/17 03:52:20
//
// This solution was submitted and prepared by Karan Kumar, RK1LBI for the
// Capitaly assignment of the Practical software engineering I. course.
//
// I declare that this solution is my own work.
//
// I have not copied or used third party solutions.
//
// I have not passed my solution to my classmates, neither  made it public.
//
// Students’ regulation of Eötvös Loránd University (ELTE Regulations
// Vol. II. 74/C. § ) states that as long as a student presents another
// student’s work - or at least the significant part of it - as his/her own
// performance, it will count as a disciplinary fault. The most serious
// consequence of a disciplinary fault can be dismissal of the student from
// the University.

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitalygame;

/**
 *
 * @author Karan Kumar
 */
public class Players {
    private String name;
    private String strategy;
    private int balance;
    private int current_position;
    private boolean chance;
    private int buying_power;
    


public Players(String name, String strategy, int balance, int current_position, boolean chance, int buying_power)
    {
        this.name=name;
        this.strategy=strategy;
        this.balance=balance;
        this.current_position=current_position;
        this.chance=chance;
        this.buying_power=buying_power;
       
    }

    public Players() {
    }

    
    

    public String getName() {
        return name;
    }

    public String getStrategy() {
        return strategy;
    }

    public int getBalance() {
        return balance;
    }

    public int getCurrent_position() {
        return current_position;
    }

    public boolean getChance() {
        return chance;
    }

    public int getBuying_power() {
        return buying_power;
    }

    public void setBuying_power(int buying_power) {
        this.buying_power = buying_power;
    }

    public void setChance(boolean chance) {
        this.chance = chance;
    }
    

    public void setName(String name) {
        this.name = name;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setCurrent_position(int current_position) {
        this.current_position = current_position;
    }

    @Override
    public String toString() {
        return "Players{" + "name=" + name + ", strategy=" + strategy + ", balance=" + balance + ", current_position=" + current_position + ", chance=" + chance + ", buying_power=" + buying_power + '}';
    }
}
