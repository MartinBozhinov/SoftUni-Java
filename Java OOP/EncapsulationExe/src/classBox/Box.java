package classBox;

public class Box {
    private double length;
    private double width;
    private double height;


    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }




    private void setLength(double length) {
          validateData(length,"Length");
         this.length = length;
    }
    private void setWidth(double width) {
        validateData(width,"Width");
        this.width = width;
    }
    private void setHeight(double height) {
        validateData(height,"Height");
        this.height = height;
    }

    private void validateData(double size , String type){
        if (size <= 0 ){
            throw new IllegalArgumentException(type + " cannot be zero or negative.");
        }
    }

    public double calculateSurfaceArea(){

        return 2 * this.length * this.width + 2  * this.length * this.height + 2 * this.width * this.height;
    }

    public double calculateLateralSurfaceArea(){
        return  2* this.length * this.height + 2 * this.width * this.height;
    }

    public double calculateVolume(){
        return this.height * this.width * this.length;
    }

    @Override
    public String toString() {
        return String.format("Surface Area - %.2f\n Lateral Surface Area - %.2f\n Volume - %.2f\n ", calculateSurfaceArea(),calculateLateralSurfaceArea(),calculateVolume());
    }
}
