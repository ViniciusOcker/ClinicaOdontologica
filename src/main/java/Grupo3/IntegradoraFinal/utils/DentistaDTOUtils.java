package Grupo3.IntegradoraFinal.utils;

import com.fasterxml.jackson.databind.ObjectMapper;


public class DentistaDTOUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();
    public static String asJsonString(final Object o){
        try {
            return objectMapper.writeValueAsString(o);
        } catch (Exception e){
            throw new RuntimeException();
        }
    }


    public static <T> T objectFromString(Class<T> aClass, String value) {
        try{
            return objectMapper.readValue(value, aClass);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static <T> T objectFromString1(Class<T> aClass, String value) {
        try{
            return objectMapper.readValue(value, aClass);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
