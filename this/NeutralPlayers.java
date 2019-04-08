//Made by Josh Obiha and Syed Ahmed
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class NeutralPlayers extends Player {
    String cpuHand;
    int winCounter  = 0;
    int loseCounter = 0;

	protected ArrayList<Location> path;




    public NeutralPlayers(World w, String name, Location location,String dialogue,boolean hostile, List<Thing> things, List<Location> path ){
        super(w, name, location, dialogue, hostile, things);
        this.path = path;
    }

    public String   getNeutralPlayerName(){
        return name;
    }
    public Location getNeutralPlayerLocation(){
        return location;
    }
    public boolean  getHostile(){return  hostile;}        //movement for security guards

	public Location getpath(){
    	return this.path;
    }

    public Location setpath(Location path){

      this.path =path;

    }

	public Location setNeutralPlayerLocation(Location location) {

		this.location=location;
	}
    public void setHostile(){

//        if(getNeutralPlayerLocation())

    }

    public void interact(){

        System.out.println("Hi, welcome to UOttawa.");

        if(getNeutralPlayerName().equals("UOttawa Student")){
            Scanner in = new Scanner(System.in);
            System.out.println("Best university in the world. How can i help you ?(directions - d), (RPS - r): ");
            String request = in.nextLine();

            if (request.equals("d")) {
                System.out.println("We are in the: " + getNeutralPlayerLocation().toString());

            }
            if(request.equals("r")){

                System.out.println("Okay lets go!!! ");
                System.out.println("best 2 out of 3");

                Random randomGeneratedInt = new Random();


                for(int i = 0; i < 6; i++){
                    Scanner input = new Scanner (System.in);
                    System.out.println("Rock, Paper, Scissors, shoot!!! (R,P,S):");
                    String hand = input.nextLine();
                    hand = hand.toUpperCase();
                    int randomInt = randomGeneratedInt.nextInt(3);

                    if(randomInt == 0){cpuHand = "S";}

                    if(randomInt == 1){cpuHand = "R";}

                    if(randomInt == 2){cpuHand = "P";}

                    if(hand.equals(cpuHand)){System.out.println("Tie");}

                    if(hand.equals("R") && cpuHand.equals("S")){
                        System.out.println("R > S : win" );
                        winCounter = winCounter + 1;
                    }
                    if(hand.equals("S") && cpuHand.equals("P")){
                        System.out.println("S > P: win");
                        winCounter = winCounter + 1;
                    }
                    if(hand.equals("P") && cpuHand.equals("R")) {
                        System.out.println("P > R : win");
                        winCounter = winCounter + 1;
                    }
                    if(hand.equals("R") && cpuHand.equals("P")){
                        System.out.println("R < P : lose");
                        loseCounter = loseCounter + 1;
                    }
                    if(hand.equals("S") && cpuHand.equals("R")){
                        System.out.println("S < R : lose");
                        loseCounter = loseCounter + 1;
                    }
                    if(hand.equals("P") && cpuHand.equals("S")){
                        System.out.println("P < S : lose");
                        loseCounter = loseCounter + 1;
                    }

                    if(winCounter == 2){

                        System.out.println("You win !!!!");
                        break;
                    }
                    if(loseCounter ==2){
                        System.out.println("You lose !!!!");

                        break;
                    }
                }
            }
        }

        if (getNeutralPlayerName().equals("Campus Security")){

            Scanner in = new Scanner(System.in);
            System.out.println("Best university in the world. How can i help you ?(directions - d): ");
            String request = in.nextLine();

            if (request.equals("d")) {
                System.out.println("We are " + getNeutralPlayerLocation());
                System.out.println("Stay out of trouble");

            }

        }
    }



    }
