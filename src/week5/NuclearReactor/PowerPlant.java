package week5.NuclearReactor;

public class PowerPlant {
    private int output;

    public PowerPlant(int output ){
        this.output = output;
    }

    public int getOutput () {
        return output;
    }

    public void soundAlert(){
        System.out.println("                 uuuuuuu\n" +
                "             uu$$$$$$$$$$$uu\n" +
                "          uu$$$$$$$$$$$$$$$$$uu\n" +
                "         u$$$$$$$$$$$$$$$$$$$$$u\n" +
                "        u$$$$$$$$$$$$$$$$$$$$$$$u\n" +
                "       u$$$$$$$$$$$$$$$$$$$$$$$$$u\n" +
                "       u$$$$$$$$$$$$$$$$$$$$$$$$$u\n" +
                "       u$$$$$$\"   \"$$$\"   \"$$$$$$u\n" +
                "       \"$$$$\"      u$u       $$$$\"\n" +
                "        $$$u       u$u       u$$$\n" +
                "        $$$u      u$$$u      u$$$\n" +
                "         \"$$$$uu$$$   $$$uu$$$$\"\n" +
                "          \"$$$$$$$\"   \"$$$$$$$\"\n" +
                "            u$$$$$$$u$$$$$$$u\n" +
                "             u$\"$\"$\"$\"$\"$\"$u\n" +
                "  uuu        $$u$ $ $ $ $u$$       uuu\n" +
                " u$$$$        $$$$$u$u$u$$$       u$$$$\n" +
                "  $$$$$uu      \"$$$$$$$$$\"     uu$$$$$$\n" +
                "u$$$$$$$$$$$uu    \"\"\"\"\"    uuuu$$$$$$$$$$\n" +
                "$$$$\"\"\"$$$$$$$$$$uuu   uu$$$$$$$$$\"\"\"$$$\"\n" +
                " \"\"\"      \"\"$$$$$$$$$$$uu \"\"$\"\"\"\n" +
                "           uuuu \"\"$$$$$$$$$$uuu\n" +
                "  u$$$uuu$$$$$$$$$uu \"\"$$$$$$$$$$$uuu$$$\n" +
                "  $$$$$$$$$$\"\"\"\"           \"\"$$$$$$$$$$$\"\n" +
                "   \"$$$$$\"                      \"\"$$$$\"\"\n" +
                "     $$$\"                         $$$$\"\n");
    }
}
