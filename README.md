# 2048 게임 제작

### 첫번째 

1. PennDraw.java 이용한 Table 제작

2. MakeTable.java의 기본 Table 제작을 위한 분석 및 좌표 그리기.

   - **`이용 할 method`**

   - ```java
     // PennDraw.java
     
     public static void setPenColor(int red, int green, int blue) 
     public static void filledSquare(double x, double y, double r)
     public static void line(double x0, double y0, double x1, double y1)
     ```

   - 결과

   - ![image-20210511200445605](C:\Users\tlstj\AppData\Roaming\Typora\typora-user-images\image-20210511200445605.png)



3. 랜덤하게 숫자 2개를 가져오기.

   - int 변수를 통해서 숫자 2개를 만들어 낼 것임.

   - 숫자는 오로지 2 or 4

   - 화면에 출력까지.

   - ```java
     public static void setFontSize(double pointSize)
     public static void text(double x, double y, String s)```
   
4. 명확한 색상을 구하기.
   - https://html-color-codes.info/colors-from-image/

5. 키가 들어왔는지 확인하기.

   - ```java
     public static char nextKeyTyped() 
     public static boolean hasNextKeyTyped()
     ```

6. 키 확인하고 방향 움직여서 좌표구하기!

   - W
     - 모든 값들이 전부 다 위로 올라가는 역할.
     - 다시 전체 2차원 배열을 찾아서
     - 숫자가 있는 위치의 인덱스를 기억하고 위로 올려줍니다.
     - 움직이는 것만 찾기



- Game.java 기능 구현

- MakeTableMain.java 실행 파일 (Main)

- Table.java Object

- 	/*
  	 * 1. key가 들어오면 움직이기.
  	 * 2. 움직이고 난 다음에는 새로운 숫자를 만들어야 함.
  	 * 3. 더이상 밀리지않아야 함.
  	 * 4. Table의 값이 움직였는지 여부를 판단해서 움직이는 코드짜기
  	 */
