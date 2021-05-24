package com.make.game;

import java.util.Arrays;

public class Game {
	Table[][] box;
	private int boxNumber;
	private boolean lose;
	private boolean win;

	/*
	 * Constructor
	 */
	public Game() {
		box = new Table[4][4];
		// 현재 박스 갯수
		this.boxNumber = 0;
		this.lose = false;
		this.win = false;
	}

	public void drawBoard() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (box[i][j] != null) {
					box[i][j].draw();
				}
			}
		}
	}

	// 빈자리 세기
	private int emptyCounter() {
		int empty = 0;

		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {
				if (box[row][col] == null) {
					empty += 1;
				}
			}
		}
		return empty;
	}

	/*
	 * 첫번째 숫자 2개 만들기
	 */
	public void randomInit() {
		int[] val = { 2, 4 };
		int cnt = 0;
		while (cnt != 2) {
			int x = (int) (Math.random() * 4);
			int y = (int) (Math.random() * 4);
			if (box[y][x] == null) {
				box[y][x] = new Table(x, y, val[(int) (Math.random() * 2)]);
				cnt++;
			}
		}
	}

	/*
	 * 움직일때마다 숫자 1개 생성
	 */
	public void randomNumber() {
		int[] val = { 2, 4 };
		int x = (int) (Math.random() * 4);
		int y = (int) (Math.random() * 4);
		if (box[y][x] == null) {
			box[y][x] = new Table(x, y, val[(int) (Math.random() * 2)]);
		}
	}

	// value가 2048이 되면 이긴거
	public void isWin() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (box[i][j].getBoxValue() == 2048) {
					win = true;
				}
			}
		}
	}

	public void setLose(boolean lose) {
		this.lose = lose;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	@Override
	public String toString() {
		String out = "";
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {
				if (box[row][col] != null) {
					out += "___" + box[row][col].getBoxValue() + " ";
				} else {
					out += "null ";
				}
			}
			out += '\n';
		}
		return out;

	}

	/*
	 * while(true) { if(PennDraw.hasNextKeyTyped()){
	 * 
	 * char key = PennDraw.nextKeyTyped(); if( key == 'a') {
	 * 
	 * }else if(key == 'w') { }else if(key == 's') { }else if( key =='d') { }else {
	 * 
	 * break; }
	 */
	/*
	 * { {j,i} {0,0}, {0,1}, {0,2}, {0,3} {1,0},2{1,1}, {1,2}, {1,3} {2,0}, {2,1},
	 * {2,2}, 4{2,3} {3,0}, {3,1}, {3,2}, {3,3} }
	 */
	
	/*
	 * 1. key가 들어오면 움직이기.
	 * 2. 움직이고 난 다음에는 새로운 숫자를 만들어야 함.
	 * 3. 더이상 밀리지않아야 함.
	 * 4. Table의 값이 움직였는지 여부를 판단해서 움직이는 코드짜기
	 */
	// (1,3)
	public void moveBox(char key) {
		int index = -1;
		if (key == 'w') {
			for (int i = 0; i < 4; i++) { // 열
				for (int j = 1; j < 4; j++) {
					index = -1;
					if (box[j][i] != null) { // box[1][3] != null
						for (int k = j - 1; k >= 0; k--) { // k = 1-1 0 
							if (box[k][i] != null) {//box[0][3] !=null
								break;
							}
							// 저장
							index = k;
						}
						if (index != -1) {
							box[index][i] = box[j][i];
							// 좌표에 그림 표시
							box[index][i].setX(i);
							box[index][i].setY(index);
							box[j][i] = null;
						}
					}
				}
			}
			System.out.println();

		} else if (key == 's') {
			for (int i = 0; i < 4; i++) {
				// 마지막 열(y=3)은 비었는지
				for (int j = 0; j < 3; j++) {
					// 옮길 박스 발견 하면
					if (box[j][i] != null) {
						index = -1;
						for (int k = j + 1; k < 4; k++) {
							// 여기서 확인
							if (box[k][i] != null) {
								break;
							}
							index = k;
						}
						// i+1 가 빈자리면 (null이면)옮긴다.
						if (index != -1) {
							box[index][i] = box[j][i];
							box[index][i].setX(i);
							box[index][i].setY(index);
							box[j][i] = null;
						}
					}
				}
			}
		} else if (key == 'a') {
			// x=0 행 확인은
			for (int i = 1; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (box[j][i] != null) {
						index = -1;
						// 여기서
						for (int k = i - 1; k >= 0; k--) {
							if (box[j][k] != null) {
								break;
							}
							index = k;
						}
						if (index != -1) {
							box[j][index] = box[j][i];
							box[j][index].setX(index);
							box[j][index].setY(j);
							box[j][i] = null;
						}
					}
				}
			}
		} else if (key == 'd') {
			// 마지막 행은 (x=3)은
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 4; j++) {
					if (box[j][i] != null) {
						index = -1;
						for (int k = j + 1; k < 4; k++) {
							// 여기서 확인
							if (box[j][k] != null) {
								break;
							}
							index = k;
						}
						if (index != -1) {
							box[j][index] = box[j][i];
							box[j][index].setX(j);
							box[j][index].setY(index);
							box[j][i] = null;
						}
					}
				}
			}
		}

	}

	public void sum(char c) {
		if (c == 'w') {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 3; j++) {
					if (box[j][i] != null) {
						for (int k = j + 1; k < 4; k++) {
							if (box[k][i] != null) {
								if (box[j][i] == box[k][i]) {
									int s = box[j][i].getBoxValue();
									s *= 2;
									box[k][i] = null;
								}
								break;
							}
						}
					}
				}
			}

		} else if (c == 's') {
			for (int i = 0; i < 4; i++) {
				for (int j = 3; j > 0; j--) {
					if (box[j][i] != null) {
						for (int k = j - 1; k >= 0; k++) {
							if (box[k][i] != null) {
								if (box[j][i] == box[k][i]) {
									int s = box[j][i].getBoxValue();
									s *= 2;
									box[k][i] = null;
								}
								break;
							}
						}
					}
				}
			}
		} else if (c == 'a') {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 4; j++) {
					if (box[j][i] != null) {
						for (int k = i + 1; k < 4; k++) {
							if (box[j][k] != null) {
								if (box[j][i] == box[j][k]) {
									int s = box[j][i].getBoxValue();
									s *= 2;
									box[j][k] = null;
								}
								break;
							}
						}
					}
				}
			}
		} else if (c == 'd') {
			for (int i = 3; i > 0; i--) {
				for (int j = 4; j > 0; j++) {
					if (box[j][i] != null) {
						for (int k = i - 1; k >= 0; k--) {
							if (box[j][k] != null) {
								if (box[j][i] == box[j][k]) {
									int s = box[j][i].getBoxValue();
									s *= 2;
									box[j][k] = null;
								}
								break;
							}
						}
					}
				}
			}
		}
		moveBox(c);
	}
}
