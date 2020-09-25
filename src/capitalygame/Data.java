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



import java.io.File;

import java.io.FileNotFoundException;

import java.util.ArrayList;

import java.util.Scanner;



/**

 *

 * @author Karan Kumar

 */

public class Data {

    private final ArrayList<Players> players_data;

    private final ArrayList<Fields> fields_data;







    public Data() {



        players_data = new ArrayList<>();

        fields_data= new ArrayList<>();



    }



    



    public void read(String filename) throws FileNotFoundException, InvalidInputException



    {



    Scanner reader = new Scanner(new File(filename)); 



        if (reader.hasNextInt()) 



        { 



            int num_of_fields;



            String type;



            int cost;

            



            num_of_fields = reader.nextInt();

            System.out.println(num_of_fields);

            while(num_of_fields>0)



            {



            Fields allfields;



            type=reader.next();

            System.out.println(type);

            switch(type)



            {

                case "P":

                    cost=reader.nextInt();

                    System.out.println(cost);

                    allfields= new Property(cost,"empty","none");

                    break;

                case "S":

                    cost=reader.nextInt();

                    System.out.println(cost);

                    allfields= new Service(cost,"empty","none");

                    break;

                case "L":

                    cost=reader.nextInt();

                    System.out.println(cost);

                    allfields= new Lucky(cost,"empty","none");

                    break;

                default:

                    throw new InvalidInputException();



            }

            num_of_fields--;

            fields_data.add(allfields);

            }

            

            if(reader.hasNextInt())

            {

            int num_of_players;

            String name;

            String strategy;

            num_of_players = reader.nextInt();

            System.out.println(num_of_players);

            while(num_of_players>0)

            {

                Players allplayers;



                strategy=reader.next();

                System.out.println(strategy);

                switch(strategy)

                {

                    case "G":

                        name=reader.next();

                        System.out.println(name);

                        allplayers=new Greedy(name,10000,0);

                        break;

                    case "C":

                        name=reader.next();

                        System.out.println(name);

                        allplayers=new Careful(name,10000,0);

                        break;

                    case "T":

                        name=reader.next();

                        System.out.println(name);

                        allplayers=new Tactical(name,10000,0);

                        break;

                    default:

                    throw new InvalidInputException();

                        

                }

                

                num_of_players--;



                players_data.add(allplayers);

            }          

            }                       

        } 

        reader.close();   

    }

    

    public void report(String filename) throws FileNotFoundException, InvalidInputException

