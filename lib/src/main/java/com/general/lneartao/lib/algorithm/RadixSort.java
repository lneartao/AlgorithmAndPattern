package com.general.lneartao.lib.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by lneartao on 2017/12/5.
 */

public class RadixSort {

    @SuppressWarnings("unchecked")
    public static void radixSortA(String[] arr, int stringLen) {
        final int BUCKETS = 256;
        ArrayList<String>[] buckets = new ArrayList[BUCKETS];
        for (int i = 0; i < BUCKETS; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (int pos = stringLen - 1; pos >= 0; pos--) {
            for (String s : arr) {
                buckets[s.charAt(pos)].add(s);
            }
            int idx = 0;
            for (ArrayList<String> thisBucket : buckets) {
                for (String s : thisBucket) {
                    arr[idx++] = s;
                }
                thisBucket.clear();
            }
        }
    }

    public static void main(String[] args) {
        List<String> lst = new ArrayList<>( );
        Random r = new Random( );

        final int LEN = 5;

        for( int i = 0; i < 100000; i++ )
        {
            String str = "";
            int len = LEN; // 3 + r.nextInt( 7 ); // between 3 and 9 characters

            for( int j = 0; j < len; j++ ) {
                str += (char) ('a' + r.nextInt(26));
            }

            lst.add( str );
        }

        String [ ] arr1 = new String[ lst.size( ) ];
        String [ ] arr2 = new String[ lst.size( ) ];

        lst.toArray( arr1 );
        lst.toArray( arr2 );

        long start, end;

        start = System.currentTimeMillis( );
        Arrays.sort( arr1 );
        end = System.currentTimeMillis( );
        System.out.println( "Elapsed: " + ( end - start ) );


        start = System.currentTimeMillis( );
//        countingRadixSort( arr2, LEN );
        end = System.currentTimeMillis( );
        System.out.println( "Elapsed: " + ( end - start ) );

        for( int i = 0; i < arr1.length; i++ ) {
            if (!arr1[i].equals(arr2[i])) {
                System.out.println("OOPS!!");
            }
        }
    }
}
