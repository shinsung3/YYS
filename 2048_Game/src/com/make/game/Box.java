package com.make.game;
/*
 * 그림그리는 역할
 */
public class Box {

	// Board배열에서의 Box의 위치
	private double boardX, boardY;
	// Box에서 x,y
	private int x, y;
	// Box의 값
	private int boxValue;

	/*
	 * { {0,0},{0,1},{0,2},{0,3}
	 *   {1,0},{1,1},{1,2},{1,3}
	 *   {2,0},{2,1},{2,2},{2,3}
	 *   {3,0},{3,1},{3,2},{3,3}
	 */

	public Box(int x, int y, int boxValue) {
		this.x = x;
		this.y = y;
		// (y,x)
		this.boardX = 0.125 + x * 0.25;
		this.boardY = 0.875 - y * 0.25;
		// box 값
		this.boxValue = boxValue;
	}

	public int getBoxValue() {
		return boxValue;
	}

	public void draw() {
		int value = boxValue;

		if (value == 2) {
			PennDraw.setPenColor(207, 195, 186);
		} else if (value == 4) {
			PennDraw.setPenColor(237, 224, 200);
		} else if (value == 8) {
			PennDraw.setPenColor(242, 177, 121);
		} else if (value == 16) {
			PennDraw.setPenColor(245, 149, 99);
		} else if (value == 32) {
			PennDraw.setPenColor(246, 124, 95);
		} else if (value == 64) {
			PennDraw.setPenColor(234, 89, 55);
		} else if (value == 128) {
			PennDraw.setPenColor(237, 207, 112);
		} else if (value == 256) {
			PennDraw.setPenColor(237, 204, 99);
		} else if (value == 512) {
			PennDraw.setPenColor(236, 200, 80);
		} else if (value == 1024) {
			PennDraw.setPenColor(226, 181, 17);
		} else if (value == 2048) {
			PennDraw.setPenColor(234, 198, 0);
		}

		boardX = 0.125 + x * 0.25;
		boardY = 0.875 - y * 0.25;

		PennDraw.filledSquare(boardX, boardY, 0.11);
		PennDraw.setPenColor(PennDraw.WHITE);
		PennDraw.setFontSize(70);
		
		if (value > 99) {
			PennDraw.setFontSize(60);
		} 
		if (value > 999) {
			PennDraw.setFontSize(50);
		}
		
		PennDraw.text(boardX, boardY, "" + value);
	}

}
