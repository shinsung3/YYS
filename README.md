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
     public static void text(double x, double y, String s)
     ```

     