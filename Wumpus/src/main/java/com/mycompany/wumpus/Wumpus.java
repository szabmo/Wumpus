package com.mycompany.wumpus;


import java.io.IOException;
import java.util.*;

/**
 *
 * @author szapp
 */
public class Wumpus {
    
    public static void main(String[] args) throws IOException {
        Scanner be = new Scanner(System.in);
        int N=0;
                String felhasználónév;
        System.out.println("Add meg a felhasználóneved!");
        felhasználónév = be.nextLine();
        System.out.println("Kérem adja meg a pálya méretét!");
        while(N<6 || N>20){
            
            N=be.nextInt();
            if(N<6 || N>20)
            System.out.println("Hibás szám! 6-20");
        }
        
        String[][] PÁLYA = new String[N][N];
        int wumpuszokszáma=0;
        if(N<=8){
            wumpuszokszáma=1;
        }
        else if(N>=9 && N<=14){
            wumpuszokszáma=2;
        }
        else if(N>=15){
           wumpuszokszáma=3;
        }
        int nyilakszáma;
        nyilakszáma=wumpuszokszáma;
        int arany=1;
        int hősdb=1;
        boolean hősnélazarany=false;
        int hőspozícióx=0;
        int hőspozícióy=0;

        System.out.println("Üdv "+felhasználónév);
        System.out.println("WUMPUSZ");
        int megadottertek=-1;
        while (megadottertek !=3){
            System.out.println("Válassz a következő opciók közül:\n"
                    + "1 Pályaszerkesztő\n"
                    + "2 Játék\n"
                    + "3 Kilépés");
            megadottertek=be.nextInt();
            //pályaszerkesztő
                if(megadottertek == 1){
                    int valaszt=-1;

                    while (valaszt!=4){
                    System.out.println("A pályaszerkesztő opciók a következők:\n"
                    + "1 Helyben szerkesztem\n"
                    + "2 Fájlból olvasom\n"
                    + "3 Adatbázisból importálom\n"
                    + "4 Visszalépés");
                            valaszt=be.nextInt();
                            if(valaszt==2 || valaszt==3){
                                System.out.println("A funció még nem készült el!");
                                }
                            else if(valaszt==1){
                                System.out.println("Pálya széleinek feltöltése fallal és úttal");
                                for (int i = 0; i < N; i++) {
                                    for (int j = 0; j < N; j++) {
                                        if(i==0 || i==N-1){
                                            PÁLYA[i][j]="W";
                                        }
                                        else if(j==0 || j==N-1){
                                           PÁLYA[i][j]="W";
                                       }
                                        else if((i!=0 && i!=N-1) && (j!=0 && j!=N-1)){
                                           PÁLYA[i][j]="_";
                                       }
                                    }
                                }
                                System.out.println("Pálya alapja kész!");
                            
                            int valaszt2=-1;
                            while(valaszt2!=6){
                                System.out.println("Kérem válasszon a következő lehelyezhető eszközökből:\n"
                                        + "1 wumpusz\n"
                                        + "2 fal\n"
                                        + "3 verem\n"
                                        + "4 arany\n"
                                        + "5 hős\n"
                                        + "6 visszalépés");
                                valaszt2=be.nextInt();
                                //wumpusz
                                if(valaszt2==1){
                                     for (int i = 0; i < N; i++) {
                                        for (int j = 0; j < N; j++) {
                                            System.out.print(PÁLYA[i][j]);
                                        }
                                        System.out.println();
                                    }
                                    int valaszt3;
                                    System.out.println("wumpusz választó: \n"
                                            + "1 wumpusz hozzáadása\n"
                                            + "2 wumpusz eltávolítása");
                                    valaszt3=be.nextInt();
                                if(valaszt3==1 && wumpuszokszáma!=0){
                                    if(wumpuszokszáma==0){
                                    System.out.println("Nincs több wumpuszod");
                                }
                                    else if(wumpuszokszáma!=0){
                                        while(wumpuszokszáma!=0){
                                        System.out.println("A wumpuszok száma: "+wumpuszokszáma+"db");
                                        System.out.println("Kérlek add meg a sorok számát ahova le szeretnéd helyezni a wumpuszt");
                                        int x=0;
                                        int y=0;
                                        x=be.nextInt();
                                        System.out.println("Most add meg melyik oszlopba szeretnéd elhelyezni a wumpuszod!");
                                        y=be.nextInt();
                                        if(PÁLYA[x][y].equals("_")){
                                            PÁLYA[x][y]="U";
                                            wumpuszokszáma--;
                                            if(wumpuszokszáma==0){
                                                System.out.println("A wumpuszaid elfogytak! Visszalépés");
                                            }
                                        }
                                        else{
                                            System.out.println("Ide nem helyezheted le!");
                                        }
                                         }
                                }

                                }
                                else if(valaszt3==1 && wumpuszokszáma==0){
                                    System.out.println("Nincs wumpuszod!");
                                }
                                
                                if(valaszt3==2 && nyilakszáma>wumpuszokszáma){
                                    for (int i = 0; i < N; i++) {
                                        for (int j = 0; j < N; j++) {
                                            System.out.print(PÁLYA[i][j]);
                                        }
                                        System.out.println();
                                    }
                                    int x;
                                    int y;
                                    System.out.println("Kérlek add meg a sorok számát ahonnan szeretnéd eltávolítani a wumpuszt!");
                                    x=be.nextInt();
                                    System.out.println("Kérlek add meg az oszlopok számát ahonnan szeretnéd eltávolítani a wumpuszt!");
                                    y=be.nextInt();
                                    if(PÁLYA[x][y].equals("U")){
                                        PÁLYA[x][y]="_";
                                        wumpuszokszáma++;
                                        if(nyilakszáma==wumpuszokszáma){
                                            System.out.println("Nincs több wumpusz a pályán! Visszalépés.");
                                        }
                                    }
                                    else if (!(PÁLYA[x][y].equals("U"))){
                                        System.out.println("Ez nem egy wumpusz!");
                                    }
                                }
                                
                                
                            }
                                //wumpusz vége
                                //fal
                                if(valaszt2==2){
                                    System.out.println("Fal lehelyező!");
                                  int valaszt3=0;
                                  while(valaszt3 != 3){
                                      for (int i = 0; i < N; i++) {
                                          for (int j = 0; j < N; j++) {
                                              System.out.print(PÁLYA[i][j]);  
                                          }
                                          System.out.println();
                                      }
                                      System.out.println("Kérem válasszon a következő opciók közül:\n"
                                              + "1 Fal lehelyezése\n"
                                              + "2 Fal eltávolítása\n"
                                              + "3 Visszalépés");
                                      valaszt3=be.nextInt();
                                      
                                      
                                     if(valaszt3==1){
                                         System.out.println("Kérlek add meg a sorok számát ahova le szeretnéd helyezni a falat");
                                        int x=0;
                                        int y=0;
                                        x=be.nextInt();
                                        System.out.println("Most add meg melyik oszlopba szeretnéd elhelyezni a falat!");
                                        y=be.nextInt();
                                        if(PÁLYA[x][y].equals("_")){
                                            PÁLYA[x][y]="W";
                                            System.out.println("Fal sikeresen lehelyezve!");
                                        }
                                        else{
                                            System.out.println("Csak üres helyre helyezhetsz falat!");
                                        }
                                     }
                                     else if(valaszt3==2){
                                         int x;
                                    int y;
                                    System.out.println("Kérlek add meg a sorok számát ahonnan szeretnéd eltávolítani a falat!");
                                    x=be.nextInt();
                                    System.out.println("Kérlek add meg az oszlop számát ahonnan szeretnéd eltávolítani a falat!");
                                    y=be.nextInt();
                                    if(PÁLYA[x][y].equals("W")){
                                        PÁLYA[x][y]="_";
                                        System.out.println("Fal sikeresen eltávolítva!");
                                    }
                                    else{
                                        System.out.println("Ez nem fal!");
                                    }
                                     }
                                     else if(valaszt3==3){
                                         System.out.println("Visszalépés!");
                                     }
                                  }
                                }
                                //fal vége
                                //verem
                             if(valaszt2==3){
                                    System.out.println("Verem lehelyező!");
                                  int valaszt3=0;
                                  while(valaszt3 != 3){
                                      for (int i = 0; i < N; i++) {
                                          for (int j = 0; j < N; j++) {
                                              System.out.print(PÁLYA[i][j]);  
                                          }
                                          System.out.println();
                                      }
                                      System.out.println("Kérem válasszon a következő opciók közül:\n"
                                              + "1 Verem lehelyezése\n"
                                              + "2 Verem eltávolítása\n"
                                              + "3 Visszalépés");
                                      valaszt3=be.nextInt();
                                      
                                      
                                     if(valaszt3==1){
                                         System.out.println("Kérlek add meg a sorok számát ahova le szeretnéd helyezni a vermet");
                                        int x=0;
                                        int y=0;
                                        x=be.nextInt();
                                        System.out.println("Most add meg melyik oszlopba szeretnéd elhelyezni a vermet!");
                                        y=be.nextInt();
                                        if(PÁLYA[x][y].equals("_")){
                                            PÁLYA[x][y]="P";
                                            System.out.println("Verem sikeresen lehelyezve!");
                                        }
                                        else{
                                            System.out.println("Csak üres helyre helyezhetsz vermet!");
                                        }
                                     }
                                     else if(valaszt3==2){
                                         int x;
                                        int y;
                                    System.out.println("Kérlek add meg a sorok számát ahonnan szeretnéd eltávolítani a vermet!");
                                    x=be.nextInt();
                                    System.out.println("Kérlek add meg azt az oszlop számát ahonnan szeretnéd eltávolítani a vermet!");
                                    y=be.nextInt();
                                    if(PÁLYA[x][y].equals("P")){
                                        PÁLYA[x][y]="_";
                                        System.out.println("Verem sikeresen eltávolítva!");
                                    }
                                    else{
                                        System.out.println("Ez nem verem!");
                                    }
                                     }
                                     else if(valaszt3==3){
                                         System.out.println("Visszalépés!");
                                     }
                                  }
                                }                                
                                //verem vége
                                
                                //arany
                                if(valaszt2==4){
                                     for (int i = 0; i < N; i++) {
                                        for (int j = 0; j < N; j++) {
                                            System.out.print(PÁLYA[i][j]);
                                        }
                                        System.out.println();
                                    }
                                    int valaszt3;
                                    System.out.println("arany választó: \n"
                                            + "1 arany hozzáadása\n"
                                            + "2 arany eltávolítása");
                                    valaszt3=be.nextInt();
                                if(valaszt3==1 && arany!=0){
                                    if(arany==0){
                                    System.out.println("Nincs több aranyad");
                                }
                                    else if(arany!=0){
                                        while(arany!=0){
                                        System.out.println("Az arany száma: "+arany+"db");
                                        System.out.println("Kérlek add meg a sorok számát ahova le szeretnéd helyezni az aranyat");
                                        int x=0;
                                        int y=0;
                                        x=be.nextInt();
                                        System.out.println("Most add meg melyik oszlopba szeretnéd elhelyezni az aranyat!");
                                        y=be.nextInt();
                                        if(PÁLYA[x][y].equals("_")){
                                            PÁLYA[x][y]="G";
                                            System.out.println("Arany hozzáadása sikeres!");
                                            arany--;
                                            if(arany==0){
                                            
                                                System.out.println("Az arany elfogyott! Visszalépés");
                                            }
                                        }
                                        else{
                                            System.out.println("Ide nem helyezheted le!");
                                        }
                                         }
                                }

                                }
                                else if(valaszt3==1 && arany==0){
                                    System.out.println("Nincs arany!");
                                }
                                
                                if(valaszt3==2 && arany==0){
                                    for (int i = 0; i < N; i++) {
                                        for (int j = 0; j < N; j++) {
                                            System.out.print(PÁLYA[i][j]);
                                        }
                                        System.out.println();
                                    }
                                    int x;
                                    int y;
                                    System.out.println("Kérlek add meg a sorok számát ahonnan szeretnéd eltávolítani az aranyat!");
                                    x=be.nextInt();
                                    System.out.println("Kérlek add meg az oszlopok számát ahonnan szeretnéd eltávolítani az aranyat!");
                                    y=be.nextInt();
                                    if(PÁLYA[x][y].equals("G")){
                                        PÁLYA[x][y]="_";
                                        arany++;
                                        System.out.println("Arany eltávolítása sikeres!");
                                        if(arany==1){
                                            System.out.println("Nincs arany a pályán! Visszalépés.");
                                        }
                                    }
                                    else if (!(PÁLYA[x][y].equals("G"))){
                                        System.out.println("Ez nem az arany!");
                                    }
                                }
                                
                                
                            }                                                              
                                //arany vége
                                
                                //hős
                                if(valaszt2==5){
                                     for (int i = 0; i < N; i++) {
                                        for (int j = 0; j < N; j++) {
                                            System.out.print(PÁLYA[i][j]);
                                        }
                                        System.out.println();
                                    }
                                    int valaszt3;
                                    System.out.println("hős választó: \n"
                                            + "1 hős hozzáadása\n"
                                            + "2 hős eltávolítása");
                                    valaszt3=be.nextInt();
                                if(valaszt3==1 && hősdb!=0){
                                    if(hősdb==0){
                                    System.out.println("Nincs több hősöd");
                                }
                                    else if(hősdb!=0){
                                        while(hősdb!=0){
                                        System.out.println("A hősöd száma: "+hősdb+"db");
                                        System.out.println("Kérlek add meg a sorok számát ahova le szeretnéd helyezni a hőst");
                                        int x=0;
                                        int y=0;
                                        x=be.nextInt();
                                        System.out.println("Most add meg melyik oszlopokba szeretnéd elhelyezni a hőst!");
                                        y=be.nextInt();
                                        if(PÁLYA[x][y].equals("_")){
                                            PÁLYA[x][y]="H";
                                            System.out.println("Hős hozzáadása sikeres!");
                                            hősdb--;
                                            if(hősdb==0){
                                                
                                                System.out.println("A hősöd elfogyott! Visszalépés");
                                            }
                                        }
                                        else{
                                            System.out.println("Ide nem helyezheted le!");
                                        }
                                         }
                                }

                                }
                                else if(valaszt3==1 && hősdb==0){
                                    System.out.println("Nincs hősöd!");
                                }
                                
                                if(valaszt3==2 && hősdb==0){
                                    for (int i = 0; i < N; i++) {
                                        for (int j = 0; j < N; j++) {
                                            System.out.print(PÁLYA[i][j]);
                                        }
                                        System.out.println();
                                    }
                                    int x;
                                    int y;
                                    System.out.println("Kérlek add meg a sorok számát ahonnan szeretnéd eltávolítani a hősöd!");
                                    x=be.nextInt();
                                    System.out.println("Kérlek add meg az oszlop számát ahonnan szeretnéd eltávolítani a hősöd!");
                                    y=be.nextInt();
                                    if(PÁLYA[x][y].equals("H")){
                                        PÁLYA[x][y]="_";
                                        hősdb++;
                                        System.out.println("Hős eltávolítása sikeres!");
                                        if(hősdb==1){
                                            System.out.println("Nincs hősöd a pályán! Visszalépés.");
                                        }
                                    }
                                    else if (!(PÁLYA[x][y].equals("H"))){
                                        System.out.println("Ez nem a hős!");
                                    }
                                }
                                
                                
                            }                                
                                //hős vége
                            if(valaszt2==6){
                                System.out.println("Visszalépés az előző menüpontra!");
                            }
                            }
                            
                            } 
                            else{
                                System.out.println("Visszalépés");
                                break;
                                }
                            }
                }
                //pályaszerkesztő vége
                
                //játék
                if(megadottertek==2){
                    System.out.println("Kezdődjön a játék! Szerezd meg az aranyat és vidd vissza a kezdő pozícióba");
                    int hőskezdőx=0;
                    int hőskezdőy=0;

                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            if(PÁLYA[i][j].equals("H")){
                                hőskezdőx=j;
                                hőskezdőy=i;
                            }
                        }
                    }
                    int hősjelenlegix=hőskezdőx;
                    int hősjelenlegiy=hőskezdőy;
                 int hősélet=1;
                 String merrenéz[]={"Észak","Nyugat","Dél","Kelet"};
                 int mennyitfordul=0;
                boolean siker=false;
                        System.out.println("Jelenleg Észak fele nézel");
                while(hősélet!=0 || siker==true){
                        int valaszt2=0;
                        for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            System.out.print(PÁLYA[i][j]);
                            }
                            System.out.println();
                        }

