import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lotos on 03.12.16.
 */
public class Board {
    final static private int size = 15;
    private int fields[][];
    private List<Combination> allCombinations;
    final private Game mainGame;
    
    public Board(Game myGame)
    {
        mainGame = myGame;
        fields = new int[size][size];
    }
    
    public List<Combination> getAllCombinations()
    {
        return allCombinations;
    }
    
    public void setValue(int posI, int posJ, int symbol)
    {
        System.out.println("posI, posJ = "+posI+"; "+posJ);
        fields[posI][posJ] = symbol;
    }
    
    public int getSize()
    {
        return size;
    }
    
    public int getFields(int posI, int posJ)
    {
        return fields[posI][posJ];
    }
    
    public void setFields(int posI, int posJ, int value)
    {
        fields[posI][posJ] = value;
    }
    
    public void set(int i, int j)
    {
        fields[i][j] = 1;
    }
    
    public void setComb(List<Combination> allComb)
    {
        allCombinations = allComb;
    }
    
    public void init()
    {
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                fields[i][j] = 0;
            }
        }
        int attackI = (int)(size / 2);
        int attackJ = (int)(size / 2);
        
        fields[attackI][attackJ] = 2; // set first motion "X"  

    }
    
    public int[][] getFields()
    {
        return fields;
    }
    
    ////////

    public void motion(int mySign)
    {
        int sign = mySign;

        System.out.println("Enter coordinate of row: ");
        int i = mainGame.getNumber();
        while(!mainGame.isCellOK(i))
        {
            System.out.println("Check your coordinte: ");
            i = mainGame.getNumber();
        }
        System.out.println("Enter coordinate of column: ");
        int j = mainGame.getNumber();
        while(!mainGame.isCellOK(j))
        {
            System.out.println("Check your coordinte: ");
            j = mainGame.getNumber();
        }

        if(!mainGame.isCellEmpty(i, j))
        {
            while(!mainGame.isCellEmpty(i, j))
            {
                System.out.println("Cells is not empty. Try again ");

                System.out.println("Enter coordinate of row: ");
                i = mainGame.getNumber();
                while(!mainGame.isCellOK(i))
                {
                    System.out.println("Check your coordinte: ");
                    i = mainGame.getNumber();
                }
                System.out.println("Enter coordinate of column:: ");
                j = mainGame.getNumber();
                while(!mainGame.isCellOK(j))
                {
                    System.out.println("Check your coordinte: ");
                    j = mainGame.getNumber();
                }
            }
        }
        fields[i][j] = sign;
    }

    public void printBoard()
    {
        System.out.println("\n   0  1  2  3  4  5  6  7  8  9 10 11 12 13 14");
        for(int i = 0; i < size; i++)
        {
            System.out.print(i+" ");
            if(i < 10)
                System.out.print(" ");
            for(int j = 0; j < size; j++)
            {
                switch (fields[i][j]) {
                case 0:  System.out.print("-  ");
                         break;
                case 1:  System.out.print("0  ");
                         break;
                case 2:  System.out.print("X  ");
                         break;
                }
            }
            System.out.println("\n");
        }
    }
}
