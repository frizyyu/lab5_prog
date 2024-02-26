package supportive;
public class Studio {
    private String name; //Поле может быть null
    private String address; //Поле не может быть null

    public Studio(String name, String adress){
        this.name = name;
        this.address = adress;
    }

    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setAddress(String address){
        this.address = address;
    }
}
