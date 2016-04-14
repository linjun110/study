package com.linjun.language.java;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        long a = 0l;
        long i = 0l;
        long j = 0l;
        long k = 0l;
        while(i++ < 1000000000){
            while(j++ < 1000000000){
                while(k++ < 1000000000){
                    a = 1;
                }
            }
        }
        System.out.println( "Hello World!" );
    }
}
