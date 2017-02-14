/* NetIds: dm797. Time spent: hh hours, mm minutes. */

/** A collection of static String utility functions.
 * All methods assume that String parameters are non-null.
 *
 * If any method is called with arguments that do not satisfy the preconditions,
 * the behavior is undefined (it can do anything you want). For example, you
 * could (but do not have to) use assert statements to test preconditions.
 */
public class A2 {
    /* Implementation notes:
     *
     * Wherever possible, prefer library functions to writing your own loops.
     *
     * The more complicated your loops become, the more important it is to explain
     * the logic in comments. We don't explain break and continue. We prefer that
     * you don't use them.
     *
     * When writing comments within a method body, you may find it useful to
     * use multi-line comments to describe WHAT the code doing, and single-line
     * comments to describe HOW it is doing it. For example:
     *
     *    /* Remove the unfrobnicatable whizbangs * /
     *    for (...)
     *        // NOTE: a whizbang is frobnicatable if it has two or more tails
     *        ...
     *
     *    /* Frobnicate all the remaining whizbangs * /
     *    for (...)
     *        ...
     */

    /* Notes on Java if statements and loops:
     *
     * Write an if statement like this:
     *
     *     if (boolean-expression) {
     *         do this if boolean-expression is true
     *     }
     *
     * Write an if-else statement like this:
     *
     *     if (boolean-expression) {
     *         do this if boolean-expression is true
     *     } else {
     *         do this if boolean-expression is false
     *     }
     *
     * Write a while-loop like this:
     *
     *    while ( boolean-expression ) {
     *        repetend (the loop body, "the thing to be repeated")
     *    }
     *
     * To execute the while-loop, do the following:
     *
     *   1. Evaluate the boolean-expression; if it is false, stop.
     *   2. Execute the repetend.
     *   3. Continue again at step 1.
     *
     * Write a for-loop to do-something several times, with i having values in
     * m..n-1 (i.e. with i being m, m+1, m+2, ..., n-1). 
     *
     *    for (int i= m; i < n; i= i+1) {
     *        repetend
     *    }
     *
     * The for-loop above is equivalent to the while-loop below, except that
     * local variable i is NOT usable after the loop; its scope is its assignment
     * together with the loop.
     *
     *    int i= m;
     *    while (i < n) {
     *        repetend
     *        i= i+1;
     *    }
     */

    /** Return either s1 + s2 or s1 - s2, depending on b.
     *  If b is true, return the sum, otherwise return the difference.
     */
    public static int sumDif(boolean b, int s1, int s2) {
        // This method is already implemented; it is here to give you something
        // to test, and to show you different ways of writing return statements.
        if (b) {
            int s;
            s = s1 + s2;
            return s;

            // equivalently:
            // int s = s1 + s2;
            // return s;

            // or simply:    return s1 + s2;
        }

        // b is false;
        return s1 - s2;
    }

    /** Return true if the first half of s is the same as the second half of s.
     *  Examples: For s = "" return true
     *            For s = "xxx" return false  (if the length is odd, it's false)
     *            For s = "xxxx" return true
     *            For s = "hellohello" return true
     *            For s = "helloworld" return false
     */
    public static boolean isDoubled(String s) {
    	// TODO 1: There is no need for a loop. Do not use a loop.
    	// Use s1.equals(s2) to test for equality of strings s1 and s2.
    	// Do not use s1 == s2.
    	String s1 = "", s2 = "";
    	int length = s.length();
    	if(length == 0){
    		return true;
    	}else if(length % 2 != 0){
    		return false;
    	}else{
    		s1 = s.substring(0,(length/2-1));
    		s2 = s.substring((length/2),(length-1));
    		if(s1.equals(s2)){// if two strings are the same,equals() return true
    			return true;}
    		else return false;}
    }

    /** Return s with its characters reversed.
     *  Examples: if s = "" return ""
     *            if s = "b" return "b"
     *            if s = "abc", return "cba"
     *            if s = "xxx", return "xxx"
     */
    public static String reverse(String s) {
        // TODO 2:
    	int i = s.length();
    	String rs="";
    	for (i = i-1;i >= 0;i--){
    		rs = rs + s.charAt(i);
    	}
        return rs;
    }

