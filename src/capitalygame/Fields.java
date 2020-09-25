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

public class Fields {

    private String type;

    private int cost_parameter;

    private String status;

    private String player_owned;

    

    public Fields(String type, int cost_parameter, String status,String player_owned) {

        this.type = type;

        this.cost_parameter = cost_parameter;

        this.status = status;

        this.player_owned=player_owned;

    

}

    

     public Fields() {

    }

    

    



    public String getType() {

        return type;

    }



    public void setType(String type) {

        this.type = type;

    }



    public int getCost_parameter() {

        return cost_parameter;

    }



    public String getPlayer_owned() {

        return player_owned;

    }



    public void setPlayer_owned(String player_owned) {

        this.player_owned = player_owned;

    }

    

    



    public void setCost_parameter(int cost_parameter) {

        this.cost_parameter =cost_parameter;

    }



    public String getStatus() {

        return status;

    }



    public void setStatus(String status) {

        this.status = status;

    }



    @Override

    public String toString() {

        return "Fields{" + "type=" + type + ", cost_parameter=" + cost_parameter + ", status=" + status + ", player_owned=" + player_owned + '}';

    }

    

}

