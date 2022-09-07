package com.company;

public class Main {

    public static void main(String[] args) {
        double[][] SERIES = new double[5][5];
        double[][] Eps = new double[5][5];
        double S_e;
        double Eps_S_e;
        double x0 = 1;
        double y0 = 2;
        double r0 = 5;

        double[][] SERIES_INTEGRAL = new double[3][4];
        double[][] Eps_INTEGRAL = new double[3][4];
        double S_e_int;
        double Eps_S_e_int;
        double a = 0;
        double b = 2;


        for(int i = 0; i < 5; i++)
        {
            System.out.println("\nSERIA " + (i+1));
            int count = 0;
            for (int j = 4; j < 9; j++)
            {
                double expNmb = Math.pow(10, j);
                SERIES[i][count] = calc_pi(x0, y0, r0, expNmb);
                System.out.println(SERIES[i][count]);
                count++;
            }
        }

        for(int i = 0; i < 5; i++)
        {
            System.out.println("\nEps " + (i+1));
            for (int j = 0; j < 5; j++)
            {
                Eps[i][j] = Math.abs((SERIES[i][j] - Math.PI) / Math.PI);
                System.out.println(Eps[i][j]);
            }
        }

        for(int i = 0; i < 5; i++)
        {
            System.out.print("\nS_e" + (i+4) + " = ");
            double q = 0;
            for (int j = 0; j < 5; j++)
            {
                q += SERIES[j][i];
                if (j == 4){
                    S_e = q / 5;
                    Eps_S_e = Math.abs((S_e - Math.PI)/Math.PI);
                    System.out.println(S_e);
                    System.out.println("Eps_S_e" + (i+4) + " = " + Eps_S_e);
                }
            }
        }


        for(int i = 0; i < 3; i++)
        {
            System.out.println("\nSERIA_INTEGRAL " + (i+1));
            int count = 0;
            for (int j = 4; j < 8; j++)
            {
                double expNmb = Math.pow(10, j);
                SERIES_INTEGRAL[i][count] = calc_integral(a, b, expNmb);
                System.out.println(SERIES_INTEGRAL[i][count]);
                count++;
            }
        }

        for(int i = 0; i < 3; i++)
        {
            System.out.println("\nEps_INTEGRAL " + (i+1));
            for (int j = 0; j < 4; j++)
            {
                Eps_INTEGRAL[i][j] = Math.abs((SERIES_INTEGRAL[i][j] - Math.PI) / Math.PI);
                System.out.println(Eps_INTEGRAL[i][j]);
            }
        }

        for(int i = 0; i < 4; i++)
        {
            System.out.print("\nINTEGRAL S_e" + (i+4) + " = ");
            double q = 0;
            for (int j = 0; j < 3; j++)
            {
                q += SERIES_INTEGRAL[j][i];
                if (j == 2){
                    S_e_int = q / 5;
                    Eps_S_e_int = Math.abs((S_e_int - Math.PI)/Math.PI);
                    System.out.println(S_e_int);
                    System.out.println("INTEGRAL Eps_S_e" + (i+4) + " = " + Eps_S_e_int);
                }
            }
        }
    }

    public static double calc_pi(double x0, double y0, double r0, double expNmb){
        int m = 0;
        double xmin = x0 - r0;
        double xmax = x0 + r0;
        double ymin = y0 - r0;
        double ymax = y0 + r0;
        for (double i = 0; i < expNmb; i++){
            double p = Math.random();
            double xp = ((xmax - xmin) * p) + xmin;
            p = Math.random();
            double yp = ((ymax - ymin) * p) + ymin;

            if (Math.pow((xp - x0), 2) + Math.pow((yp - y0), 2) < Math.pow(r0, 2)){
                m+=1;
            }
        }
        return 4*m/expNmb;
    }

    public static double calc_integral(double a, double b, double expNmb){
        int m = 0;
        double xmin = a;
        double xmax = b;
        double ymin = 0;
        double ymax = function(b);

        for (double i = 0; i < expNmb; i++){
            double p = Math.random();
            double xp = ((xmax - xmin) * p) + xmin;
            p = Math.random();
            double yp = ((ymax - ymin) * p) + ymin;

            if (function(xp) > yp){
                m+=1;
            }
        }
        return (m/expNmb)*(b-a)*function(b);
    }

    public static double function(double x){
        return (Math.pow(x,3) + 1);
    }
}
