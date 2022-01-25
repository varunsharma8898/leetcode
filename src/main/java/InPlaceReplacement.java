package com.varun.selfstudy.broadcom.interview;

import org.junit.Assert;

public class InPlaceReplacement {

    public static void main(String[] args) {

        char[] array = new char[] { 'M', 'L', 'S', 'S', 'L', 'S', 'M' };
        InPlaceReplacement obj = new InPlaceReplacement();
        obj.replace(array);
        Assert.assertArrayEquals(new char[] { 'S', 'S', 'S', 'L', 'L', 'M', 'M' }, array);
    }

    public void replace(char[] array) {

        int sCounter = 0, mCounter = array.length - 1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 'S') {
                char temp = array[sCounter];
                array[sCounter] = 'S';
                array[i] = temp;
                sCounter++;
            } else if (array[i] == 'M') {
                char temp = array[mCounter];
                array[mCounter] = 'M';
                array[i] = temp;
                mCounter--;
            }
        }
    }

    /**
     *
     * Given an array of strictly the characters 'S', 'M', and 'L',
     * segregate the values of the array so that all the Ss come first,
     * the Ls come second, and the Ms come last.
     * You can only swap elements of the array.
     * This should be performed in linear time and in-place.
     *
     * For example,
     *
     * given an array ['M', 'L', 'S', 'S', 'L', 'S', 'M'],
     *
     * it should become ['S', 'S', 'S', 'L', 'L', 'M', 'M'].
     * */

}
