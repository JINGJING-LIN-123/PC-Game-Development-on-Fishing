public class SListTest {
    public static void main(String[] args) {
        SList list = new SListImpl();
        list.add("java");
        list.add("is");
        list.add("really");
        list.add("hard!");

        for (int i = 0; i < list.size(); i++) {
          System.out.println(list.get(i));
        }

        list.remove(2);

        System.out.println(list);
        System.out.println(list.oddWords());
        System.out.println(list.evenWords());


    }
}