    /** Return s but with each occurrence of a character in input replaced
     *  by the corresponding character in output.
     *  A character that does not appear in input is unchanged.
     *
     * Precondition: input and output are the same length.
     *               No character in input appears in output (otherwise,
     *               the idea of replacement might be ambiguous, depending
     *               on the order in which replacements are done).
     *
     * Examples: encode("hello world", "", "")       = "hello world"
     *           encode("hello world", "abc", "lmn") = "hello world"
     *           encode("hello world", "hod", "xyz") = "xelly wyrlz"
     *           encode("hello world", "helowrd", ".......") = "..... ....."
     */
    public static String encode(String s, String input, String output) {
    	// TODO 3 This needs only ONE for-loop with a single statement in the loop
    	//      body. Look for a suitable String method!
    	for (int i = 0; i < input.length();i++){
    		s = s.replace(input.charAt(i),output.charAt(i));
    	}
    	return s;
    }

    /** Return the shortest substring x of s such that s = x + x + 鈰� + x.
     * Examples: For s = "" return ""
     *           For s = "xxxxxxxxx" return "x"
     *           For s = "xyxyxyxy" return "xy"
     *           For s = "hellohellohello" return "hello"
     *           For s = "hellohelloworld" return "hellohelloworld"
     *           For s = "hellohel" return "hellohel"
     */
  static boolean repeated(String s,String sub,int count){
    	String temp = "";
    	for (int i = 0; i < count; i++){
    		temp += s.substring(0,sub.length());
    	}
    	return s.equals(temp);
    }
    
  public static String deduplicate(String s) {
	  //TODO This, no doubt, requires nested loops But you can add
	  // another function, with a suitable specification, of course, in
	  // order to remove the need for nested loops.
	  String t = "";//current substring that is being checked
	  String dup = ""; //shortest substring found

	  if(s == null || s.length() ==1 ) 
		  dup = s;

	  for (int i = 1; i < s.length();i++){
		  if (s.charAt(0) == s.charAt(i)){//find the repeated first letter
			  if(s.length() % i == 0){ //i become length of repeated string
				  int c = s.length() / i;//number of divided substrings
				  t = s.substring(0, i);
				  if (repeated(s,t,c)) {
					  dup = t;
					  return dup;
				  }
			  }
		  }else dup = s;

	  }
	  return dup;
  }


    /** Interpret a string as a formula and evaluate it.
     *
     * Formulas consist of a series of numbers separated by the
     * operators '+' or '-'.  Formulas may  contain space characters
     * between the numbers and the operators.
     *
     * Precondition: s is a valid formula and contain at least one number
     *
     * Examples: evaluate("3")             returns 3
     *           evaluate("3 + 4")         returns 7
     *           evaluate("100 - 25+50")   returns 125
     *           evaluate("9")             returns 9
     *           evaluate("   7   +   7   +    7  ") returns 21
     */
 static int operator(char a){
	  switch(a){
	  case '+': return 1;
	  case '-': return -1;
	  default: return 0;
	  }
  }
  
  public static int evaluate(String s) {
	  // TODO You can use Integer.parseInt to convert a string
	  // (like "12345") to the corresponding integer (12345).
	  s = s.replace(" ","");//remove any space characters
	  if (s.length() == 1) return Integer.parseInt(s);

	  int result = 0; 
	  int num = 0;//the current number
	  int j = s.length()-1;//index to the end of the current number,backwards
	  System.out.println(" s="+s );
	  for (int i = s.length()-1; i >= 0; i--){
		  System.out.println("loop i="+i+" j="+j);
		  System.out.println(" opt="+operator(s.charAt(i)));
		  switch (operator(s.charAt(i))){ 
		  case 1: 
			  result += num;
			  j = i-1;
			  System.out.println(" Addition: num="+num+" result="+result+" i="+i+" j="+j);
			  break;
		  case -1:
			  result -= num;
			  j = i-1;
			  System.out.println(" Subtraction: num="+num+" result="+result+" i="+i+" j="+j );	  
			  break;
		  default:		
//			  System.out.println(" No operator: num="+num+" result="+result+" i="+i+" j="+j );
			  num = Integer.parseInt(s.substring(i, j+1));
			  System.out.println(" No operator: num="+num+" result="+result+" i="+i+" j="+j );
		  }	  
		  
		  if (i == 0 && num != 0) {/*reached end of search*/
		  /*add the first number in the string to result*/
			  result += num;
		  }
	  }
	  System.out.println(" result="+result );
	  return result;}
}