                        System.out.println("Nyilaid száma: "+nyilakszáma);
                        
                
                    System.out.println("Az opciók a következők:\n"
                            + "1 Lép\n"
                            + "2 Fordul jobbra\n"
                            + "3 Fordul balra\n"
                            + "4 Lő\n"
                            + "5 Aranyat felszed");
                    valaszt2=be.nextInt();
                    //lépés
                    if(valaszt2==1){
                        if(merrenéz[mennyitfordul].equals("Észak")){

                            //falra lép
                            if(PÁLYA[hősjelenlegiy-1][hősjelenlegix].equals("W")){
                                System.out.println("Falra nem léphetsz!");
                            }
                            //verembe lép
                            else if(PÁLYA[hősjelenlegiy-1][hősjelenlegix].equals("P")){
                                PÁLYA[hősjelenlegiy][hősjelenlegix]="_";
                                hősjelenlegiy-=1;
                                PÁLYA[hősjelenlegiy][hősjelenlegix]="H";
                                if(nyilakszáma!=0){
                                nyilakszáma--;
                                System.out.println("Verembe léptél! Elvesztettél egy nyilat!"); 
                                }
                                else{
                                    System.out.println("Verembe léptél! Nincs több nyíl amit elveszthetsz!");
                                }
                                
                            }
                            //wumpuszra lép
                            else if(PÁLYA[hősjelenlegiy-1][hősjelenlegix].equals("U")){
                                System.out.println("Meghaltál!");
                                hősélet=0;
                            }
                            //aranyra lép
                            else if(PÁLYA[hősjelenlegiy-1][hősjelenlegix].equals("G")){
                                System.out.println("Megtaláltad az aranyat! Most vedd fel!");
                                hősjelenlegiy-=1;
                            }
                            //útra lép
                            else if(PÁLYA[hősjelenlegiy-1][hősjelenlegix].equals("_")){
                                PÁLYA[hősjelenlegiy][hősjelenlegix]="_";
                                hősjelenlegiy-=1;
                                PÁLYA[hősjelenlegiy][hősjelenlegix]="H";
                            }
                        }

                        
                    if(merrenéz[mennyitfordul].equals("Nyugat")){
                            //falra lép
                            if(PÁLYA[hősjelenlegiy][hősjelenlegix-1].equals("W")){
                                System.out.println("Falra nem léphetsz!");
                            }
                            //verembe lép
                            else if(PÁLYA[hősjelenlegiy][hősjelenlegix-1].equals("P")){
                                PÁLYA[hősjelenlegiy][hősjelenlegix]="_";
                                hősjelenlegix-=1;
                                PÁLYA[hősjelenlegiy][hősjelenlegix]="H";
                                if(nyilakszáma!=0){
                                nyilakszáma--;
                                System.out.println("Verembe léptél! Elvesztettél egy nyilat!"); 
                                }
                                else{
                                    System.out.println("Verembe léptél! Nincs több nyíl amit elveszthetsz!");
                                }
                                
                            }
                            //wumpuszra lép
                            else if(PÁLYA[hősjelenlegiy][hősjelenlegix-1].equals("U")){
                                System.out.println("Meghaltál!");
                                hősélet=0;
                            }
                            //aranyra lép
                            else if(PÁLYA[hősjelenlegiy][hősjelenlegix-1].equals("G")){
                                System.out.println("Megtaláltad az aranyat! Most vedd fel!");
                                hősjelenlegix-=1;
                            }
                            //útra lép
                            else if(PÁLYA[hősjelenlegiy][hősjelenlegix-1].equals("_")){
                                PÁLYA[hősjelenlegiy][hősjelenlegix]="_";
                                hősjelenlegix-=1;
                                PÁLYA[hősjelenlegiy][hősjelenlegix]="H";
                            }
                        }    
                       if(merrenéz[mennyitfordul].equals("Dél")){
                            //falra lép
                            if(PÁLYA[hősjelenlegiy+1][hősjelenlegix].equals("W")){
                                System.out.println("Falra nem léphetsz!");
                            }
                            //verembe lép
                            else if(PÁLYA[hősjelenlegiy+1][hősjelenlegix].equals("P")){
                                PÁLYA[hősjelenlegiy][hősjelenlegix]="_";
                                hősjelenlegiy+=1;
                                PÁLYA[hősjelenlegiy][hősjelenlegix]="H";
                                if(nyilakszáma!=0){
                                nyilakszáma--;
                                System.out.println("Verembe léptél! Elvesztettél egy nyilat!"); 
                                }
                                else{
                                    System.out.println("Verembe léptél! Nincs több nyíl amit elveszthetsz!");
                                }
                                
                            }
                            //wumpuszra lép
                            else if(PÁLYA[hősjelenlegiy+1][hősjelenlegix].equals("U")){
                                System.out.println("Meghaltál!");
                                hősélet=0;
                            }
                            //aranyra lép
                            else if(PÁLYA[hősjelenlegiy+1][hősjelenlegix].equals("G")){
                                System.out.println("Megtaláltad az aranyat! Most vedd fel!");
                                hősjelenlegiy+=1;
                            }
                            //útra lép
                            else if(PÁLYA[hősjelenlegiy+1][hősjelenlegix].equals("_")){
                                PÁLYA[hősjelenlegiy][hősjelenlegix]="_";
                                hősjelenlegiy+=1;
                                PÁLYA[hősjelenlegiy][hősjelenlegix]="H";
                            }
                        } 
                        
                    if(merrenéz[mennyitfordul].equals("Kelet")){
                            //falra lép
                            if(PÁLYA[hősjelenlegiy][hősjelenlegix+1].equals("W")){
                                System.out.println("Falra nem léphetsz!");
                            }
                            //verembe lép
                            else if(PÁLYA[hősjelenlegiy][hősjelenlegix+1].equals("P")){
                                PÁLYA[hősjelenlegiy][hősjelenlegix]="_";
                                hősjelenlegix+=1;
                                PÁLYA[hősjelenlegiy][hősjelenlegix]="H";
                                if(nyilakszáma!=0){
                                nyilakszáma--;
                                System.out.println("Verembe léptél! Elvesztettél egy nyilat!"); 
                                }
                                else{
                                    System.out.println("Verembe léptél! Nincs több nyíl amit elveszthetsz!");
                                }
                                
                            }
                            //wumpuszra lép
                            else if(PÁLYA[hősjelenlegiy][hősjelenlegix+1].equals("U")){
                                System.out.println("Meghaltál!");
                                hősélet=0;
                            }
                            //aranyra lép
                            else if(PÁLYA[hősjelenlegiy][hősjelenlegix+1].equals("G")){
                                System.out.println("Megtaláltad az aranyat! Most vedd fel!");
                                hősjelenlegix+=1;
                            }
                            //útra lép
                            else if(PÁLYA[hősjelenlegiy][hősjelenlegix+1].equals("_")){
                                PÁLYA[hősjelenlegiy][hősjelenlegix]="_";
                                hősjelenlegix+=1;
                                PÁLYA[hősjelenlegiy][hősjelenlegix]="H";
                            }
                        }                          
                        //lépés vége
                        
                        
                        
                        
                      //fordulás balra  
                    }
                        if(valaszt2==2){
                        mennyitfordul--;
                        if(mennyitfordul<0){
                            mennyitfordul=3;
                        }
                        if(mennyitfordul==0){
                            System.out.println("Jelenleg "+merrenéz[mennyitfordul]+" irányába nézel");

                        }
                        else if(mennyitfordul==1){
                            System.out.println("Jelenleg "+merrenéz[mennyitfordul]+" irányába nézel");

                        }
                         else if(mennyitfordul==2){
                            System.out.println("Jelenleg "+merrenéz[mennyitfordul]+" irányába nézel");

                        }
                        else if(mennyitfordul==3){
                            System.out.println("Jelenleg "+merrenéz[mennyitfordul]+" irányába nézel");

                        }
                        //fordulás balra vége
                        
                        //fordulás jobbra
                    }
                    if(valaszt2==3){
                        mennyitfordul++;
                        if(mennyitfordul>3){
                            mennyitfordul=0;
                        }
                        if(mennyitfordul==0){
                            System.out.println("Jelenleg "+merrenéz[mennyitfordul]+" irányába nézel");

                        }
                        else if(mennyitfordul==1){
                            System.out.println("Jelenleg "+merrenéz[mennyitfordul]+" irányába nézel");

                        }
                         else if(mennyitfordul==2){
                            System.out.println("Jelenleg "+merrenéz[mennyitfordul]+" irányába nézel");

                        }
                        else if(mennyitfordul==3){
                            System.out.println("Jelenleg "+merrenéz[mennyitfordul]+" irányába nézel");

                        }
                        
                    }
                //fordulás jobbra vége
                
