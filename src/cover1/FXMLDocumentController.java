/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cover1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 *
 * @author 47385
 */
public class FXMLDocumentController implements Initializable {
    
    
    @FXML
    private Canvas canvas;
    
    @FXML
    private ImageView imageView;
    
    @FXML
    private TextField textField;
    
    private GraphicsContext gc;
    private Image image;
    
    private Coordinate startingPoint = new Coordinate();
    private Coordinate currentPoint = new Coordinate();
    
    private final int numberColumn = 4;
    private final int numberRow = 3;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gc = canvas.getGraphicsContext2D();
        gc.setFill(new Color(1,0,0,0.5));
        imageView.setPreserveRatio(true);
        //image = new Image("file:C:\\Users\\47385\\Documents\\Personal\\OMR\\marce.jpg");
        image = new Image("http://www.phlmetropolis.com/Bullet%20ballot%20X.jpg");
        imageView.setImage(image);
        canvas.setHeight(imageView.getBoundsInParent().getHeight());
        canvas.setWidth(imageView.getBoundsInParent().getWidth());
    }    
    
    @FXML
    private void handleCanvasOnMouseDrag(MouseEvent event){
        //gc.fillRect(event.getX()-2, event.getY()-2, 5, 5);
        
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        
        currentPoint.setX((int) event.getX());
        currentPoint.setY((int) event.getY());
        
        double deltaX = (double) (currentPoint.getX() - startingPoint.getX());
        double deltaY = (double) (currentPoint.getY() - startingPoint.getY());
        
        double stepX = deltaX / (double) (numberColumn - 1);
        double stepY = deltaY / (double) (numberRow - 1);
        
        System.out.println("Steps: " + stepX + ", " + stepY);
        
        Coordinate[][] coordinateArray = new Coordinate[numberColumn][numberRow];
        
        for (int i = 0; i < coordinateArray.length; i++) {
            for (int j = 0; j < coordinateArray[0].length; j++) {
                Coordinate c = new Coordinate();
                
                double cX = ((double) startingPoint.getX()) + (stepX * (double) i) + 0.5;
                c.setX((int) cX);
                double cY = ((double) startingPoint.getY()) + (stepY * (double) i) + 0.5;
                c.setY((int) cY);
                
                coordinateArray[i][j] = c;
            }
        }
        
        for (int i = 0; i < coordinateArray.length; i++) {
            Coordinate[] coordinateArray1 = coordinateArray[i];
            for (int j = 0; j < coordinateArray1.length; j++) {
                Coordinate coordinateArray11 = coordinateArray1[j];
                gc.fillOval(coordinateArray11.getX()-4, coordinateArray11.getY()-4, 10, 10);
            }
        }
        
    }
    
    @FXML
    private void handleCanvasOnMouseEnter(Event event) {
        canvas.getScene().setCursor(Cursor.CROSSHAIR);
    }
    
    @FXML
    private void handleCanvasOnMouseExit(Event event) {
        canvas.getScene().setCursor(Cursor.DEFAULT);
    }
    
    @FXML
    private void handleCanvasOnMouseMoved(MouseEvent event) {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.fillOval(event.getX()-4, event.getY()-4, 10, 10);
    }
    
    @FXML
    private void handleCanvasOnMousePressed(MouseEvent event) {
        System.out.println("pressed");
        startingPoint.setX((int) event.getX());
        startingPoint.setY((int) event.getY());
        System.out.println("Starting Point: " + startingPoint.getX() + ", " + startingPoint.getY());
    }
    
    @FXML
    private void handleCanvasOnMouseReleased(MouseEvent event) {
        System.out.println("released");
        System.out.println("Ending Point: " + (int) event.getX() + ", " + (int) event.getY());
    }
    
}





class Coordinate{
    private int X;
    private int Y;

    public Coordinate() {
    }

    public Coordinate(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    public int getX() {
        return X;
    }

    public void setX(int X) {
        this.X = X;
    }

    public int getY() {
        return Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }
    
    
    
}
