import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.io.*;
import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;

// Any JavaFX application must extend the Application class, which is abstract.
public class SubrulesPlot extends Application {

	public static void main(String[] args) {
		
		// Launch the JavaFX application. This method creates a 
		// LineChartExample object and calls its start method.
		launch(args);
	}
	
	// The start method is the entry point for any JavaFX application. It is 
	// the only abstract method of the Application class and must be 
	// overridden.
	//
	// The launch method passes the start method a reference to the primary 
	// Stage of the application. This Stage is the window that displays the 
	// application content.
	public void start(Stage stage) throws IOException {

		// Each data series shown in a LineChart is stored in an XYChart.Series 
		// object. The LineChart created by this code shows two data series, so 
		// two XYChart.Series objects are needed.
		// 
		// The type parameters in the declaration of an XYChart.Series specify 
		// the data types of the x-values and y-values. The possible types are 
		// String and Number. This LineChart shows a couple of trigonometric 
		// functions, so the x-values and y-values are both Numbers.
		//
		// Each XYChart.Series object has a name field. This field is used to 
		// label the data in the chart legend.
		XYChart.Series<Number, Number> zeroSeries = new XYChart.Series<>();
		zeroSeries.setName("subrule 0");
		XYChart.Series<Number, Number> oneSeries = new XYChart.Series<>();
		oneSeries.setName("subrule 1");
		XYChart.Series<Number, Number> threeSeries = new XYChart.Series<>();
		threeSeries.setName("subrule 3");
		XYChart.Series<Number, Number> fourSeries = new XYChart.Series<>();
		fourSeries.setName("subrule 4");
		XYChart.Series<Number, Number> fiveSeries = new XYChart.Series<>();
		fiveSeries.setName("subrule 5");
		XYChart.Series<Number, Number> sixSeries = new XYChart.Series<>();
		sixSeries.setName("subrule 6");
		XYChart.Series<Number, Number> sevenSeries = new XYChart.Series<>();
		sevenSeries.setName("subrule 7");
		XYChart.Series<Number, Number> twoSeries = new XYChart.Series<>();
		twoSeries.setName("subrule 2");
		// Each XYChart.Series object stores a list of data points. The getData 
		// method returns a reference to this list.
		// 
		// Data is added to an XYChart.Series by adding it to its data list. 
		// The following lines simply store references to the data lists of 
		// sinSeries and cosSeries for use in the for-loop below.
		List<XYChart.Data<Number, Number>> zeroData = zeroSeries.getData();
		List<XYChart.Data<Number, Number>> oneData = oneSeries.getData();
		List<XYChart.Data<Number, Number>> twoData = twoSeries.getData();
		List<XYChart.Data<Number, Number>> threeData = threeSeries.getData();
		List<XYChart.Data<Number, Number>> fourData = fourSeries.getData();
		List<XYChart.Data<Number, Number>> fiveData = fiveSeries.getData();
		List<XYChart.Data<Number, Number>> sixData = sixSeries.getData();
		List<XYChart.Data<Number, Number>> sevenData = sevenSeries.getData();
		// Calculate some data to display in the LineChart. To create your 
		// automaton plots, replace this loop with code that reads your Hamming 
		// distance or subrule counts data files.
		//File file1 = new File("subrules-elementary149-circularbc.csv");
		File file1 = new File("subrule.txt");
		BufferedReader br = new BufferedReader(new FileReader(file1));
		for (int idx = 0; idx <= 100; ++idx) {
			double x = idx;
			String line = "";
			line = br.readLine();
			String[] subrules = line.split(",");
			double zeroX = Integer.parseInt(subrules[0].replaceAll("﻿", ""));
			double oneX = Integer.parseInt(subrules[1].replaceAll("﻿", ""));
			double twoX = Integer.parseInt(subrules[2].replaceAll("﻿", ""));
			double threeX = Integer.parseInt(subrules[3].replaceAll("﻿", ""));
			double fourX = Integer.parseInt(subrules[4].replaceAll("﻿", ""));
			double fiveX = Integer.parseInt(subrules[5].replaceAll("﻿", ""));
			double sixX = Integer.parseInt(subrules[6].replaceAll("﻿", ""));
			double sevenX = Integer.parseInt(subrules[7].replaceAll("﻿", ""));
			// Each data point in an XYChart.Series must be wrapped in an 
			// XYChart.Data object. The following lines add a point to 
			// sinSeries and cosSeries by adding a point to their data lists.
			XYChart.Data<Number, Number> zeroPt = new XYChart.Data<>(x, zeroX);
			XYChart.Data<Number, Number> onePt = new XYChart.Data<>(x, oneX);
			XYChart.Data<Number, Number> twoPt = new XYChart.Data<>(x, twoX);
			XYChart.Data<Number, Number> threePt = new XYChart.Data<>(x, threeX);
			XYChart.Data<Number, Number> fourPt = new XYChart.Data<>(x, fourX);
			XYChart.Data<Number, Number> fivePt = new XYChart.Data<>(x, fiveX);
			XYChart.Data<Number, Number> sixPt = new XYChart.Data<>(x, sixX);
			XYChart.Data<Number, Number> sevenPt = new XYChart.Data<>(x, sevenX);
			zeroData.add(zeroPt);
			oneData.add(onePt);
			twoData.add(twoPt);
			threeData.add(threePt);
			fourData.add(fourPt);
			fiveData.add(fivePt);
			sixData.add(sixPt);
			sevenData.add(sevenPt);
		}
		br.close();
		// Create the x-axis and y-axis for the LineChart. The NumberAxis class 
		// is used because the data points are pairs of Numbers. If either the 
		// x-values or y-values were Strings, the CategoryAxis class would need 
		// to be used instead.
		//
		// NumberAxis has an overloaded constructor. The version used here has 
		// four parameters: the label, lower bound, upper bound, and tick unit.
		NumberAxis xAxis = new NumberAxis("step number", 0, 100, 10);
		NumberAxis yAxis = new NumberAxis("subrule count", 0, 100, 10);

		// Create the LineChart. The constructor takes references to both axes.
		//
		// Each LineChart object has a title field. If this field is set, the 
		// value will be shown at the top of the chart.
		//
		// By default, each data point is shown in the chart with a symbol, and 
		// the symbols are connected by lines. Setting the createSymbols field 
		// to false removes the symbols and only shows the lines.
		LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);
		chart.setTitle("Subrule Numbers For Custom Automaton");
		chart.setCreateSymbols(false);

