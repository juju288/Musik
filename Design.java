
package application;

import java.sql.SQLException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Design extends Application {
	private Label feedback;
	private Label song;
	private final int Y_LINE = 110;
	private final int X_PADDING = 4;
	private final int WIDTH = 55;
	enum BUTTONS {PLAY, PAUSE, STOP, FORWARD, BACK, REPLAY, SHUFFLE, SOUND, MUTE}
	private ImageView[] imageViews; 
	private boolean playOn = false; 
	

	private void generateImageViews()
	{
		Image playImg = new Image("application/player.png");
		imageViews = new ImageView[BUTTONS.values().length];
		int i = 0;
		for (BUTTONS b : BUTTONS.values())
		{
			ImageView imageView = new ImageView(playImg);
			imageView.setFitWidth(WIDTH);
			imageView.setFitHeight(WIDTH);
			imageView.setViewport(new Rectangle2D(X_PADDING + WIDTH*b.ordinal(), Y_LINE, WIDTH,WIDTH));
			imageViews[i++] = imageView;
		}
	}
	
	
	private ImageView getIV(BUTTONS b)
	{
		return imageViews[b.ordinal()];
	}
	
	@Override
	public void start(Stage primaryStage) throws SQLException {
		DB db = new DB();
		generateImageViews();
		
		BorderPane root = new BorderPane();
		HBox center = new HBox();
		
		Button back = new Button();	
		back.setGraphic(getIV(BUTTONS.BACK)); 
		back.setOnAction((ActionEvent e) -> {
		    feedback.setText("back");
		});
		center.getChildren().add(back);
		
		Button play = new Button();	
		play.setGraphic(getIV(BUTTONS.PLAY)); 
		play.setOnAction((ActionEvent e) -> {
			if (playOn){
				play.setGraphic(getIV(BUTTONS.PLAY));
				feedback.setText("pause");
			} else{
				play.setGraphic(getIV(BUTTONS.PAUSE));
				feedback.setText("play");
				try {
					db.anhören();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			 }
			playOn = !playOn;
		    
		});
		center.getChildren().add(play);

//		Button stop = new Button();	
//		stop.setGraphic(getIV(BUTTONS.STOP));
//		stop.setOnAction((ActionEvent e) -> {
//			play.setGraphic(getIV(BUTTONS.PLAY));
//			playOn = false;
//		    feedback.setText("stop");
//		});
//		center.getChildren().add(stop);
		
		Button forward = new Button();	
		forward.setGraphic(getIV(BUTTONS.FORWARD));
		forward.setOnAction((ActionEvent e) -> {
		    feedback.setText("forward");
		    try {
				song.setText(db.wiedergabe());
				play.setGraphic(getIV(BUTTONS.PLAY));
				feedback.setText("pause");
				playOn = !playOn;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		center.getChildren().add(forward);
		
		root.setBottom(center);
//		root.setCenter(center);

		feedback = new Label("Hier wird der Status angezeigt");
		root.setTop(feedback);
		
//		song.setText(db.wiedergabe());
		song = new Label(db.wiedergabe());
		root.setCenter(song);

		
		Scene scene = new Scene(root, 400, 400);

		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) throws SQLException {
		launch(args);

	}
}