/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordgenerator;

/**
 *
 * @author fer
 */
public class Password {

    static public String[] characts = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    static public String[] wirdchars = {"%", "$", "!", "-", "_", "+", "*", "?"};
    private int length;
    private String pass;
    private boolean upper;
    private boolean wird;

    public Password(int length, boolean upper, boolean wird) {
        this.length = length;
        this.upper = upper;
        this.wird = wird;
    }

    public String generatPassword() {
        String retu = "";
        double num;
        if (this.isUpper() && !this.isWird()) {
            for (int i = 0; i < this.getLength(); i++) {
                num = Math.random();
                if (num < 0.25) {
                    retu +=  ((int) (Math.random() * 100) + "").charAt(0) + "";
                } else if (num > 0.25 && num < 0.50) {
                    retu += characts[(int) (Math.random() * characts.length - 1)].toUpperCase();
                } else if (num > 0.50) {
                    retu += characts[(int) (Math.random() * characts.length - 1)];
                }
            }
        } else if (!this.isUpper() && this.isWird()) {
            for (int i = 0; i < this.getLength(); i++) {
                num = Math.random();
                if (num < 0.25) {
                       retu +=  ((int) (Math.random() * 100) + "").charAt(0) + "";
                } else if (num > 0.25 && num < 0.50) {
                    retu += wirdchars[(int) (Math.random() * wirdchars.length - 1)];
                } else if (num > 0.50) {
                    retu += characts[(int) (Math.random() * characts.length - 1)];
                }
            }

        } else if (this.isUpper() && this.isWird()) {
            for (int i = 0; i < this.getLength(); i++) {
                num = Math.random();
                if (num < 0.25) {
                    retu +=  ((int) (Math.random() * 100) + "").charAt(0) + "";
                } else if (num > 0.25 && num < 0.50) {
                    retu += wirdchars[(int) (Math.random() * wirdchars.length - 1)];
                } else if (num > 0.50 && num < 0.75) {
                    retu += characts[(int) (Math.random() * characts.length - 1)];
                } else if (num > 0.75) {
                    retu += characts[(int) (Math.random() * characts.length - 1)].toUpperCase();
                }
            }

        } else if (!this.isUpper() && !this.isWird()) {
            for (int i = 0; i < this.getLength(); i++) {
                num = Math.random();
                if (num < 0.50) {
                      retu +=  ((int) (Math.random() * 100) + "").charAt(0) + "";
                } else if (num > 0.50) {
                    retu += characts[(int) (Math.random() * characts.length - 1)];
                }
            }
        }

        return retu;
    }

    public static String[] getCharacts() {
        return characts;
    }

    public static void setCharacts(String[] characts) {
        Password.characts = characts;
    }

    public static String[] getWirdchars() {
        return wirdchars;
    }

    public static void setWirdchars(String[] wirdchars) {
        Password.wirdchars = wirdchars;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isUpper() {
        return upper;
    }

    public void setUpper(boolean upper) {
        this.upper = upper;
    }

    public boolean isWird() {
        return wird;
    }

    public void setWird(boolean wird) {
        this.wird = wird;
    }
}