                //lövés
                if(valaszt2==4 && nyilakszáma!=0){
                    
                    
                            if(merrenéz[mennyitfordul].equals("Észak")){
                            //falra lő
                            if(PÁLYA[hősjelenlegiy-1][hősjelenlegix].equals("W")){
                                System.out.println("Falra lőtted a nyilad!");
                                nyilakszáma--;
                            }
                            //verembe lő
                            else if(PÁLYA[hősjelenlegiy-1][hősjelenlegix].equals("P")){
                                System.out.println("Verembe lőtted a nyilad!");
                                nyilakszáma--;
                            }
                            //wumpuszra lő
                            else if(PÁLYA[hősjelenlegiy-1][hősjelenlegix].equals("U")){
                                PÁLYA[hősjelenlegiy-1][hősjelenlegix]="_";
                                nyilakszáma--;
                                System.out.println("Sikeresen kilőttél egy wumpuszt!");
                                
                            }
                            //aranyra lő
                            else if(PÁLYA[hősjelenlegiy-1][hősjelenlegix].equals("G")){
                                System.out.println("Aranyra lőtted a nyilad!");
                                nyilakszáma--;
                            }
                            //útra lő
                            else if(PÁLYA[hősjelenlegiy-1][hősjelenlegix].equals("_")){
                                System.out.println("Útra lőtted a nyilad!");
                                nyilakszáma--;
                            }
                        }

                        
                    if(merrenéz[mennyitfordul].equals("Nyugat")){
                            //falra lő
                            if(PÁLYA[hősjelenlegiy][hősjelenlegix-1].equals("W")){
                                System.out.println("Falra lőtted a nyilad!");
                                nyilakszáma--;
                            }
                            //verembe lő
                            else if(PÁLYA[hősjelenlegiy][hősjelenlegix-1].equals("P")){
                                System.out.println("Verembe lőtted a nyilad!");
                                nyilakszáma--;
                                
                            }
                            //wumpuszra lő
                            else if(PÁLYA[hősjelenlegiy][hősjelenlegix-1].equals("U")){
                                PÁLYA[hősjelenlegiy][hősjelenlegix-1]="_";
                                nyilakszáma--;
                                System.out.println("Sikeresen kilőttél egy wumpuszt!");
                            }
                            //aranyra lő
                            else if(PÁLYA[hősjelenlegiy][hősjelenlegix-1].equals("G")){
                                System.out.println("Aranyra lőtted a nyilad!");
                                nyilakszáma--;
                            }
                            //útra lő
                            else if(PÁLYA[hősjelenlegiy][hősjelenlegix-1].equals("_")){
                                System.out.println("Útra lőtted a nyilad!");
                                nyilakszáma--;
                            }
                        }
                    
                    
                    
                       if(merrenéz[mennyitfordul].equals("Dél")){
                            //falra lő
                            if(PÁLYA[hősjelenlegiy+1][hősjelenlegix].equals("W")){
                                System.out.println("Falra lőtted a nyilad!");
                                nyilakszáma--;
                            }
                            //verembe lő
                            else if(PÁLYA[hősjelenlegiy+1][hősjelenlegix].equals("P")){
                                System.out.println("Verembe lőtted a nyilad!");
                                nyilakszáma--;
                                
                            }
                            //wumpuszra lő
                            else if(PÁLYA[hősjelenlegiy+1][hősjelenlegix].equals("U")){
                                PÁLYA[hősjelenlegiy+1][hősjelenlegix]="_";
                                nyilakszáma--;
                                System.out.println("Sikeresen kilőttél egy wumpuszt!");
                            }
                            //aranyra lő
                            else if(PÁLYA[hősjelenlegiy+1][hősjelenlegix].equals("G")){
                                System.out.println("Aranyra lőtted a nyilad!");
                                nyilakszáma--;
                            }
                            //útra lő
                            else if(PÁLYA[hősjelenlegiy+1][hősjelenlegix].equals("_")){
                                System.out.println("Útra lőtted a nyilad!");
                                nyilakszáma--;
                            }
                        } 
                        
                    if(merrenéz[mennyitfordul].equals("Kelet")){
                            //falra lő
                            if(PÁLYA[hősjelenlegiy][hősjelenlegix+1].equals("W")){
                                System.out.println("Falra lőtted a nyilad!");
                                nyilakszáma--;
                            }
                            //verembe lő
                            else if(PÁLYA[hősjelenlegiy][hősjelenlegix+1].equals("P")){
                                System.out.println("Verembe lőtted a nyilad!");
                                nyilakszáma--;
                                
                            }
                            //wumpuszra lő
                            else if(PÁLYA[hősjelenlegiy][hősjelenlegix+1].equals("U")){
                                PÁLYA[hősjelenlegiy][hősjelenlegix+1]="_";
                                nyilakszáma--;
                                System.out.println("Sikeresen kilőttél egy wumpuszt!");
                            }
                            //aranyra lép
                            else if(PÁLYA[hősjelenlegiy][hősjelenlegix+1].equals("G")){
                                System.out.println("Aranyra lőtted a nyilad!");
                                nyilakszáma--;
                            }
                            //útra lép
                            else if(PÁLYA[hősjelenlegiy][hősjelenlegix+1].equals("_")){
                                System.out.println("Útra lőtted a nyilad!");
                                nyilakszáma--;
                            }
                        } 
                }
                if(valaszt2==4 && nyilakszáma==0){
                    System.out.println("Nem tudsz többet lőni");
                }
                //lövés vége
                 
                //arany felvesz
                if(valaszt2==5){

                    if(PÁLYA[hősjelenlegiy][hősjelenlegix].equals("G")){
                        for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            if(PÁLYA[i][j].equals("H")){
                                PÁLYA[i][j]="_";
                            }
                        }
                    }
                        PÁLYA[hősjelenlegiy][hősjelenlegix]="H";
                     hősnélazarany=true;
                        System.out.println("Felvetted az aranyat!!");
                    }
                }
                
                //arany felvesz vége
                //játék vége
                if(hősjelenlegix == hőskezdőx && hősjelenlegiy == hőskezdőy && hősnélazarany==true){
                    System.out.println(hősjelenlegix+" "+hősjelenlegiy);
                    System.out.println(hőskezdőx+" "+hőskezdőy);
                    System.out.println("Gratulálok! Sikerült végigjátszanod!");
                    siker=true;
                    break;
                }
                }
                
                }
                
                
                    //játék vége
                if(megadottertek==3){
                    System.out.println("Viszlát!");
                    break;
                }

        }
    }
}
