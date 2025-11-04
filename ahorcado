import java.util.Random;
import java.util.Scanner;

public class Main {

    static final String[] palabras = {"Crisu", "Roberto",
            "Kevin", "pep"};

    private static String palabraRandom(){
        Random random = new Random();
        int indice = random.nextInt(palabras.length);
        return palabras[indice];
    }

    private static Character leerPorConsola
            (String imprimePorConsola){
        System.out.print(imprimePorConsola);
        Scanner sc = new Scanner(System.in);
        return sc.next().charAt(0);
    }

    private static Boolean validarEntrada(
            Character caracterIntroducido,
              String palabraABuscar,
              String letrasIntroducidas){


    if(palabraABuscar.indexOf(caracterIntroducido) > -1
        && letrasIntroducidas.indexOf(caracterIntroducido) == -1)
    {
        System.out.println("Letra encontrada");
        return true;
    }

       if( letrasIntroducidas.indexOf(caracterIntroducido) > -1){
           System.out.println("El caracter introducido" +
                   " esta por duplicado");
           return true;
       }


       System.out.println("Letra no encontrada");
       return false;
    }

    private static String desofuscar(Character caracterIntroducido,
                                   String palabraABuscar,
                                   String palabraOfuscada){
        caracterIntroducido = Character.
                toLowerCase(caracterIntroducido);
        char[] letras = palabraOfuscada.toCharArray();

        for(int i = 0; i < palabraABuscar.length(); i++){
            if(palabraABuscar.charAt(i) == caracterIntroducido){
                letras[i] = caracterIntroducido;
            }
        }

        return String.valueOf(letras);
    }

    public static void main(String[] args) {
        // que metodos necesito:
        // un metodo que reste vidas

        int vidas = 5;

        String letrasIntroducidas = "";
        String palabraABuscar = palabraRandom();
        String palabraOfuscada = "_".repeat(palabraABuscar.length());
        System.out.println("La palabra a buscar es: "
                + palabraOfuscada);


        while(vidas > 0 &&
                !palabraABuscar.equals(palabraOfuscada)){
            var caracterIntroducido =
                    leerPorConsola(
                            "Dime una letra");

            boolean entradaValida =
                    validarEntrada(caracterIntroducido,
                            palabraABuscar, letrasIntroducidas);

            if(!entradaValida){
                vidas--;
                System.out.println("Te quedan " + vidas +
                        " vidas");
            }

            letrasIntroducidas += caracterIntroducido;

            palabraOfuscada = desofuscar(caracterIntroducido,
                    palabraABuscar, palabraOfuscada);
            System.out.println(palabraOfuscada);
        }
    }
}
