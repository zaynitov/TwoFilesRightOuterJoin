import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;


public class Main {


    static String nameOfFirstFile = "file1.txt";
    static String nameOfSecondFile = "file2.txt";


    public static ArrayList<String> getInfo(String fileName) throws IOException {


        return (ArrayList<String>) Files.lines(Paths.get(fileName)).collect(Collectors.toList());


    }


    public static void getArrayElements(String checkingString, List<String> idList, List<String> valueList) {


        int pos = 0;


        String idString = "";
        while (!Character.toString(checkingString.charAt(pos)).equals(" ") && (pos < checkingString.length() - 1)) {
            idString += Character.toString(checkingString.charAt(pos));
            pos++;
        }
        idList.add(idString);


        while (Character.toString(checkingString.charAt(pos)).equals(" ") && (pos < checkingString.length() - 1)) {
            pos++;
        }


        String valueString = "";
        while (!Character.toString(checkingString.charAt(pos)).equals(" ") && (pos < checkingString.length() - 1)) {
            valueString += Character.toString(checkingString.charAt(pos));
            pos++;

        }
        valueList.add(valueString);


    }


    public static void rightOuterJoin(ArrayList<String> idListSecondFile, ArrayList<String> idListFirstFile, ArrayList<String> valueListSecondFile, ArrayList<String> valueListFirstFile) {


        for (int i = 0; i < idListSecondFile.size(); i++) {


            boolean isMatches = false;


            for (int j = 0; j < idListFirstFile.size(); j++) {


                if (idListSecondFile.get(i).equals(idListFirstFile.get(j))) {


                    System.out.println(idListSecondFile.get(i) + "  " + valueListSecondFile.get(i) + "  " + valueListFirstFile.get(j));
                    isMatches = true;


                }


            }


            if (!isMatches) {


                System.out.println(idListSecondFile.get(i) + "     " + valueListSecondFile.get(i));


            }


        }


    }


    public static void main(String[] args) throws IOException {


        ArrayList<String> linesOfFirstFile = getInfo(nameOfFirstFile);
        ArrayList<String> linesOfSecondFile = getInfo(nameOfSecondFile);


        ArrayList<String> idListFirstFile = new ArrayList<>();
        ArrayList<String> valueListFirstFile = new ArrayList<>();


        ArrayList<String> idListSecondFile = new ArrayList<>();
        ArrayList<String> valueListSecondFile = new ArrayList<>();


        for (int i = 0; i < linesOfFirstFile.size(); i++) {


            getArrayElements(linesOfFirstFile.get(i), idListFirstFile, valueListFirstFile);


        }


        for (int i = 0; i < linesOfSecondFile.size(); i++) {



            getArrayElements(linesOfSecondFile.get(i), idListSecondFile, valueListSecondFile);



        }


        rightOuterJoin(idListSecondFile, idListFirstFile, valueListSecondFile, valueListFirstFile);


    }

}
