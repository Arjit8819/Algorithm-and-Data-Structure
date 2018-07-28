package edu.neu.coe.info6205.assng4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arjit
 */
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
public class Birthdaycoupontest {
    @Test
	 public void hash1() {
		int[] xs = {50,72,83,61,94};
		Birthdayandcoupon.hash = new int[5];
		Birthdayandcoupon.m = 5;
		Birthdayandcoupon.TestCase(xs);
        assertEquals(Birthdayandcoupon.hash[0], 50);
        assertEquals(Birthdayandcoupon.hash[1], 61);
        assertEquals(Birthdayandcoupon.hash[2], 72);
        assertEquals(Birthdayandcoupon.hash[3], 83);
        assertEquals(Birthdayandcoupon.hash[4], 94);
	}
	
	@Test
	public void hash2() {
		int[] xs = {23,22,23,26,24};
		Birthdayandcoupon.hash = new int[5];
		Birthdayandcoupon.m = 5;
		Birthdayandcoupon.TestCase(xs);
        assertEquals(Birthdayandcoupon.hash[0], 0);
        assertEquals(Birthdayandcoupon.hash[1], 26);
        assertEquals(Birthdayandcoupon.hash[2], 22);
        assertEquals(Birthdayandcoupon.hash[3], 23);
        assertEquals(Birthdayandcoupon.hash[4], 24);
	}

}

//}
