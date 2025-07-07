import java.util.Objects;

public class ShapeFactory {
    public Shape getShape(String input){
        if(Objects.equals(input, "circle")){
            return new Circle();
        }
        else if(Objects.equals(input, "rectangle")){
            return new Rectangle();
        }
        return null;
    }
}
