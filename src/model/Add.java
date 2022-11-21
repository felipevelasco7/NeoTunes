package model;

public class Add implements Playable {
    private String nike="Nike - Just Do It.";
    private String cocaCola="Coca-Cola - Open Happiness.";
    private String mms ="M&Ms - Melts in Your Mouth, Not in Your Hands";

    @Override
    public String play() {
        int number=(int)(Math.random()*3+1);
        if(number==1){
            System.out.println(nike);
        }
        else if(number==2){
            System.out.println(cocaCola);
        }
        else{
            System.out.println(mms);
        }
        return null;
    }

    
}
