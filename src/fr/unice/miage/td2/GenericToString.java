package fr.unice.miage.td2;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

public class GenericToString {


    public GenericToString() {

    }


    public String toString(Object o, int p) throws IllegalAccessException{

        String res = "";
        Class classeO = o.getClass();

        res += classeO.getName()+"[ ";

        ArrayList<Field> champs = getAllFields(classeO);

        //Field[] fields = classeO.getDeclaredFields();

        for (int i = 0; i < champs.size(); i++) {

            if(p <= 0){
                return "";
            }


            Field champ = champs.get(i);
            champ.setAccessible(true);

            res += champ.getName()+"=";

            if(champ.getType().isPrimitive()){

                res += champ.get(o);

                if(i != champs.size()-1){
                    res += "; ";
                }



            }else {
                if (champ.getType().isArray()) {
                    res += "{";

                    Object tab = champ.get(o);

                    for (int j = 0; j < Array.getLength(tab) - 1; j++) {
                        res += Array.get(tab, j) + ", ";
                    }
                    res += Array.getLength(champ.get(o));
                    res += "}; ";
                }else{
                    res += "\n";
                    res += this.toString(champ.get(o),p-1);
                }
            }

        }
        res += "]";
        return res;
    }


    public static ArrayList<Field> getAllFields(Class<?> type) {
        ArrayList<Field> fields = new ArrayList<>();

        for (Field field : type.getFields()) {
            if (!fields.contains(field)) {
                fields.add(field);
            }
        }

        for (Field field : type.getDeclaredFields()) {
            if (!fields.contains(field)) {
                fields.add(field);
            }
        }

        return fields;
    }



}
