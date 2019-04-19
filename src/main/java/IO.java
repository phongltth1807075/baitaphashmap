import entity.Phim;
import entity.PhimStatic;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class IO {
    public static void main(String[] args) throws IOException {
        ArrayList<Phim> phims = new ArrayList<Phim>();
//        File file=new File("src/main/resources/IO.txt");
//        Scanner scanner=new Scanner(file);
//        while (scanner.hasNext()){
//            System.out.println(scanner.nextLine());
//        }
//        scanner.close();

//        FileInputStream fileInputStream=new FileInputStream(file);
//        InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
//        while (true){
//            int c= inputStreamReader.read();
//            if (c==-1){
//                break;
//            }
//            System.out.print((char)c);
//        }

        FileReader fileReader=new FileReader("src/main/resources/IO.txt");
        BufferedReader br=new BufferedReader(fileReader);
        String line;
        int count=0;
        while ((line=br.readLine())!=null){
            if (count==0){
                count++;
                continue;
            }
            System.out.println(line);
            String[] splitted=line.split("\\s{2,}");
            if (splitted.length==4){
                String day=splitted[0];
                String id=splitted[1];
                String title=splitted[2];
                int view= Integer.parseInt(splitted[3]);
                System.out.println("day:"+day);
                System.out.println("id:"+id);
                System.out.println("title:"+title);
                System.out.println("view:"+view);
                Phim phim=new Phim(day,id,title,view);
                phims.add(phim);
            }
        }
        HashMap<String, PhimStatic> statistic=new HashMap<String, PhimStatic>();
        for (Phim phim:
                phims) {
            int totalview=0;
            if (statistic.containsKey(phim.getId())){
                PhimStatic phimStatic=statistic.get(phim.getId());
                totalview = phimStatic.getView();
            }
            totalview=totalview + phim.getView();
            PhimStatic phimStatic=new PhimStatic(phim.getId(),phim.getTitle(),totalview);
            statistic.put(phim.getId(),phimStatic);
        }
        for (String id:
                statistic.keySet()) {
            System.out.println(id);
            PhimStatic phimStatic=statistic.get(id);
            System.out.println(phimStatic.getName());
            System.out.println(phimStatic.getView());
        }
    }
}
