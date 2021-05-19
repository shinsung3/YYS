package com.make.game;

import java.util.Arrays;

public class MakeTable {
	static final double r = 0.05;

	public static void main(String[] args) {
		PennDraw.clear(204, 192, 180);
		// r ���簢�� ���� ������ ����
		// x ���簢�� �߽��� x ��ǥ
		PennDraw.setPenColor(204, 192, 180);
		PennDraw.filledSquare(0.125, 0.875, r);
		PennDraw.filledSquare(0.375, 0.875, r);
		PennDraw.filledSquare(0.625, 0.875, r);
		PennDraw.filledSquare(0.875, 0.875, r);

		PennDraw.filledSquare(0.125, 0.625, r);
		PennDraw.filledSquare(0.375, 0.625, r);
		PennDraw.filledSquare(0.625, 0.625, r);
		PennDraw.filledSquare(0.875, 0.625, r);

		PennDraw.filledSquare(0.125, 0.375, r);
		PennDraw.filledSquare(0.375, 0.375, r);
		PennDraw.filledSquare(0.625, 0.375, r);
		PennDraw.filledSquare(0.875, 0.375, r);

		PennDraw.filledSquare(0.125, 0.125, r);
		PennDraw.filledSquare(0.375, 0.125, r);
		PennDraw.filledSquare(0.625, 0.125, r);
		PennDraw.filledSquare(0.875, 0.125, r);

		// Draw a line from (x0, y0) to (x1, y1).
		// ������
		PennDraw.setPenRadius(0.025);
		PennDraw.setPenColor(150, 146, 132);
		PennDraw.line(0, 0.25, 1, 0.25);
		PennDraw.line(0, 0.5, 1, 0.5);
		PennDraw.line(0, 0.75, 1, 0.75);

		// ������
		PennDraw.line(0.25, 0, 0.25, 1);
		PennDraw.line(0.5, 0, 0.5, 1);
		PennDraw.line(0.75, 0, 0.75, 1);

		PennDraw.setPenColor(PennDraw.WHITE);

		MakeGameBoard test = new MakeGameBoard();
		test.randomPick();
		test.randomPick();

		test.drawBoard();
		while (true) {
			if (PennDraw.hasNextKeyTyped()) {
				//nextKeyTyped asdw �� �ƴ� Ű�� ������ �����Ű��.
				char key = PennDraw.nextKeyTyped();
				test.moveBox(key);
				System.out.println(key);
			}
		}

//		System.out.println(test.toString());
	}

}
