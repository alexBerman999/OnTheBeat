package com.onthebeat;

public class Test {
	
	public static void main (String[] args) {
		Score test = new Score ("Test", 4, 4, 100);
		
		//System.out.println(test.measureMax);
		test.addNote(16, false);
		test.addNote(900, false);
		test.addNote(300, false);
		test.addNote(900, false);
		test.addNote(300, false);
		test.addNote(1200, false);
		test.addNote(740, false);
		test.addNote(300, true);
		test.addNote(150, false);
		test.addNote(160, false);
		test.addNote(2400, false);
		System.out.println(test.last.spaceLeft);
		//test.format();
		
		for (Measure ptr1 = test.first; ptr1 != null; ptr1 = ptr1.next) {
			for (Note ptr2 = ptr1.first; ptr2 != null; ptr2 = ptr2.next) {
				System.out.print(ptr2.type+" ");
				if (ptr2.rest)
					System.out.print("r ");
				if (ptr2.dot)
					System.out.print("d ");
				if (ptr2.tie)
					System.out.print("t ");
				System.out.print("==> ");
			}
			System.out.println("");
		}
		

		/* attempt = new Note (false, 150, 600);
		System.out.print(attempt.type+" ");
		if (attempt.rest)
			System.out.print("r ");
		if (attempt.dot)
			System.out.print("d ");
		if (attempt.tie)
			System.out.print("t ");
		System.out.print("==> ");
		System.out.println("");
		
		Measure outer = new Measure (2400, 600, 4);
		
		outer.addNote(600, false);
		outer.addNote(728, false);
		
		for (Note ptr2 = outer.first; ptr2 != null; ptr2 = ptr2.next) {
			System.out.print(ptr2.type+" ");
			if (ptr2.rest)
				System.out.print("r ");
			if (ptr2.dot)
				System.out.print("d ");
			if (ptr2.tie)
				System.out.print("t ");
			System.out.print("==> ");
		}*/
	}
}
