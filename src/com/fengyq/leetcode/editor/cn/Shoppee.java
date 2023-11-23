package com.fengyq.leetcode.editor.cn;

import java.util.ArrayList;

public class Shoppee {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(50);
        list.add(50);

        int sum=0;
        for (int i = 0; i < list.size(); i++) {
            sum+=list.get(i);
        }

        ArrayList<Integer> res = new ArrayList<>();
        int requests = 1001;
        for (int i = 0; i < list.size(); i++) {
            res.add(requests * list.get(i) / sum);
        }

        int realReq = 0;
        for (int i = 0; i < res.size(); i++) {
            realReq+=res.get(i);
        }

        if(realReq < requests) {
            int req = res.get(0);
            res.set(0,req+requests-realReq);
        }

        System.out.println(res);

    }

}
