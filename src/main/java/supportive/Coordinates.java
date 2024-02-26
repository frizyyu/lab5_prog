package supportive;
public class Coordinates {
    private Long x; //Максимальное значение поля: 268, Поле не может быть null
    private double y; //Максимальное значение поля: 55

    public Coordinates(Long x, double y){
        this.x = x;
        this.y = y;
    }

    public Long getX(){
        return x;
    }
    public double getY(){
        return y;
    }

    public void setX(Long x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }


}
