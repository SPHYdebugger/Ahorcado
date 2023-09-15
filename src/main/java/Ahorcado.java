import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;



public class Ahorcado {

    public static void main(String[] args) {

        //Create the vocabulary array

        String FILENAME = ".\\sources\\palabras_espanol.txt";
        File file= new File (FILENAME);
        ArrayList<String> words = new ArrayList<>();
        try {
            FileReader fr = new FileReader (file);
            BufferedReader bf = new BufferedReader (fr);
            String line = bf.readLine ();
            while (line!=null){
                // System.out.println(linea);
                words.add(line);
                line = bf.readLine ();
            }
            fr.close();
        }
        catch (IOException ex){
            System.out.println ("Hay un error");
        }

        //choose a word
        Random random = new Random();
        int randomNumber = random.nextInt(words.size() + 1);
        System.out.println(randomNumber);
        String wordSelected = words.get(randomNumber);

        //variables
        int wLength = wordSelected.length();
        boolean acertado= false;
        boolean fallado= false;
        boolean encontrado;
        int vidas;
        if (wordSelected.length()>6){
            vidas=8;
        }else {vidas=12;}

        Scanner keyboard = new Scanner(System.in);

        // Create and fill arrays
        char[] letters = new char[wLength];
            for (int i=0; i< letters.length; i++){
                letters[i]= wordSelected.charAt(i);
                //System.out.print(" " + letters[i]);
            }
        char[] emptyW = new char[wLength];
            for (int i=0; i< letters.length; i++){
                emptyW[i]= '_';
                System.out.print(" " + emptyW[i]);
            }
        ArrayList<Character> usedLetters = new ArrayList<>();


        //play
        System.out.println();
        System.out.println("La longitud de la palabra es " + letters.length);
        System.out.println("Adivina la palabra");

        System.out.println();
        System.out.println();
        do{
            System.out.println("Te quedan " + vidas + " oportunidades");
            System.out.println("Pueba una letra o resuelve (X)");
            char option = keyboard.next().charAt(0);
            if (option !='X'){
                encontrado=false;
                for (int i=0; i< letters.length; i++){
                    if (option==(letters[i])){
                        emptyW[i] = option;
                        encontrado=true;
                        System.out.print(" " + emptyW[i]);
                    }else {
                        System.out.print(" " + emptyW[i]);
                    }

                }
                if (!encontrado){vidas--;}
                System.out.println();
                usedLetters.add(option);
                System.out.print("Letras usadas :  ");
                for (int i=0; i< usedLetters.size(); i++ ) {
                    System.out.print(" " + usedLetters.get(i));
                }
            }else {
                keyboard.nextLine();
                System.out.println("Dime qué palabra crees que es");
                System.out.println("si aciertas ganas, pero si fallas se acaba el juego");
                String solution = keyboard.nextLine();
                if (solution.equals(wordSelected)){
                    System.out.println("ENHORABUENA HAS GANADO EL JUEGO");
                    acertado=true;

                }else {
                    System.out.println("Lo siento HAS PERDIDO");
                    System.out.println("la palabra era: " + wordSelected);
                }

            }
            System.out.println();

        }while(!acertado && !fallado && vidas!=0);
        System.out.println("Juego terminado");
        System.out.println("La palabra era " + wordSelected);

    }

}


