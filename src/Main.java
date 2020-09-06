import java.util.ArrayList;

import javax.sound.sampled.Line;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import javafx.scene.control.ColorPicker;
import javafx.stage.Stage;

public class Main extends Application {
    static double mouseX, mouseY;
    static boolean flag = false;
    static Color value;
    static Canvas canvas;
    static ArrayList<Circle> al = new ArrayList<Circle>();
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        
        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setOnAction(x -> {
            value = colorPicker.getValue();
        });
        canvas = new Canvas(1024, 720);
        
        Pane root = new Pane();
        root.getChildren().add(colorPicker);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root, 1024, 720));
        primaryStage.show();
        canvas.relocate(0, 50);
     //   root.setOnMousePressed(x -> flag = true);
        canvas.setOnMouseDragged(x ->{
            if(!flag){
                mouseX = x.getX();
                mouseY = x.getY();
                flag = true;
            }

            //root.getChildren().add(new Circle(x.getX(), x.getY(), 10, value));   
            print(x.getX(), x.getY());
            mouseX = x.getX();
            mouseY = x.getY();
            
        });
        canvas.setOnMouseReleased(x -> flag = false);

    }
    static void print(double x, double y){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(value);
        gc.strokeLine(mouseX, mouseY, x, y);

    }
    public static void main(String[] args) {
    launch(args);
    
    }
    
}
