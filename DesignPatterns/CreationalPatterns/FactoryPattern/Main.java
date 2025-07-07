public class Main {
    public static void main(String[] args) throws Exception{
        try{
            ShapeFactory factory = new ShapeFactory();
            Shape shapeObj = factory.getShape("rectangle");
            shapeObj.draw();
        }
        catch (Exception e){
            System.out.println("null shape");
        }
    }
}
