package session1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        /*   HashSet<String> hs = new HashSet<>();
        hs.add("hello");
        hs.add("world");
        hs.add("hello");
        hs.add("world");
        for (String s: hs)
            System.out.println(s);


        */
        // hang cho
        PriorityQueue<Integer> numbers  = new PriorityQueue<>();
        numbers.add(4);
        numbers.add(2);
        numbers.add(1);
        System.out.println("numbers:" + numbers);
        int first  = numbers.peek();
        System.out.println("first:" + first);
        System.out.println("Total:"+ numbers.size());

        System.out.println("poll:"+numbers.poll()  + "remain:" + numbers.size());
        System.out.println("poll:"+numbers.poll()  + "remain:" + numbers.size());
        System.out.println("poll:"+numbers.poll()  + "remain:" + numbers.size());

        PriorityQueue<Student> st = new PriorityQueue<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getMark() - o1.getMark();
            }
        });

        st.add(new Student("aaa",1));
        st.add(new Student("bbb",3));
        st.add(new Student("ccc",2));
        st.add(new Student("ddd",0));
        Student s;
        while (st.size() > 0 ){
            s = st.poll();
            System.out.println("SV:" + s.getName() + " diem thi:" + s.getMark());
        }

        HashMap<String, Integer> hm = new HashMap<>();
        // gan kw voi int
        hm.put("good", 10);
        hm.put("bad",3);
        System.out.println("tieu chuan lam sv xuat sac la diem thi phai dat:" + hm.get("good"));
        System.out.println(hm.keySet());
        System.out.println(hm.values());
    }
}
