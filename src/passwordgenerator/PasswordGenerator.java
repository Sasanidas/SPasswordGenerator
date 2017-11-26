/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordgenerator;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 *
 * @author fer
 */
public class PasswordGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {

            int numberofPasswords;
            int passwordlen;
            boolean upper;
            boolean otherscharacts;
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Number of passwords(int): ");
            numberofPasswords = keyboard.nextInt();
            System.out.println("Password(s) length: ");
            passwordlen = keyboard.nextInt();
            System.out.println("Uppercase words?(Y-N): ");
            upper = keyboard.next().compareTo("Y") == 0;
            System.out.println("Anoter characters?[%-*...](Y-N): ");
            otherscharacts = keyboard.next().compareTo("Y") == 0;
            ArrayList<Password> passwords = password(numberofPasswords, passwordlen, upper, otherscharacts);
            try (PrintWriter writer = new PrintWriter("passwordss.txt", "UTF-8")) {
                for (int i = 0; i < passwords.size(); i++) {
                    writer.println(passwords.get(i).getPass());
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Format Error");
        } catch (Exception z) {
            System.out.println("Unexpected Error " + z.getMessage());
        }

    }

    public static ArrayList<Password> password(int passnum, int passwordlen, boolean uper, boolean other) throws Exception {
        ArrayList<Password> retu = new ArrayList<>();
        if (passwordlen < 0) {
            throw new Exception("Len error");
        }
        for (int i = 0; i < passnum; i++) {
            Password pa = new Password(passwordlen, uper, other);
            pa.setPass(pa.generatPassword());
            retu.add(pa);
        }

        return retu;
    }

}
