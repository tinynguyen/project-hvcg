package com.congdat.notaryweb.NotaryWeb;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestBCrypt {
		@Test
		public void gen_bcrypt() {

				System.out.println(new BCryptPasswordEncoder().encode("congdat"));
		}


}
