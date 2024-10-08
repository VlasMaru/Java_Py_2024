//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.Objects;
 class Main
{
    static Scanner in = new Scanner(System.in);

    public static int pow(int value, int powValue) {
        return (int) Math.pow(value, powValue);
    }
    //1. Сиракузская последовательность
    //2. Сумма ряда
    //3. Ищем клад
    //4. Логистический максимин
    //5. Дважды четное число

    public static void ex_1() {
        System.out.println("Введите интересующее стартовое число для сиракузской последовательности:" );
        int num = in.nextInt();
        int counter = 0;
        while (num != 1)
        {
            if (num % 2 == 0)  {num = num/2; counter++;}
            else  {num = 3*num + 1; counter++;}
        }
        System.out.println("Вам потребуется " + counter + " шагов, чтобы достичь единицы.");
    }

    public static void ex_2() {
        System.out.println("Введите длину последовательности:" );
        int counter = 0;
        int num = in.nextInt();
        int sum = 0;
        int start = 2;
        while (counter !=num)
        {
            int cur = in.nextInt();
            sum += cur * pow(-1,start);
            start++; counter++;
        }
        System.out.println("Знакочередующаяся сумма ряда равна " + sum);
    }

    public static void ex_3() {
        //
        System.out.println("Введите координаты клада по x: " );
        int tr_x = in.nextInt();
        System.out.println("Введите координаты клада по y: " );
        int tr_y = in.nextInt();
        //
        in.nextLine();

        int cur_x = 0;
        int cur_y = 0;
        int count = 0;
        boolean flag = true;
        boolean flag_s = true;

        while (true)
        {
            if((cur_x == tr_x) & (cur_y == tr_y)) {flag_s = false;}
            if (flag_s)
            {
                String str = in.nextLine();
                int temp = in.nextInt();
                in.nextLine();
                switch (str) {
                    case "север":
                        cur_y += temp;
                        break;
                    case "юг":
                        cur_y -= temp;
                        break;
                    case "запад":
                        cur_x -= temp;
                        break;
                    case "восток":
                        cur_x += temp;
                        break;
                }
                count++;
            }
            else
            {
                String str = in.nextLine();
                if (Objects.equals(str, "стоп")) {break;}
            }
        }
        System.out.println("Потребовалось: " + count  + " шагов по указанному маршруту.");
    }


    public static void ex_4() {
        System.out.print("Введите количество дорог: ");
        int path_num = in.nextInt();
        int final_path = -1;
        int max_h = 0;
        for (int i = 0; i < path_num; i++) {
            int tun_c = in.nextInt();
            int min_req_h = Integer.MAX_VALUE;
            for (int j = 0; j < tun_c; j++) {
                int currentHeight = in.nextInt();
                min_req_h = Integer.min(currentHeight, min_req_h);
            }
            if (min_req_h > max_h) {
                max_h = min_req_h;
                final_path = i + 1;
            }
        }
        System.out.println("Наибольшая высота: " + max_h);
        System.out.println("Выбранная дорога: " + final_path);
    }

    public static void ex_5() {
        System.out.println("Введите число: ");
        int number = in.nextInt();
        if (number < 1000 & number > 99) {
            int a = number / 100;
            int b = (number / 10) % 10;
            int c = number % 10;
             if ((a * b * c % 2 == (a + b + c) % 2) & (a * b * c % 2 == 0))
            {
                System.out.println("Число дважды чётное.");
            }
             else {System.out.println("Число не дважды чётное.");}

        }
        else{ System.out.println("Число не удвлетворяет условиям.");}
    }

    public static void main(String[] args)
    {
        //ex_1();
        //ex_2();
        //ex_3();
        //ex_4();
        //ex_5();
    }
}