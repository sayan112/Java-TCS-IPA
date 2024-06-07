/*
Create a class HeadSets with below attributes:

headsetName - String
brand-String
price - int
available- boolean

The above attributes should be private, write getters, setters and parameterized constructor as required.

Create class Solution with main method.
Implement two static methods - findTotalPriceForGivenBrand and findAvailableHeadsetWithSecondMinPrice in Solution class.

findTotalPriceForGivenBrand method:
--------------------------------------
The method will return the total price of Headsets from array of Headset objects for the given brand(String parameter passed).
If no Headsets with the given brand is present in the array of Headsets objects, then the method should return 0.

findAvailableHeadsetWithSecondMinPrice method:
-----------------------------------------------
This method will take array of Headset objects as an input parameter and returns the available Headset object with the
second lowest/minimum price from the given array of objects.

If no Headsets with the above condition is present in the array of Headsets objects, then the method should return null.

Note :
No two Headsets will have the same price.
All the searches should be case insensitive.

The above mentioned static methods should be called from the main method.

For findTotalPriceForGivenBrand method - The main method should print the returned total price as it is if the returned
value is greater than 0 or it should print "No Headsets available with the given brand".
Eg: 4500
where 4500 is the total Headsets price

For findAvailableHeadsetWithSecondMinPrice method - The main method should print the headsetsName and price from the
returned Headsets object if the returned value is not null.
If the returned value is null then it should print "No Headsets available".

Eg:Logitech Wired
1500
where Logitech Wired is the headsetName and 1500 is the price

Before calling these static methods in main, use Scanner object to read the values of four Headset objects referring
attributes in the above mentioned attribute sequence.
Next, read the value of String parameter for capturing brand.

Consider below sample input and output:

Input1:
----------------
boAt BassHeads
boAt
1220
true
Over Ear Wired
boAt
549
true
In Ear with Mic
JBL
450
true
Buds 2 Neo
RealMe
500
true
boAt

Output:
---------------
1769
Buds 2 Neo
500


Input2:
--------------------
boAt BassHeads
boAt
1220
false
Over Ear Wired
boAt
1549
false
In Ear with Mic
JBL
450
false
Buds 2 Neo
RealMe
500
false
boAt
Output:
--------------
2769
No Headsets available
--------------------------------------------------
Sample code snippet for reference:
Please use below code to build your solution.
--------------------------------------------------
import java.util.Scanner;
public class MyClass
{
public static void main(String[] args)
{
//code to read values
//code to call required method
//code to display the result
}
public static int findTotalPriceForGivenBrand ( required parameters to be added )
{
Restricted for circulation outside TCS Xplore 9
//method logic
}
public static HeadSets findAvailableHeadsetWithSecondMinPrice (required parameters to be
added )
//method logic
}

class HeadSets
{
//code to build the class
}
-------------------------------------------------
Note on using Scanner object:
Sometimes scanner does not read the new line character while invoking methods like nextInt(), nextDouble() etc.
Usually, this is not an issue, but this may be visible while calling nextLine() immediately after those methods.
Consider below input values:
1001
Savings
Referring below code:
Scanner sc = new Scanner(System.in);
int x = sc.nextInt();
String str = sc.nextLine(); -> here we expect str to have value Savings.Instead it may be "".
If above issue is observed, then it is suggested to add one more explicit call to nextLine() after
reading numeric value.

 */

import java.lang.reflect.Array;
import java.util.*;

public class Headsets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HeadSet[] hs = new HeadSet[4];
        for (int i = 0; i < hs.length; i++) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            boolean d = sc.nextBoolean();
            sc.nextLine();

            hs[i] = new HeadSet(a, b, c, d);
        }

        String brand = sc.nextLine();
        int ans = findTotalPrice(hs, brand);
        if (ans > 0) {
            System.out.println(ans);
        } else {
            System.out.println("No Headsets available with the given brand");
        }

        HeadSet[] result = findAvailableHeadset(hs);
        if (result.length > 0) {
            for (HeadSet h : result) {
                System.out.println(h.getName());
                System.out.println(h.getPrice());
            }
        } else {
            System.out.println("No Headsets available");
        }
    }

    public static int findTotalPrice(HeadSet[] hs, String brand) {
        int ans = 0;

        for (HeadSet h : hs) {
            if (h.getBrand().equalsIgnoreCase(brand)) {
                ans += h.getPrice();
            }
        }

        return ans;
    }

    public static HeadSet[] findAvailableHeadset(HeadSet[] hs) {
        HeadSet[] result = new HeadSet[0];
        int min = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (HeadSet h : hs) {
            if (h.getPrice() < min && h.getAvailable()) {
                second = min;
                min = h.getPrice();
            } else if (h.getPrice() > min && h.getPrice() < second && h.getAvailable()) {
                second = h.getPrice();
            }
        }

        for (HeadSet h : hs) {
            if (h.getPrice() == second) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = h;
            }
        }

        return result;
    }
}

class HeadSet {
    private String name;
    private String brand;
    private int price;
    private boolean available;

    public HeadSet(String name, String brand, int price, boolean available) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean getAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}