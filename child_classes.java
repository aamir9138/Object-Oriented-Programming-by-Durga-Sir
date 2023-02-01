abstract class vehicle{
    public abstract int getNoOfWheels();
}

class bus extends vehicle{
    public int getNoOfWheels(){
        return 6;
    }
}

class Auto extends vehicle{
    public int getNoOfWheels(){
        return 3;
    }
}

public class child_classes {
    public static void main(String[] args){
        bus b = new bus();
        Auto a = new Auto();
        System.out.println(b.getNoOfWheels());
        System.out.println(a.getNoOfWheels());
    }
}