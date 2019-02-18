package fr.unice.miage.td2;

public class GenericToString {


    public GenericToString() {

    }


    public String toString(Object o) {

        String res = "";



        String name = o.getClass().getName();

        
        res += name;
        res += o.toString();




        return res;
    }
}
