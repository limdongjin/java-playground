package com.limdongjin.ps.s.p1966;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Deque<String> documents = new LinkedList<>();
            HashMap<Integer, Integer> priorityMap = new HashMap<>();
            String target = null; // 몇번째 인쇄될지 찾아야하는 데이터
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                // documents 를 String List 로 설정하는 이유는 equal 한 요소간 구분이 되게 하기위함이다.
                String val = st.nextToken();
                documents.addLast(val);
                if(j == m) target = val;

                int ival = Integer.parseInt(val);
                priorityMap.put(ival, priorityMap.getOrDefault(ival, 0) + 1);
            }

            int ret = 0; // 몇번째 인쇄인지 저장
            while(!documents.isEmpty()){
                String doc = documents.removeFirst();
                if (canPrint(priorityMap, doc)) {
                    ret++;
                    priorityMap.put(Integer.parseInt(doc), priorityMap.get(Integer.parseInt(doc)) -1 );

                    // reference equality 를 비교하여 타겟 문서인지 확인한다.
                    if(doc == target) break;
                }else{
                    documents.addLast(doc);
                }
            }

            bw.write(ret+"\n");
//            bw.flush();
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean canPrint(final HashMap<Integer, Integer> priorityMap, final String doc) {
        for (Integer priority : priorityMap.keySet()) {
            if(priority > Integer.parseInt(doc) && priorityMap.get(priority) > 0) return false;
        }
        return true;
    }
}
