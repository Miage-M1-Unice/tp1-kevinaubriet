package fr.unice.miage.td2;


import java.lang.reflect.*;
import java.io.*;

public class AnalyseurDeClasse {

    public static void analyseClasse(String nomClasse) throws ClassNotFoundException {
        // Récupération d'un objet de type Class correspondant au nom passé en paramètres

        Class cl = getClasse(nomClasse);// CODE A ECRIRE !

        afficheEnTeteClasse(cl);

        System.out.println();
        afficheAttributs(cl);

        System.out.println();
        afficheConstructeurs(cl);

        System.out.println();
        afficheMethodes(cl);

        // L'accolade fermante de fin de classe !
        System.out.println("}");
    }


    /** Retourne la classe dont le nom est passé en paramètre */
    public static Class getClasse(String nomClasse) throws ClassNotFoundException {
        Class cl = Class.forName(nomClasse);

        return cl;
    }


    /** Cette méthode affiche par ex "public class Toto extends Tata implements Titi, Tutu {" */
    public static void afficheEnTeteClasse(Class cl) {
        //  Affichage du modifier et du nom de la classe

        String res = "";

        int iModifier = cl.getModifiers();
        String modifier = Modifier.toString(iModifier);
        String name = cl.getName();

        res += modifier + " " + name;


        // Récupération de la superclasse si elle existe (null si cl est le type Object)

        // On ecrit le "extends " que si la superclasse est non nulle et
        // différente de Object
        if(!(cl.getSuperclass() instanceof Object) && cl.getSuperclass() != null){
            Class superC = cl.getSuperclass();
            res += " extends "+ superC;

        }




        // Affichage des interfaces que la classe implemente
        if(cl.getInterfaces() != null){
            Object[] interfaces = cl.getInterfaces();

            res += " implements ";

            for(int i=0; i<interfaces.length;i++){
                Object interfacei = interfaces[i];
                if(i==0){
                    res += interfacei;
                }else{
                    res += ", " +interfacei;
                }

            }

        }
        System.out.print(res);

        // Enfin, l'accolade ouvrante !
        System.out.print(" {\n");
    }

    public static void afficheAttributs(Class cl) {
        System.out.println("------- Attributs -------");

        Field fields[] = cl.getFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i]);
        }
    }

    public static void afficheConstructeurs(Class cl) {
        System.out.println("------- Constructeurs -------");

        Constructor constructors[] = cl.getConstructors();
        for(int i = 0; i < constructors.length; i++) {
            System.out.println(constructors[i]);
        }
        System.out.println("{}");

    }

    public static void afficheMethodes(Class cl) {
        System.out.println("------- Methodes -------");

        Method[] methods = cl.getMethods();
        for (int i  = 0; i< methods.length; i++) {
            System.out.println(methods[i]);
        }
        System.out.println("{}");
    }


    public static String litChaineAuClavier() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
        }


public static void main(String[] args) {
        boolean ok = false;

        while(!ok) {
            try {
                System.out.print("Entrez le nom d'une classe (ex : java.util.Date): ");
                String nomClasse = litChaineAuClavier();

                analyseClasse(nomClasse);

                ok = true;
            }
            catch(ClassNotFoundException e) {
                System.out.println("Classe non trouvée.");
            }
            catch(IOException e) {
                System.out.println("Erreur d'E/S!");
            }
        }
    }
}
