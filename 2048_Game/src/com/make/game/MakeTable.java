package com.make.game;

public class MakeTable {
	static final double WIDTH = 0.120;
	public static void main(String[] args) {
		PennDraw.setPenColor(226, 140, 59);
		PennDraw.filledSquare(0.125, 0.875, WIDTH);
		PennDraw.filledSquare(0.375, 0.875, WIDTH);
		PennDraw.filledSquare(0.625, 0.875, WIDTH);
		PennDraw.filledSquare(0.875, 0.875, WIDTH);
		
		// Drawing 2nd Row Squares
		PennDraw.filledSquare(0.125, 0.625, WIDTH);
		PennDraw.filledSquare(0.375, 0.625, WIDTH);
		PennDraw.filledSquare(0.625, 0.625, WIDTH);
		PennDraw.filledSquare(0.875, 0.625, WIDTH);

		// Drawing 3rd Row Squares
		PennDraw.filledSquare(0.125, 0.375, WIDTH);
		PennDraw.filledSquare(0.375, 0.375, WIDTH);
		PennDraw.filledSquare(0.625, 0.375, WIDTH);
		PennDraw.filledSquare(0.875, 0.375, WIDTH);

		// Drawing 4th Row Squares
		PennDraw.filledSquare(0.125, 0.125, WIDTH);
		PennDraw.filledSquare(0.375, 0.125, WIDTH);
		PennDraw.filledSquare(0.625, 0.125, WIDTH);
		PennDraw.filledSquare(0.875, 0.125, WIDTH);


		PennDraw.setPenColor(150, 75, 0);
		PennDraw.line(0, 0.75, 1, 0.75);
		PennDraw.line(0, 0.5, 1, 0.5);
		PennDraw.line(0, 0.25, 1, 0.25);
		
		PennDraw.setPenColor(150, 75, 0);
		PennDraw.line(0.25, 1, 0.25, 0);
		PennDraw.line(0.5, 1, 0.5, 0);
		PennDraw.line(0.75, 1, 0.75, 0);
	}
}
