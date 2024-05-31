package com.stewartlavenia.tally2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stewartlavenia.scan.ComponentScanMarker;

@SpringBootApplication(scanBasePackageClasses= {ComponentScanMarker.class})
public class CalCalc2Application {

	public static void main(String[] args) {
		SpringApplication.run(CalCalc2Application.class, args);
		 //System.out.println();
	}

}
