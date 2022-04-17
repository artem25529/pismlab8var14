package com.expertsoft.beans;

import com.expertsoft.model.Word;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.stream.Stream;

@ManagedBean(name = "computer", eager = true)
@RequestScoped
public class StringsComputer {
    private String str1;
    private String str2;
    private String res;

    public String compute() {
        String[] words1 = str1.trim().split(" ");
        String[] words2 = str2.trim().split(" ");

        int qty = Math.max(words1.length, words2.length);

        StringBuilder res = new StringBuilder();

        Stream.iterate(0, i -> i + 1)
                .limit(qty)
                .forEach(i -> {
                    if (i % 2 == 0) {
                        if (i < words2.length) {
                            res.append(words2[i]).append(' ');
                        }
                    } else {
                        if (i < words1.length) {
                            res.append(words1[i]).append(' ');
                        }
                    }
                });

        this.res = res.toString();

        return "compute";
    }

    private int countOddEvenWords(int qty, Word word) {
        if (word == Word.ODD && qty % 2 != 0) {
            return qty / 2 + 1;
        } else {
            return qty / 2;
        }
    }

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }
}
