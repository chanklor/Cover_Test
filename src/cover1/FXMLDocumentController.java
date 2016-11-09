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
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gc = canvas.getGraphicsContext2D();
        imageView.setPreserveRatio(true);
        image = new Image("file:C:\\Users\\47385\\Documents\\Personal\\OMR\\marce.jpg");
        imageView.setImage(image);
        canvas.setHeight(imageView.getBoundsInParent().getHeight());
        canvas.setWidth(imageView.getBoundsInParent().getWidth());
    }    
    
    @FXML
    private void handleCanvasOnMouseDrag(MouseEvent event){
        gc.setFill(new Color(0,0,1,0.5));
        gc.fillRect(event.getX()-2, event.getY()-2, 5, 5);
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
        gc.setFill(new Color(1,0,0,0.5));
        gc.fillOval(event.getX()-4, event.getY()-4, 10, 10);
    }
    
    @FXML
    private void handleCanvasOnMousePressed(MouseEvent event) {
        System.out.println("pressed");
    }
    
    @FXML
    private void handleCanvasOnMouseReleased(MouseEvent event) {
        System.out.println("released");
    }
    
}
