public class JavaBasic {
    public static void main(String[] args) {
        int intA = 10;
        int intB = 20;
        double  doubleA = 10;
        double  doubleB = 2.5;
        char charA = 'E';
        char charB = 'f';
        boolean boolean1 = true;
        boolean boolean0 = false;
        byte byteB = 127;
        byte byteC;

        //=============== Целые числа =======================================
        System.out.println("Целые числа:");
        System.out.println(intA + "+" + intB + "=" + (intA + intB));
        System.out.println(intA + "-" + intB + "=" + (intA - intB));
        System.out.println(intA + "*" + intB + "=" + (intA * intB));
        System.out.println(intA + "/" + intB + "=" + (intA / intB));
        System.out.println(intA + "%" + intB + "=" + (intA % intB));

        System.out.println("intA++ = " +  (intA++));
        System.out.println("++intB = " +  (++intB));

        //=============== Дробные числа =======================================
        System.out.println();
        System.out.println("Дробные числа:");
        System.out.println(doubleA + "+" + doubleB + "=" + (doubleA + doubleB));
        System.out.println(doubleA + "-" + doubleB + "=" + (doubleA - doubleB));
        System.out.println(doubleA + "*" + doubleB + "=" + (doubleA * doubleB));
        System.out.println(doubleA + "/" + doubleB + "=" + (doubleA / doubleB));
        System.out.println(doubleA + "%" + doubleB + "=" + (doubleA % doubleB));

        System.out.println("doubleA++ = " +  (doubleA++));
        System.out.println("++doubleB = " +  (++doubleB));

        //=============== Символьные =======================================
        System.out.println();
        System.out.println("Символьные:");
        System.out.println(charA + "+" + charB + "=" + (charA + charB));
        System.out.println(charA + "-" + charB + "=" + (charA - charB));
        System.out.println(charA + "*" + charB + "=" + (charA * charB));
        System.out.println(charA + "/" + charB + "=" + (charA / charB));
        System.out.println(charA + "%" + charB + "=" + (charA % charB));

        System.out.println("charA++ = " +  (charA++));
        System.out.println("++charB = " +  (++charB));


        //=============== Логические =======================================
        System.out.println();
        System.out.println("Логические:");
        System.out.println(boolean1 + "==" + boolean0 + " -> " + (boolean1 == boolean0));
        System.out.println(boolean1 + "!=" + boolean0 + " -> " + (boolean1 != boolean0));
        System.out.println(boolean1 + "&&" + boolean0 + " -> " + (boolean1 && boolean0));
        System.out.println(boolean1 + "||" + boolean0 + " -> " + (boolean1 || boolean0));
        System.out.println(boolean0 + "||" + boolean0 + " -> " + (boolean0 || boolean0));
        System.out.println("!" + boolean1 + " -> " + (!boolean1));
        System.out.println("!" + boolean0 + " -> " + (!boolean0));

        System.out.println();
        System.out.println(intA + ">" + intB + " -> " + (intA > intB));
        System.out.println(intA + "<" + intB + " -> " + (intA < intB));

        //=============== Переполнение =======================================
        System.out.println();
        System.out.println("Переполнение:");
        byteC= (byte) (byteB + byteB);
        System.out.println(byteB + "+" + byteB + "=" + (byteC));

        //=============== Комбинации типов данных =======================================
        System.out.println();
        System.out.println("Комбинации типов данных:");
        System.out.println(intA + "+" + doubleB + "=" + (intA + doubleB));
        System.out.println(intA + "-" + doubleB + "=" + (intA - doubleB));
        System.out.println(intA + "*" + doubleB + "=" + (intA * doubleB));
        System.out.println(intA + "/" + doubleB + "=" + (intA / doubleB));
        System.out.println(intA + "%" + doubleB + "=" + (intA % doubleB));
        System.out.println();
        System.out.println(doubleA + "+" + intB + "=" + (doubleA + intB));
        System.out.println(doubleA + "-" + intB + "=" + (doubleA - intB));
        System.out.println(doubleA + "*" + intB + "=" + (doubleA * intB));
        System.out.println(doubleA + "/" + intB + "=" + (doubleA / intB));
        System.out.println(doubleA + "%" + intB + "=" + (doubleA % intB));
    }
}