		// The data series shown in a LineChart are stored in a list. The 
		// getData method returns a reference to this list. (Note the 
		// similarity to the getData method of XYChart.Series.) The following 
		// lines add sinSeries and cosSeries to the LineChart.
		List<XYChart.Series<Number, Number>> seriesList = chart.getData();
		seriesList.add(zeroSeries);
		seriesList.add(oneSeries);
		seriesList.add(twoSeries);
		seriesList.add(threeSeries);
		seriesList.add(fourSeries);
		seriesList.add(fiveSeries);
		seriesList.add(sixSeries);
		seriesList.add(sevenSeries);
		// The graphical components of a JavaFX application are stored in 
		// Scenes. In order to display the LineChart, it must be added to a 
		// Scene. The constructor used below takes a reference to the LineChart 
		// and integers specifying the width and height of the Scene in pixels.
		Scene scene = new Scene(chart, 960, 600);
		
		// Add the Scene to the application Stage (i.e., window), and call the 
		// show method to display it. (Only one Scene can be displayed in a 
		// Stage at a time.) The setTitle method is used to define the text 
		// that appears in the title bar of the window.
		stage.setScene(scene);
		stage.setTitle("Subrule Numbers For Custom Automaton");
		stage.show();
		
		// Save a copy of the Scene as a PNG image.
		String filename = "subrules.png";
		saveScene(scene, filename);
	}
	
	// Create a PNG of the given Scene.
	public static void saveScene(Scene scene, String filename) throws 
			IOException {
		
		// Convert the given Scene to an image that can be written to a file.
		WritableImage image = scene.snapshot(null);
		BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
		
		// Create a file with the given name and save the image as a PNG.
		File output = new File(filename);
		ImageIO.write(bufferedImage, "png", output);
	}
}
