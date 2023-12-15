package interviewPre;

import org.testng.annotations.Test;

public class reverseString {

   String givenString = "cognizant";
   String rev = "";

   @Test
    public void reverseMystring()
   {
      int n =  givenString.length();

      for(int i=n-1;i>=0;i--)
      {
          rev  = rev+givenString.charAt(i);
      }
       System.out.println("My Reverse String is: "+rev);
   }


   @Test
   public void useCharArray()
   {
      char a[]  = givenString.toCharArray();
      int m = a.length;

      for (int i =m-1;i>=0;i--)
      {
          rev=rev+a[i];
      }
       System.out.println("This is using char array: "+ rev.toString());
   }

   @Test
   public void usingStringBuffer()
   {
       StringBuffer str = new StringBuffer(givenString);
       System.out.println(str.reverse());
   }
}
