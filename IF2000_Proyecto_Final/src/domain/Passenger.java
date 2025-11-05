package domain;

public class Passenger {
    private String name;
    private String id;

public Passenger(String name, String id){
    
    if (name == null || name.trim().isEmpty()){
        throw new IllegalArgumentException("Name is required");
    }
    if (id == null || id.trim().isEmpty()){
        throw new IllegalArgumentException("ID is required");
}
    this.name = name.trim();
    this.id = id.trim();
}

public String getName(){
    return name;
}

public String getId(){
    return id;
}
@Override
public String toString(){
    return name + "(" + id + ")";
}
}

                 