    {

        Scanner dice_cnt = new Scanner(new File(filename)); 

        int total_players;

        int total_fields;

        int current_player=0;

        int dice;

        int previous_position;

        int current_position;

        boolean chance;

        //boolean operated;

        Players player=new Players();

        Fields field=new Fields();

        int bank=0;

        int max_players=players_data.size();

        

        

        

        while (dice_cnt.hasNextInt() && players_data.size()>1)

        {

         chance=true;

         dice=dice_cnt.nextInt();

         //System.out.println(dice);

         total_players=players_data.size();

         total_fields=fields_data.size();

         player=players_data.get(current_player%total_players);

         previous_position=player.getCurrent_position();

         System.out.println(previous_position);

         current_position=(previous_position+dice)%(fields_data.size()+1);

         System.out.println(current_position);

         //field=fields_data.get(current_position-1);

         player.setCurrent_position(current_position);

         //System.out.println(dice+previous_position);

         if(player.getStrategy()=="C")

         {

             if((previous_position+dice)>total_fields)

             {

                 player.setBuying_power(player.getBalance()/2);

             }

         }

         

         if(current_position==0)

         {

             players_data.set(current_player%total_players,player);

         }
         

         else

         {

             field=fields_data.get(current_position-1);

             

             if(field.getType()=="L")

             {

                 player.setBalance(player.getBalance()+field.getCost_parameter());

                 player.setBuying_power(player.getBuying_power()+field.getCost_parameter());

                 players_data.set(current_player%total_players,player);

                 

             }

             

             else if(field.getType()=="S")

             {

                 if(player.getBalance()>=field.getCost_parameter())

                 {

                 player.setBalance(player.getBalance()-field.getCost_parameter());

                 player.setBuying_power(player.getBuying_power()-field.getCost_parameter());

                 bank=bank+field.getCost_parameter();

                 players_data.set(current_player%total_players,player);

                 }

                 else

                 {

                     Fields prop=new Fields();

                     for(int i=0;i<fields_data.size();i++)

                     {

                         prop=fields_data.get(i);

                         if(prop.getPlayer_owned()==player.getName())

                         {

                             prop.setPlayer_owned("none");

                             prop.setStatus("empty");

                             fields_data.set(i,prop);

                         }

                         

                     }

                     players_data.remove(current_player%total_players);

                     System.out.println("Player Lost:");

                     System.out.println(player);

                 }

             }

             

             else if(field.getType()=="P")

             {

                 if(field.getStatus()=="house" && field.getPlayer_owned()!=player.getName())

                 {

                     if(player.getBalance()>=2000)

                     {

                         player.setBalance(player.getBalance()-2000);

                         player.setBuying_power(player.getBuying_power()-2000);

                         String name_owner=field.getPlayer_owned();

                         int id_owner=0;

                         Players owner_data=new Players();

                         

                         for(int i=0;i<players_data.size();i++)

                         {

                             

                             owner_data=players_data.get(i);

                             if(owner_data.getName()==name_owner)

                             {

                                 id_owner=i;

                                 i=players_data.size();

                             }

                         }

                         owner_data.setBalance(owner_data.getBalance()+2000);

                         owner_data.setBuying_power(owner_data.getBuying_power()+2000);

                         players_data.set(id_owner, owner_data);

                         players_data.set(current_player%total_players,player);

                         

                     }

                     else

                     {

                         String name_owner=field.getPlayer_owned();

                         int id_owner=0;

                         Players owner_data=new Players();

                         

                         for(int i=0;i<players_data.size();i++)

                         {

                             

                             owner_data=players_data.get(i);

                             if(owner_data.getName()==name_owner)

                             {

                                 id_owner=i;

                                 i=players_data.size();

                             }

                         }

                         Fields prop=new Fields();

                     for(int i=0;i<fields_data.size();i++)

                     {

                         prop=fields_data.get(i);

                         if(prop.getPlayer_owned()==player.getName())

                         {

                             prop.setPlayer_owned("none");

                             prop.setStatus("empty");

                             fields_data.set(i,prop);

                         }

                         

                     }

                     

                         owner_data.setBalance(owner_data.getBalance()+player.getBalance());

                         owner_data.setBuying_power(owner_data.getBuying_power()+player.getBalance());

                         players_data.set(id_owner, owner_data);

                         players_data.remove(current_player%total_players);

                         System.out.println("Player Lost:");

                         System.out.println(player);

                     }

                 }

                 

                 else if(field.getStatus()=="owned" && field.getPlayer_owned()!=player.getName())

                 {

                     if(player.getBalance()>=500)

                     {

                         player.setBalance(player.getBalance()-500);

                         player.setBuying_power(player.getBuying_power()-500);

                         String name_owner=field.getPlayer_owned();

                         int id_owner=0;

                         Players owner_data=new Players();

                         

                         for(int i=0;i<players_data.size();i++)

                         {

                             

                             owner_data=players_data.get(i);

                             if(owner_data.getName()==name_owner)

                             {

                                 id_owner=i;

                                 i=players_data.size();

                             }

                         }

                         owner_data.setBalance(owner_data.getBalance()+500);

                         owner_data.setBuying_power(owner_data.getBuying_power()+500);

                         players_data.set(id_owner, owner_data);

                         players_data.set(current_player%total_players,player);

                         

                     }

                     else

                     {

                         String name_owner=field.getPlayer_owned();

                         int id_owner=0;

                         Players owner_data=new Players();

                         

                         for(int i=0;i<players_data.size();i++)

                         {

                             

                             owner_data=players_data.get(i);

                             if(owner_data.getName()==name_owner)

                             {

                                 id_owner=i;

                                 i=players_data.size();

                             }

                         }

                         Fields prop=new Fields();

                     for(int i=0;i<fields_data.size();i++)

                     {

                         prop=fields_data.get(i);

                         if(prop.getPlayer_owned()==player.getName())

                         {

                             prop.setPlayer_owned("none");

                             prop.setStatus("empty");

                             fields_data.set(i,prop);

                         }

                         

                     }

                  

                         owner_data.setBalance(owner_data.getBalance()+player.getBalance());

                         owner_data.setBuying_power(owner_data.getBuying_power()+player.getBalance());

                         players_data.set(id_owner, owner_data);

                         players_data.remove(current_player%total_players);

                         System.out.println("Player Lost:");

                         System.out.println(player);

                     }

                 }

                     else if(field.getStatus()=="owned" && field.getPlayer_owned()==player.getName())

                     {

                             if(player.getBalance()>=4000)

                             {

                             player.setBalance(player.getBalance()-4000);

                             player.setBuying_power(player.getBuying_power()-4000);

                             field.setStatus("house");

                             field.setPlayer_owned(player.getName());

                             players_data.set(current_player%total_players,player);

                             fields_data.set(current_position-1,field);

                             }

                     }

                 

                     else if(field.getStatus()=="empty")

                     {

                         if(player.getBuying_power()>=1000)

                         {

                             if(player.getStrategy()=="T" && player.getChance()==true)

                             {

                                 player.setBalance(player.getBalance()-1000);

                                 player.setBuying_power(player.getBuying_power()-1000);

                                 player.setChance(false);

                                 field.setStatus("owned");

                                 field.setPlayer_owned(player.getName());

                                 players_data.set(current_player%total_players, player);

                                 fields_data.set(current_position-1,field);

                             }

                             else if(player.getStrategy()=="T" && player.getChance()==false)

                             {

                                 player.setChance(true);

                                 players_data.set(current_player%total_players, player);

                             }

                             

                             else if (player.getStrategy()!="T")

                             {

                                 player.setBalance(player.getBalance()-1000);

                                 player.setBuying_power(player.getBuying_power()-1000);

                                 field.setStatus("owned");

                                 field.setPlayer_owned(player.getName());

                                 players_data.set(current_player%total_players,player);

                                 fields_data.set(current_position-1,field);

                             }

                         }

                     }

                 }

             }

             if(players_data.size()==total_players)

             {

             current_player=current_player+1;

             }

             

          

         }

         

        if(players_data.size()==1)

        {

            System.out.println("Winner of game:");

            Players win=new Players();

            win=players_data.get(0);

            System.out.println(win);

        }

        else

        {

    

         int i=1;

        for(Players a:players_data)

        {

            

            int j=0;

            System.out.println("Details of player"+"#"+i+":");

            System.out.println(a);

            System.out.println("Details of player"+"#"+i+" properties"+":");

             for(Fields b:fields_data)

            {

                if(b.getPlayer_owned()==a.getName())

                {

                    System.out.println(b);

                    j=j+1;

                }

            }

             if(j==0)

             {

                 System.out.println("No properties owned!");

             }

             j=0;

            i=i+1;

        }

    }}}

