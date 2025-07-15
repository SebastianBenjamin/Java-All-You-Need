import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class BouncingSquare extends Application{
    private double dx = 3;
    private double dy = 3;
    
  
    public void start(Stage primaryStage){
        Rectangle square = new Rectangle(30,30, Color.RED);
        square.relocate(100,100);
    
        Pane pane = new Pane();
        pane.getChildren().add(square);
        
        AnimationTimer timer = new AnimationTimer();
            @Override
            public void handle(long now){
                moveSquare(square,pane);
            }
    } 

}	