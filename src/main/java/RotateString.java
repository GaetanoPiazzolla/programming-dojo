public class RotateString {

    private static boolean isRotation(String base, String rotation) {

        int start = base.indexOf(rotation.charAt(0));

        StringBuilder b = new StringBuilder();
        b.append(rotation, rotation.length() - start, rotation.length());
        b.append(base.substring(start));

        return b.toString().equals(base);
    }

    public static void main(String[] args) {

        System.out.println(isRotation("aaaabbbb", "bbbbaaaa"));

        System.out.println(isRotation("waterbottle", "erbottlewat"));

    }
}
