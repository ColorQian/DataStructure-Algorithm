package cc.codetop;

import java.io.*;
import java.util.Scanner;

public class BufferedReaderTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer s;
        s = br.read();
        bw.write(s);

        bw.flush();
        bw.close();
        br.close();
    }
}
