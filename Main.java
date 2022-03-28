package com.company;

import work.with.file.ReadFromFile;
import work.with.file.WriteInFile;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        WriteInFile generalWriteInFile = new WriteInFile("input_data.txt");

        int counterOfClient = 50;
        int counterOfPackages = 666;
        int counterOfOffice = 50;
        ReadFromFile firstFNameReadFromFile = new ReadFromFile("first_name_f_file.txt");
        ArrayList<String> firstFNameArray = firstFNameReadFromFile.readFromFile();
        ReadFromFile firstMNameReadFromFile = new ReadFromFile("first_name_m_file.txt");
        ArrayList<String> firstMNameArray = firstMNameReadFromFile.readFromFile();

        ReadFromFile secondFNameReadFromFile = new ReadFromFile("second_name_f_file.txt");
        ArrayList<String> secondFNameArray = secondFNameReadFromFile.readFromFile();
        ReadFromFile secondMNameReadFromFile = new ReadFromFile("second_name_m_file.txt");
        ArrayList<String> secondMNameArray = secondMNameReadFromFile.readFromFile();

        ReadFromFile patronymicFReadFromFile = new ReadFromFile("patronymic_f_file.txt");
        ArrayList<String> patronymicFArray = patronymicFReadFromFile.readFromFile();
        ReadFromFile patronymicMReadFromFile = new ReadFromFile("patronymic_m_file.txt");
        ArrayList<String> patronymicMArray = patronymicMReadFromFile.readFromFile();

        ReadFromFile officeReadFromFile = new ReadFromFile("describe_office_file.txt");
        ArrayList<String> officeArray = officeReadFromFile.readFromFile();

        ArrayList<String> telephoneArray = new ArrayList<>();
        String tel1 = "0";
        for(int i = 0; i < counterOfClient; i++){
//            int myRandMF = (int)(Math.random());
            int myRandf = 1;
            int myRands = 1;
            int myRandp = 1;
            if(i % 2 == 0){
                tel1 += "96";
                for(int j = 0; j < 7; j++){
                    int myRand = (int)(Math.random()*10);
                    tel1+= myRand;
                }
                myRandf = (int)(Math.random()*firstFNameArray.size());
                myRands = (int)(Math.random()*secondFNameArray.size());
                myRandp = (int)(Math.random()*patronymicFArray.size());
                generalWriteInFile.writeInFile("REGISTRPEOPLE;"+
                        firstFNameArray.get(myRandf)+";"+
                        secondFNameArray.get(myRands)+";"+
                        patronymicFArray.get(myRandp)+";"+
                        "emailforpeople"+(i+1)+"@gmail.com;"+
                        "+38"+tel1);
            } else{
                tel1 += "50";
                for(int j = 0; j < 7; j++){
                    int myRand = (int)(Math.random()*10);
                    tel1+= myRand;
                }
                myRandf = (int) (Math.random() * firstMNameArray.size());
                myRands = (int) (Math.random() * secondMNameArray.size());
                myRandp = (int) (Math.random() * patronymicMArray.size());
                generalWriteInFile.writeInFile("REGISTRPEOPLE;"+
                        firstMNameArray.get(myRandf)+";"+
                        secondMNameArray.get(myRands)+";"+
                        patronymicMArray.get(myRandp)+";"+
                        "emailforpeople"+(i+1)+"@gmail.com;"+
                        "+38"+tel1);
            }
            telephoneArray.add("+38"+tel1);
            tel1 = "0";
        }

        ArrayList<String> numOfficeArray = new ArrayList<>();
        String tmpForEqual = ";";
        int tmpof = 1;
        for(int k = 0; k < counterOfOffice; k++){
            boolean flagEqual = true;
            tmpForEqual += tmpof;
            tmpof++;
//            while(flagEqual){
//                flagEqual = false;
////                System.out.println(flagEqual);
//                int myRandOffice = (int)(Math.random()*100);
//                tmpForEqual += myRandOffice;
////                System.out.println(tmpForEqual);
//                for(int coun = 0; coun < numOfficeArray.size(); coun++){
////                    System.out.println("in for");
//                    if(tmpForEqual == numOfficeArray.get(coun)){
//                        flagEqual = true;
//                        tmpForEqual = ";";
//                        break;
//                    }
//                    flagEqual = false;
//                }
//            }
            int myRandD = (int)(Math.random()*officeArray.size());
            generalWriteInFile.writeInFile("REGISTRPOSTALOFFICE" +
                    tmpForEqual + ";" + officeArray.get(myRandD));
            numOfficeArray.add(tmpForEqual);
            tmpForEqual = ";";
        }

        for(int k = 0; k < counterOfPackages; k++){
            int myRandMF = (int)(Math.random());
            int myRandt = (int) (Math.random() * telephoneArray.size());
            int myRandof = (int) (Math.random() * numOfficeArray.size());
            int myRandf = 1;
            int myRands = 1;
            int myRandp = 1;
            String tel = "66";
            for (int j = 0; j < 7; j++) {
                int myRand = (int) (Math.random() * 10);
                tel += myRand;
            }
            if(myRandMF == 0) {
                myRandf = (int) (Math.random() * firstMNameArray.size());
                myRands = (int) (Math.random() * secondMNameArray.size());
                myRandp = (int) (Math.random() * patronymicMArray.size());
                generalWriteInFile.writeInFile("REGISTRPACKAGE;" +
                        telephoneArray.get(myRandt) +
                        numOfficeArray.get(myRandof) + ";" +
                        "+380" + tel + ";" +
                        firstMNameArray.get(myRandf) + ";" +
                        secondMNameArray.get(myRands) + ";" +
                        patronymicMArray.get(myRandp));
            } else{
                myRandf = (int) (Math.random() * firstFNameArray.size());
                myRands = (int) (Math.random() * secondFNameArray.size());
                myRandp = (int) (Math.random() * patronymicFArray.size());
                generalWriteInFile.writeInFile("REGISTRPACKAGE;" +
                        telephoneArray.get(myRandt) +
                        numOfficeArray.get(myRandof) + ";" +
                        "+380" + tel + ";" +
                        firstFNameArray.get(myRandf) + ";" +
                        secondFNameArray.get(myRands) + ";" +
                        patronymicFArray.get(myRandp));
            }
        }

//        ArrayList<String> firstNameArray = firstNameReadFromFile.readFromFile();
//        Iterator<String> generalIter = firstNameArray.iterator();
//        while(generalIter.hasNext()){
//            System.out.println(generalIter.next());
//        }
        generalWriteInFile.close();
    }
}
