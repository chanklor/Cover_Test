/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cover1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
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
    
    private GraphicsContext gc;
    private Image image;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gc = canvas.getGraphicsContext2D();
        imageView.setPreserveRatio(true);
        image = new Image("file:C:\\Users\\47385\\Documents\\Personal\\OMR\\marce.jpg");
        imageView.setImage(image);
    }    
    
    @FXML
    private void handleMouseDrag(MouseEvent event){
        gc.setFill(new Color(0,0,1,0.5));
        gc.fillRect(event.getX()-2, event.getY()-2, 5, 5);
    }
    
    @FXML
    private void clickImage(MouseEvent event){
        System.out.println("You clicked the pic!");
    }
    
}
