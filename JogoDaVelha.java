package Programas;

import java.util.Scanner;

import java.util.Random;

public class JogoDaVelha {
    public static void main(String[] args){
        char[][] A = new char[3][3];
        int i,j=0,c=0,p;
        char a;
        Scanner valor = new Scanner(System.in);
        
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                A[i][j] = 'm';
            }
        }
        
        System.out.println("1- Coop vs. IA");
        System.out.println("2- Modo versus");
        System.out.print("Escolha o modo de jogo: ");
        p = valor.nextInt();
        
        if(p==1){
            System.out.print("X ou O: ");
            a = valor.next().charAt(0);
            if(a=='x'){
                while(c!=9){
                    Coop_X(A,i,j,'x');
                    for(i=0;i<3;i++){
                        for(j=0;j<3;j++){
                            System.out.print(A[i][j] + " ");
                        }
                        System.out.println();
                    }
                    c++;
                    if(Verificacao(A,'x','o')==100){
                        System.out.print("\n\nVoce ganhou o jogo!");
                        break;
                    }
                    if(c==9){
                        System.out.print("\n\nDeu velha.");
                        break;
                    }
                    System.out.print("\n\n");
                    Coop_O(A,i,j,'o','x');
                    for(i=0;i<3;i++){
                        for(j=0;j<3;j++){
                            System.out.print(A[i][j] + " ");
                        }
                        System.out.println();
                    }
                    c++;
                    if(Verificacao(A,'o','x')==100){
                        System.out.print("\n\nVoce perdeu o jogo!");
                        break;
                    }
                    if(c==9){
                        System.out.print("\n\nDeu velha.");
                        break;
                    }
                    System.out.print("\n\n");
                }
            }
            if(a=='o'){
                while(c!=9){
                    Coop_O(A,i,j,'x','o');
                    for(i=0;i<3;i++){
                        for(j=0;j<3;j++){
                            System.out.print(A[i][j] + " ");
                        }
                        System.out.println();
                    }
                    c++;
                    if(Verificacao(A,'x','o')==100){
                        System.out.print("\n\nVoce perdeu o jogo!");
                        break;
                    }
                    if(c==9){
                        System.out.print("\n\nDeu velha.");
                        break;
                    }
                    System.out.print("\n\n");
                    Coop_X(A,i,j,'o');
                    for(i=0;i<3;i++){
                        for(j=0;j<3;j++){
                            System.out.print(A[i][j] + " ");
                        }
                        System.out.println();
                    }
                    c++;
                    if(Verificacao(A,'o','x')==100){
                        System.out.print("\n\nVoce ganhou o jogo!");
                        break;
                    }
                    if(c==9){
                        System.out.print("\n\nDeu velha.");
                        break;
                    }
                    System.out.print("\n\n");

                }
            }
        }
        if(p==2){
            System.out.print("Jogador 1 escolha: \nX ou O: ");
            a = valor.next().charAt(0);
            if(a=='x'){
                while(c!=9){
                    System.out.print("Vez do Jogador 1:\n");
                    Coop_X(A,i,j,'x');
                    for(i=0;i<3;i++){
                        for(j=0;j<3;j++){
                            System.out.print(A[i][j] + " ");
                        }
                        System.out.println();
                    }
                    c++;
                    if(Verificacao(A,'x','o')==100){
                        System.out.print("\n\nJogador 1 ganhou!");
                        break;
                    }
                    if(c==9){
                        System.out.print("\n\nDeu velha.");
                        break;
                    }
                    System.out.print("\n\n");
                    System.out.print("Vez do Jogador 2:\n");
                    Coop_X(A,i,j,'o');
                    for(i=0;i<3;i++){
                        for(j=0;j<3;j++){
                            System.out.print(A[i][j] + " ");
                        }
                        System.out.println();
                    }
                    c++;
                    if(Verificacao(A,'o','x')==100){
                        System.out.print("\n\nJogador 2 ganhou!");
                        break;
                    }
                    if(c==9){
                        System.out.print("\n\nDeu velha.");
                        break;
                    }
                    System.out.print("\n\n");
                }
            }
            if(a=='o'){
                while(c!=9){
                    System.out.print("Vez do Jogador 2:\n");
                    Coop_X(A,i,j,'x');
                    for(i=0;i<3;i++){
                        for(j=0;j<3;j++){
                            System.out.print(A[i][j] + " ");
                        }
                        System.out.println();
                    }
                    c++;
                    if(Verificacao(A,'x','o')==100){
                        System.out.print("\n\nJogador 2 ganhou!");
                        break;
                    }
                    if(c==9){
                        System.out.print("\n\nDeu velha.");
                        break;
                    }
                    System.out.print("\n\n");
                    System.out.print("Vez do Jogador 1:\n");
                    Coop_X(A,i,j,'o');
                    for(i=0;i<3;i++){
                        for(j=0;j<3;j++){
                            System.out.print(A[i][j] + " ");
                        }
                        System.out.println();
                    }
                    c++;
                    if(Verificacao(A,'o','x')==100){
                        System.out.print("\n\nJogador 1 ganhou!");
                        break;
                    }
                    if(c==9){
                        System.out.print("\n\nDeu velha.");
                        break;
                    }
                    System.out.print("\n\n");
                }
            }
        }
    }
    
    public static int Verificacao(char[][] A, char a, char b){
        int c=0,g=0,h=0,i,j=0;
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                if(A[i][j]==a){
                    c++;
                }
                if(A[i][j]==b){
                    c--;
                }
            }
            if(c==2){
                return i;
            }
            if(c==3){
                return 100;
            }
            c=0;
        }

        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                if(A[j][i]==a){
                    c++;
                }
                if(A[j][i]==b){
                    c--;
                }
            }
            if(c==2){
                return i+10;
            }
            if(c==3){
                return 100;
            }
            c=0;
        }

        for(i=0;i<3;i++){
            if(A[i][i]==a)
                c++;
            else if(A[i][i]==b)
                c--;
            else
                j=i;
        }
        if(c==2){
            return j+20;
        }
        else if(c==3){
            return 100;
        }

        c=0;
        j=0;

        for(i=2;i>=0;i--){
            if(A[i][j]==a)
                c++;
            else if(A[i][j]==b)
                c--;
            else{
                h=i;
                g=j;
            }
            j++;
        }
        if(c==2){
            h*=10;
            h+=g;
            return h+30;
        }
        if(c==3)
            return 100;
        return -1;
        }
    
    public static void Coop_X(char[][] A, int i, int j, char x){
        Scanner valor = new Scanner(System.in);
        System.out.print("Digite a linha em que voce deseja jogar: ");
        i = valor.nextInt();
        System.out.print("Digite a coluna em que voce deseja jogar: ");
        j = valor.nextInt();
        A[i-1][j-1]=x;
    }
    
    public static void Coop_O(char [][] A, int i, int j, char x, char y){
        int b=0;
        Random random = new Random();
        if(Verificacao(A,x,y)!=-1){
            if(Verificacao(A,x,y)<10){
                i = Verificacao(A,x,y);
                j = random.nextInt(3);
                if(A[i][j]=='m'){
                    A[i][j]=x;
                }else{
                    while(b==0){
                        j = random.nextInt(3);
                        if(A[i][j]=='m'){
                            A[i][j]=x;
                            b++;
                        }
                    }
                }
            }else if(10<=Verificacao(A,x,y) && Verificacao(A,x,y)<20){
                i = random.nextInt(3);
                j = Verificacao(A,x,y)-10;
                if(A[i][j]=='m'){
                    A[i][j]=x;
                }else{
                    while(b==0){
                        i = random.nextInt(3);
                        if(A[i][j]=='m'){
                            A[i][j]=x;
                            b++;
                        }
                    }
                }
            }else if(20<=Verificacao(A,x,y) && Verificacao(A,x,y)<30){
                i = Verificacao(A,x,y)-20;
                j = Verificacao(A,x,y)-20;
                if(A[i][j]=='m'){
                    A[i][j]=x;
                }
            }else if(Verificacao(A,x,y)>=30){
                i = (Verificacao(A,x,y)-30)/10;
                j = (Verificacao(A,x,y)-30)%10;
                if(A[i][j]=='m'){
                    A[i][j]=x;
                }
            }
        }else if(Verificacao(A,y,x)!=-1){
            if(Verificacao(A,y,x)<10){
                i = Verificacao(A,y,x);
                j = random.nextInt(3);
                if(A[i][j]=='m'){
                    A[i][j]=x;
                }else{
                    while(b==0){
                        j = random.nextInt(3);
                        if(A[i][j]=='m'){
                            A[i][j]=x;
                            b++;
                        }
                    }
                }
            }else if(10<=Verificacao(A,y,x) && Verificacao(A,y,x)<20){
                i = random.nextInt(3);
                j = Verificacao(A,y,x)-10;
                if(A[i][j]=='m'){
                    A[i][j]=x;
                }else{
                    while(b==0){
                        i = random.nextInt(3);
                        if(A[i][j]=='m'){
                            A[i][j]=x;
                            b++;
                        }
                    }
                }
            }else if(20<=Verificacao(A,y,x) && Verificacao(A,y,x)<30){
                i = Verificacao(A,y,x)-20;
                j = Verificacao(A,y,x)-20;
                if(A[i][j]=='m'){
                    A[i][j]=x;
                }
            }else if(Verificacao(A,y,x)>=30){
                j = (Verificacao(A,y,x)-30)%10;
                i = (Verificacao(A,y,x)-30)/10;
                if(A[i][j]=='m'){
                    A[i][j]=x;
                }
            }
        }else{
            i = random.nextInt(3);
            j = random.nextInt(3);
            if(A[i][j]=='m'){
                A[i][j]=x;
            }else{
                while(b==0){
                    i = random.nextInt(3);
                    j = random.nextInt(3);
                    if(A[i][j]=='m'){
                        A[i][j]=x;
                        b++;
                    }
                }
            }
        }
    }
}
